package com.demo.websocket.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {
    private final Map<String, WebSocketSession> userSessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        String userId = (String) session.getAttributes().get("userId");
        if (userId != null) {
            userSessions.put(userId, session);
            System.out.println("User connected: " + userId);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        String userId = (String) session.getAttributes().get("userId");
        if (userId != null) {
            userSessions.remove(userId);
            System.out.println("User disconnected: " + userId);
        }
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String fromUser = (String) session.getAttributes().get("userId");

        // Parse JSON
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(message.getPayload());

        String toUser = jsonNode.get("to").asText();
        String msgText = jsonNode.get("message").asText();

        String response = String.format("{\"from\": \"%s\", \"message\": \"%s\"}", fromUser, msgText);

        WebSocketSession targetSession = userSessions.get(toUser);
        if (targetSession != null && targetSession.isOpen()) {
            targetSession.sendMessage(new TextMessage(response));
            System.out.println("Sent message from " + fromUser + " to " + toUser);
        } else {
            System.out.println("User " + toUser + " not connected.");
        }
    }

}