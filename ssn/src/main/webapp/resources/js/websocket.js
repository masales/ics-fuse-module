/**
 * websocket functions
 */
var wsURI = 'ws://' + window.location.host
		+ '/ssn/wsEndpoint';
var websocket = new WebSocket(wsURI);

$(document)
		.ready(
				function() {
					websocket.onopen = function() {
						displayStatus('Open');
						document.getElementById('sendButton').disabled = false;
						displayMessage('Connection is now open. Type a name and click Say Hello to send a message.');
					};
					websocket.onmessage = function(event) {
						displayMessage('The response was received! '
								+ event.data, 'success');
					};
					websocket.onerror = function(event) { 
						displayMessage('Error! ' + event.data, 'error');
					};
					websocket.onclose = function() {
						displayStatus('Closed');
						displayMessage('The connection was closed or timed out. Please click the Open Connection button to reconnect.');						
					};
				});

function sendMessage() {
	if (websocket !== null) {
		var content = document.getElementById('name').value;
		websocket.send(content);
	} else {
		displayMessage(
				'WebSocket connection is not established. Please click the Open Connection button.',
				'error');
	}
}

function displayMessage(data, style) {
	console.log(data);
	var message = document.getElementById('restConsole');
	message.setAttribute("class", style);
	message.value = data;
}

function displayStatus(status) {
	console.log(status);
	var currentStatus = document.getElementById('restConsole');
	currentStatus.value = status;
}