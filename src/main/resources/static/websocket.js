var url ='ws://localhost:8080/rawwebsocket';
var socket = new WebSocket(url);

// send message from the form
document.forms.publish.onsubmit = function() {
  var outgoingMessage = this.message.value;
  socket.send(outgoingMessage);
  return false;
}; 

// handle incoming messages
socket.onmessage = function(event) {
  var incomingMessage = event.data;
  showMessage(incomingMessage);
};

function showMessage(message) {
  var messageElem = document.createElement('div');
  messageElem.textContent = message;
  document.getElementById('messages').prepend(messageElem);
}
