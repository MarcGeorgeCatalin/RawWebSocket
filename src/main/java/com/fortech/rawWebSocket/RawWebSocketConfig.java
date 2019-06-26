package com.fortech.rawWebSocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Profile("raw")
@Configuration
@EnableWebSocket
public class RawWebSocketConfig implements WebSocketConfigurer {
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(myRawWebSocketHandler(), "/rawwebsocket").setAllowedOrigins("*");
	}

	@Bean
	public WebSocketHandler myRawWebSocketHandler() {
		return new MyRawWebSocketHandler();
	}
}