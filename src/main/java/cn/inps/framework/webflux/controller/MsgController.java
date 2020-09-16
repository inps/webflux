package cn.inps.framework.webflux.controller;

import cn.inps.framework.webflux.websocket.WebSocketSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private ConcurrentHashMap<String, WebSocketSender> senderMap;

    @RequestMapping("/send")
    public String sendMessage(@RequestParam String id, @RequestParam String data) {
        WebSocketSender sender = senderMap.get(id);
        if (sender != null) {
            sender.sendData(data);
            return String.format("Message '%s' sent to connection: %s.", data, id);
        } else {
            return String.format("Connection of id '%s' doesn't exist", id);
        }
    }
}
