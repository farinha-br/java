var gcm = function () {
	
function getMessageEncoding(txt) {
    let message = txt;
    let enc = new TextEncoder();
    return enc.encode(message);
}

function getKeyMaterial(xkey) {
    let password = xkey;
    let enc = new TextEncoder();
    return window.crypto.subtle.importKey(
      "raw", 
      enc.encode(password), 
      {name: "PBKDF2"}, 
      false, 
      ["deriveBits", "deriveKey"]
    );
}

function getKey(keyMaterial, salt) {
    return window.crypto.subtle.deriveKey(
      {
        "name": "PBKDF2",
        salt: salt, 
        "iterations": 500000,
        "hash": "SHA-256"
      },
      keyMaterial,
      { "name": "AES-GCM", "length": 256},
      true,
      [ "encrypt", "decrypt" ]
    );
}

async function Encrypt(txt, skey, callback) {
    let keyMaterial = await getKeyMaterial(skey);
    salt = window.crypto.getRandomValues(new Uint8Array(16));
    let key = await getKey(keyMaterial, salt);
    iv = window.crypto.getRandomValues(new Uint8Array(12));
    let encoded = getMessageEncoding(txt);

    ciphertext = await window.crypto.subtle.encrypt(
      {
        name: "AES-GCM",
        iv: iv
      },
      key,
      encoded
    );

    let hexencoded = bytesToHexString(salt) + bytesToHexString(iv) + bytesToHexString(ciphertext);
    callback(hexencoded);
}
  
async function Decrypt(enc, skey, callback) {
	salt = hexStringToUint8Array(enc.substr(0, 32));
	iv = hexStringToUint8Array(enc.substr(32, 24));
	ciphertext = hexStringToUint8Array(enc.substr(56));
	
    let keyMaterial = await getKeyMaterial(skey);
    let key = await getKey(keyMaterial, salt);

    try {
      let decrypted = await window.crypto.subtle.decrypt(
        {
          name: "AES-GCM",
          iv: iv
        },
        key,
        ciphertext
      );

      let dec = new TextDecoder();
      callback(dec.decode(decrypted));
    } catch (e) {
      
    }
}

function bytesToHexString(bytes) {
    if (!bytes)
        return null;

    bytes = new Uint8Array(bytes);
    var hexBytes = [];

    for (var i = 0; i < bytes.length; ++i) {
        var byteString = bytes[i].toString(16);
        if (byteString.length < 2)
            byteString = "0" + byteString;
        hexBytes.push(byteString);
    }
    return hexBytes.join("");
}

function hexStringToUint8Array(hexString) {
    if (hexString.length % 2 != 0)
        throw "Invalid hexString";
    var arrayBuffer = new Uint8Array(hexString.length / 2);

    for (var i = 0; i < hexString.length; i += 2) {
        var byteValue = parseInt(hexString.substr(i, 2), 16);
        if (byteValue == NaN)
            throw "Invalid hexString";
        arrayBuffer[i/2] = byteValue;
    }
    return arrayBuffer;
}

return {

	encrypt: function (str, key, callback) {
		Encrypt(str, key, callback);
	},
		
	decrypt: function (enc, key, callback) {
		Decrypt(enc, key, callback);
	}
	
}

};
