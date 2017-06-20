<?php

$rid = $_POST['id'];

$link = mysqli_connect('localhost', 'root', '', 'test');

$result = mysqli_query($link, "SELECT * FROM people WHERE id=" . $rid);

$num_rows = mysqli_num_rows($result);

if ($num_rows>0) {
	$sql = "delete from people where id=$rid;";
	$query = mysqli_query($link, $sql);
	echo "<p/>Deleted</p>";
}
else {
	echo "<p>Not found</p>";
}

mysqli_close($link);

?>