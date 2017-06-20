<?php

$rname = $_POST['name'];
$rplace = $_POST['place'];

$link = mysqli_connect('localhost', 'root', '', 'test');
	
if (mysqli_connect_errno())
  echo "Failed to connect to MySQL: " . mysqli_connect_error();

$sql = "insert into people (name, place) values ('" . $rname . "', '" . $rplace . "')";
$query = mysqli_query($link, $sql);
	
mysqli_close($link);

echo "Name: " . $rname;
echo "<br/>City: " . $rplace;

?>