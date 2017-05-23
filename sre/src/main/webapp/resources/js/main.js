function drawTable(data) {
	$("#dataTable").find("tr:gt(0)").remove();
	for (var i = 0; i < data.length; i++) {
		drawRow(data[i]);
	}
}

function drawRow(rowData) {
	var row = $("<tr />")
	$("#dataTable").append(row);
	row.append($("<td>" + rowData.id + "</td>"));
	row.append($("<td>" + rowData.brand + "</td>"));
	row.append($("<td>" + rowData.year + "</td>"));
	row.append($("<td>" + rowData.color + "</td>"));
	row.append($("<td>" + rowData.price  + "</td>").priceFormat({
		prefix: '',
	    centsSeparator: ',',
	    thousandsSeparator: '.'
	}));
	row.append($("<td>" + rowData.sold + "</td>"));

}