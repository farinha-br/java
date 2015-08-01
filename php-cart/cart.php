<?php
session_start();
?>
<!DOCTYPE html>
<html>
<head lang="pt-br"),"

</head>

<body>
<?php

$_SESSION["cart"][0] = array("qtty", "code", "desc", "price");


$p_id = $_POST['id'];
$p_qt = $_POST['qt'];

$pdcts = array( 
	
	"020" => array("020","Camera Mirrorless","550.00"),
	"350" => array("350","Mobile Phone QuadCore","230.00"),
	"230" => array("230","Mouse USB","11.99"),
	"125" => array("125","TV 50'","780.00"),
	"780" => array("780","HD 1T","120.00"),
	"359" => array("359","Keyboard 102","17.50"),
	"273" => array("273","Monitor 21'","150.00"),
	"215" => array("215","Pendrive 16GB","9.70"),
	"550" => array("550","BlueRay Player","105.00")
);
?>
<h2>Shopping Cart</h2>
<hr/>

<?php

$r = $pdcts[$p_id];
$last = count($_SESSION["cart"])+1;
if ($_POST["add"]) {
	$_SESSION["cart"][$last] = array($r[0], $r[1], $r[2], $p_qt);
}	

$r = $_SESSION["cart"];
$soma = 0;
foreach ( $r as $item => $value) {
	if ($item > 0) {
		echo $r[$item][3] . " - " . $r[$item][1] . " - " . $r[$item][2] . "&nbsp; &nbsp; &nbsp; <a href='rem.php?pos=$item'>x</a><br/>";
		$soma = $soma + $r[$item][2];
	}
}	
echo "<hr/>Total: " . $soma;
?>
<br/><br/><br/>
<a href="index.php">Continue Shopping</a>
<br/><br/><br/>
<a href="delete.php">Empty Cart</a>
</body>
</html>