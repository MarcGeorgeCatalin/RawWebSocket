$(document).ready(function() {
	var stompClient = null;
	var socket = null;
	var btnSend = $("#send");
	var inputMessage = $("#message");
	var newMessages = $("#newMessages");

	function connect() {
		socket = new SockJS('/stompwebsocket');
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function(frame) {
			stompClient.subscribe('/topic/public.messages', function(response) {
				renderMessages(response.body);
			});
		});
	}

	function renderMessages(message) {
		newMessages.append("<p>" + message + "</p>")
	}
	function sendMessage(event) {
		stompClient.send("/app/send.message", {}, inputMessage.val());
	}
	connect();
	btnSend.on("click", sendMessage);
});
