package com.fortech;

import java.io.IOException;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyRawWebSocketHandler extends TextWebSocketHandler {

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws IOException {
		TextMessage msg = new TextMessage("established - " + session.getId());
		System.out.println(msg.getPayload());
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
		TextMessage msg = new TextMessage("handle - " + session.getId() + " - payload :" +message.getPayload());
		System.out.println(msg.getPayload());
		session.sendMessage(message);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		TextMessage msg = new TextMessage("Closed connection close! - " + session.getId());
		System.out.println(msg.getPayload());
	}
}
