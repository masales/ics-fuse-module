function drawTable(data) {
	$("#dataTable").find("tr:gt(0)").remove();
	for (var i = 0; i < data.length; i++) {
		drawRow(data[i]);
	}
}

function drawRow(rowData) {
	var row = $("<tr />")
	$("#dataTable").append(row);
	row.append($("<td>" + rowData.gid + "</td>"));
	row.append($("<td>" + rowData.sequence + "</td>"));
	row.append($("<td>" + rowData.method + "</td>"));
	row.append($("<td>" + rowData.attendee + "</td>"));	
	row.append($("<td>" + rowData.partstat + "</td>"));

}