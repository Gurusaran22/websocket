//package com.demo.websocket.DTO;
//
//
//import java.util.Set;
//
//public class MessageDTO {
//    private String from;
//    private String to;
//    private String content;
//    private String type;
//    private Set<String> users;
//
//    public MessageDTO() {}
//
//    public MessageDTO(String from, String to, String content) {
//        this.from = from;
//        this.to = to;
//        this.content = content;
//        this.type = "message";
//    }
//
//    public MessageDTO(String from, String to, String type, Set<String> users) {
//        this.from = from;
//        this.to = to;
//        this.type = type;
//        this.users = users;
//    }
//
//    public String getFrom() { return from; }
//    public void setFrom(String from) { this.from = from; }
//    public String getTo() { return to; }
//    public void setTo(String to) { this.to = to; }
//    public String getContent() { return content; }
//    public void setContent(String content) { this.content = content; }
//    public String getType() { return type; }
//    public void setType(String type) { this.type = type; }
//    public Set<String> getUsers() { return users; }
//    public void setUsers(Set<String> users) { this.users = users; }
//}