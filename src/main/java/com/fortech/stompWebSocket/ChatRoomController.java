package com.fortech.stompWebSocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatRoomController {

	@MessageMapping("send.message")
	@SendTo("/topic/public.messages")
	public String sendPublicMessage(String message) {
		System.out.println(message);
		return message;
	}

}
