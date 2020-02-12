package com.ozaytunctan.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketService {

	@MessageMapping("/news")
	@SendTo("/topic/news")
	public void broadcastNews(@Payload String message) {
	}
}
