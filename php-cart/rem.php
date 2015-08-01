<?php
session_start();
$_SESSION["cart"][0] = array("qtty", "code", "desc", "price");
$item = $_GET['pos'];
unset($_SESSION["cart"][$item]);
$_SESSION["cart"] = array_values ($_SESSION["cart"]);
header('Location: cart.php'); 
?>
