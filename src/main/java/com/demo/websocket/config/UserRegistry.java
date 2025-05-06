//package com.demo.websocket.config;
//
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.stream.Collectors;
//
//@Component
//public class UserRegistry {
//    private final Map<String, String> userRoleMap = new ConcurrentHashMap<>();
//
//    public void register(String username, String role) {
//        userRoleMap.put(username, role);
//    }
//
//    public List<String> getUsersByRole(String role) {
//        return userRoleMap.entrySet().stream()
//                .filter(entry -> role.equalsIgnoreCase(entry.getValue()))
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());
//    }
//}