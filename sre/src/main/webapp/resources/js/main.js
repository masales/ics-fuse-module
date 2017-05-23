function drawTable(data) {
	$("#dataTable").find("tr:gt(0)").remove();
	for (var i = 0; i < data.length; i++) {
		drawRow(data[i]);
	}
}

function drawRow(rowData) {
	alert(rowData);
	var json = JSON.stringify(eval("(" + rowData + ")"));
	alert(json);
	alert(JSON.stringify(rowData).gid);
	alert(json.gid);
	var row = $("<tr />")
	$("#dataTable").append(row);
	row.append($("<td>" + json.gid + "</td>"));
	row.append($("<td>" + json.sequence + "</td>"));
	row.append($("<td>" + json.method + "</td>"));
	row.append($("<td>" + json.attendee + "</td>"));	
	row.append($("<td>" + json.partstat + "</td>"));
}