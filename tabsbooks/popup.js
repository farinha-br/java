function getTabs() {
	rtabs = "<!doctype html>\n<html>\n<body>\n";
	chrome.tabs.query({}, function(tabs) {
		for (k=0; k<tabs.length; k++) {
			rtabs += "<a target='blank' href='" + tabs[k].url + "'>" + tabs[k].title + "</a><br/>\n";
		}
		document.getElementById('txt').value = rtabs+"</body>\n</html>";		
	});
}

function copyToClipboard() {
	document.getElementById('txt').focus();
	document.getElementById('txt').select();
	document.execCommand('copy');	
}
	
function show(tree) { 
	document.getElementById("txt").value = JSON.stringify(tree, null, 2); 
}

function getBooks() {
	chrome.bookmarks.getTree(show); 
}

document.addEventListener('DOMContentLoaded', function () {
	document.getElementById('tab').addEventListener('click', getTabs);
	document.getElementById('book').addEventListener('click', getBooks);
	document.getElementById('clip').addEventListener('click', copyToClipboard);
});

