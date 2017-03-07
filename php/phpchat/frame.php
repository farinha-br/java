<!doctype html>
<html>
<head lang="pt-br">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
</head>

<body>

<?php
$array = Array();
$array = unserialize(file_get_contents('chat.array'));

$x = count($array);
if ($x>25) {
	array_shift($array);
	array_shift($array);
}

if (isset($_GET["item"])) {
	if ($_GET['item'] != "") {
		array_push($array, $_GET['name'] . ": " . $_GET["item"]);
		file_put_contents('chat.array', serialize($array));
		echo "<script>parent.afterSubmit();</script>";
	}
}	
?>

<textarea id="txt" rows=20 cols=80>
<?php
foreach ( $array as &$it) echo $it . "\n";
?>
</textarea>

<script>
txt.scrollTop = txt.scrollHeight;
</script>

</body>
</html>