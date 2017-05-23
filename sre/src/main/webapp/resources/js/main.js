function drawRow(rowData) {	
	var json = JSON.parse(rowData);	
	var row = $("<tr />")
	$("#dataTable").append(row);
	row.append($("<td>" + json.gid + "</td>"));
	row.append($("<td>" + json.sequence + "</td>"));
	row.append($("<td>" + json.method + "</td>"));
	row.append($("<td>" + json.attendee + "</td>"));	
	row.append($("<td>" + json.partstat + "</td>"));
	row.append($("<td>" + new Date() + "</td>"));
}