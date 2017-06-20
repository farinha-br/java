function add() {
	$.ajax({
		type: "GET",
		url: "forms/add.html",
		dataType : "text",
		success : function(result) {
			$("#sBody").html(result); 
		},
	});
}

function page(url) {
	var ppage = $("#page").val();
	$.ajax({
		type: "GET",
		url: "service/page.php" + url,
		dataType : "text",
		data: { page: ppage },
		success : function(result) {
			$("#sBody").html(result); 
		},
	});
}

function insert() {
	var pname = $("#name").val();
	var pplace = $("#place").val();
	$.ajax({
		type: "POST",
		url: "service/insert.php",
		dataType : "text",
		data: { name: pname, place: pplace },
		success : function(result) {
			$("#sBody").html(result); 
		},
	});
}

function update() {
	var pname = $("#fname").val();
	var pplace = $("#fplace").val();
	var pid = $("#fid").val();
	$.ajax({
		type: "POST",
		url: "service/update.php",
		dataType : "text",
		data: { id: pid, name: pname, place: pplace },
		success : function(result) {
			$("#sBody").html(result); 
		},
	});
}

function sdelete() {
	var pid = $("#fid").val();
	$.ajax({
		type: "POST",
		url: "service/delete.php",
		dataType : "text",
		data: { id: pid },
		success : function(result) {
			$("#sBody").html(result); 
		},
	});
}

function edit(id) {
	$.ajax({
		type: "GET",
		url: "service/edit.php?fid=" + id,
		dataType : "text",
		success : function(result) {
			$("#sBody").html(result); 
		},
	});
}
