<div id="spage">
<table width=500>

<?php

$link = mysqli_connect('localhost', 'root', '', 'test');

$k = 0;
$rec_limit = 10;

$sql = "SELECT count(id) FROM people";

$retval = mysqli_query($link, $sql );

$row = mysqli_fetch_array($retval); 

$rec_count = $row[0];
       
if (isset($_GET['page'])) {
   $page = $_GET['page'] + 1;
   $offset = $rec_limit * $page;
} else {
   $page = 0;
   $offset = 0;
}

$left_rec = $rec_count - ($page * $rec_limit);

$sql = "SELECT * FROM people " . " LIMIT $offset, $rec_limit";

$res = mysqli_query($link, $sql);

while ($row = mysqli_fetch_assoc($res)) {
	echo "<tr><td>" . $row['name'] . "</td><td>" . $row['place'];
	echo "</td><td><img onclick=\"edit(" . $row['id'];
	echo ");\" src='img/edit.gif'></td></tr>";
	$k++;
}

$k = 10 - $k;
   
for ($j=0; $j<$k; $j++) {
	echo "<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>";
}
	
echo "</table><br/>";

if ($page>0 && ($left_rec >= 10)) {
   $last = $page-2;
   echo "<input type=button onclick=\"page('?page=$last');\" value='Last'> | ";
   echo "<input type=button onclick=\"page('?page=$page');\" value='Next'>";

} else if ($page==0) {
   echo "<input type=button value='Last' disabled> | ";
   echo "<input type=button onclick=\"page('?page=$page');\" value='Next'>";

} else if (($left_rec < $rec_limit) && ($left_rec >= 0)) {
   $last = $page-2;
   echo "<input type=button onclick=\"page('?page=$last');\" value='Last'>";
   echo " | <input type=button value='Next' disabled>";
}

?>
</div>