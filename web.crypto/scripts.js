var colors = ["#959595", "#FF0000", "#939300", "#00FF00", "#008000", "#0000FF", "#00FFFF", "#FF00FF", "#800000", "#000000"];

var $ = id => document.getElementById(id);

function calc_crc() {
	var hash = crc32(pswd.value);
	var color = hash % 9;
	hash3 = hash + " ";
	crc32.value = hash3.substr(0,3);
	$('crc32').style.color = colors[color];
}

function crc32(str) {
	const table = [];
	for (let i = 0, n = i; i <= 255; i++, n = i) {
		for (let j = 0; j <= 7; j++) {
			if (n & 1) {
			  n = 0xEDB88320 ^ (n >>> 1);
			} else {
			  n >>>= 1;
			}
		}
	table.push(n);
	}
	crc = -1; 
	for (let c of Array.from(str)) {
	  crc = (crc >>> 8) ^ table[(crc ^ c.charCodeAt(0)) & 255];
	}
	return (crc ^ -1) >>> 0;
}
