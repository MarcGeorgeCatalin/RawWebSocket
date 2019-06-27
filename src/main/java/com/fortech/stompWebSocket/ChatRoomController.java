package com.fortech.stompWebSocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatRoomController {

	@MessageMapping("send.message")
	@SendTo("/topic/public.messages")
	public String sendPublicMessage(@Payload String message) {
		System.out.println(message);
		return message;
	}

}
