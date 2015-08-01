<!DOCTYPE html>
<html>
<head lang="en">
</head>

<body>
<?php

$p_id = $_GET['id'];

$pdcts = array( 
	
	"020" => array("020","Camera Mirrorless","550.00"),
	"350" => array("350","Mobile Phone","230.00"),
	"230" => array("230","Mouse USB","11.99"),
	"125" => array("125","TV 50'","780.00"),
	"780" => array("780","HD 1T","120.00"),
	"359" => array("359","Keyboard USB","17.50"),
	"273" => array("273","Monitor 21'","150.00"),
	"215" => array("215","Sound Speaker","9.70"),
	"550" => array("550","BlueRay Player","105.00")
);
?>
<h2>Product Description</h2>
<hr/>
<form method="post" action="cart.php">
<input type=hidden name="id" name="id" value="<?php echo $p_id; ?>">	
Quantity:<input type=text size=2 maxlength=2 name="qt" id="qt" value="1">&nbsp;
<?php

$r = $pdcts[$p_id];
echo $r[0] . " - " . $r[1] . " - " . $r[2] ;
?>
<br/><br/><input type=submit name="add" value="Buy"><br/><br/>
</form>
<a href="index.php">Return</a>
</body>
</html>