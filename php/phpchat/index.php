<!doctype html>
<html>
<head lang="pt-br">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<style>
body  { 
	margin: 20px; 
	font-family: verdana; 
	font-size: 12px; 
	background: #F5F8FA; 
}
#frame1 { 
	border: 0px; 
}
</style>
</head>

<body>

<iframe id="frame1" name="frame1" width="700" height="350" src="frame.php"></iframe>

<form target="frame1" name="f1" id="f1" method="get" action="frame.php">
</form>

<form target="frame1" name="f2" id="f2" method="get" action="frame.php">
Nome:<input type="text" id="name" name="name" value="Jack"><br/>
<textarea rows="3" cols="70" id="item" name="item" onkeydown="if (event.keyCode == 13) { this.form.submit(); return false; }"></textarea>
<input type="submit" value="Send" onclick="xdoSubmit();">
</form>

<script>
function afterSubmit() {
	document.getElementById('item').value = "";
	document.getElementById('item').focus();
}	
function redo() {
	document.getElementById("f1").submit();
	setTimeout(function(){ redo(); }, 5000);
}
setTimeout(function(){ redo(); }, 5000);
</script>

</body>
</html>
