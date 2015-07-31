<!DOCTYPE html>
<html>
<head lang="en">
<title>Shopping List</title>
<style>
	body { margin: 100px; fonta-family: verdana; font-size: 16px;
		}
</style>		
</head>

<body>

<h1>The Sopping List</h1>
<br/>

<?php foreach($mylist as $item) { ?>
	<li><?php echo $item; ?>
<?php } ?>

</table>

</body>
</html>