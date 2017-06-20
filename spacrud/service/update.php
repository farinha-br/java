<?php

$rid = $_POST['id'];
$rname = $_POST['name'];
$rplace = $_POST['place'];

$link = mysqli_connect('localhost', 'root', '', 'test');
	
$result = mysqli_query($link, "SELECT * FROM people WHERE id=" . $rid);

$num_rows = mysqli_num_rows($result);

if ($num_rows>0) {
	$sql = "update people set name='" . $rname . "', place='" . $rplace . "'  where id=$rid;";
	$query = mysqli_query($link, $sql);
	echo "<p/>Updated</p>";
}
else {
	echo "<p>Not found</p>";
}

mysqli_close($link);

echo "Name: " . $rname;
echo "<br/>City: " . $rplace;

?>