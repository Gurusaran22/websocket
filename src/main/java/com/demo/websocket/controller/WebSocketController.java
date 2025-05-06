//package com.demo.websocket.controller;
//
//import com.demo.websocket.DTO.MessageDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.messaging.simp.user.SimpUserRegistry;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class WebSocketController {
//
//    @Autowired
//    private SimpMessagingTemplate messagingTemplate;
//
//    @Autowired
//    private SimpUserRegistry userRegistry;
//
//    @MessageMapping("/private-message")
//    public void sendPrivateMessage(@Payload MessageDTO message) {
//        messagingTemplate.convertAndSendToUser(
//                message.getTo(),
//                "/private",
//                new MessageDTO(message.getFrom(), message.getTo(), message.getContent())
//        );
//        messagingTemplate.convertAndSendToUser(
//                message.getFrom(),
//                "/private",
//                new MessageDTO("system", message.getFrom(), "Message sent to " + message.getTo())
//        );
//    }
//
//    @MessageMapping("/get-users")
//    public void broadcastConnectedUsers(@Payload String userId) {
//        Set<String> connectedUsers = new HashSet<>();
//        for (SimpUser user : userRegistry.getUsers()) {
//            connectedUsers.add(user.getName());
//        }
//        messagingTemplate.convertAndSendToUser(
//                userId,
//                "/private",
//                new MessageDTO("system", userId, "userList", connectedUsers)
//        );
//    }
//}
