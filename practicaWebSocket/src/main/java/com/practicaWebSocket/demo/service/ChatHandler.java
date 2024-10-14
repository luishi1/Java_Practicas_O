package com.practicaWebSocket.demo.service;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Service
public class ChatHandler extends TextWebSocketHandler {

	private final CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.add(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessions.remove(session);
	}
	
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	    // Envía el mensaje a todas las sesiones excepto a la que envió el mensaje
	    for (WebSocketSession webSocketSession : sessions) {
	        if (webSocketSession != session) { // Verificacion que no es el mismo mensaje
	            webSocketSession.sendMessage(message);
	        }
	    }
	}

}

//estable la conexion con la sesion para enviar los mensajes
//mensaje enviado , se envia a todas las sesiones activas distribuida por todas las sesiones activas