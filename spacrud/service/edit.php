<table>
<?php

$rid = $_GET['fid'];
$link = mysqli_connect('localhost', 'root', '', 'test');

$result = mysqli_query($link, "SELECT * FROM people WHERE id=" . $rid);

$row = mysqli_fetch_assoc($result);

echo "<tr><td>Name:" . "</td><td><input type=text name='fname' id='fname' value='" . $row['name'] . "'></td></tr>";
echo "<tr><td>City:" . "</td><td><input type=text name='fplace' id='fplace' value='" . $row['place'] . "'></td></tr>";
echo "<input type=hidden name='fid' id='fid' value='" . $row['id'] . "'>";
echo "<tr><td>&nbsp;</td><td><input type=button name='fsave' value='Update' onclick='update();'></td></tr>";
echo "<tr><td>&nbsp;</td><td><input type=button name='fdel' value='Delete' onclick='sdelete();'></td></tr>";

mysqli_free_result($result);
mysqli_close($link);	
	 
?>
</table>