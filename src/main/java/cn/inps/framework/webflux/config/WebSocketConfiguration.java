package cn.inps.framework.webflux.config;

import cn.inps.framework.webflux.websocket.EchoHandler;
import cn.inps.framework.webflux.websocket.MyWebSocketHandler;
import cn.inps.framework.webflux.websocket.WebSocketMappingHandlerMapping;
import cn.inps.framework.webflux.websocket.WebSocketSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class WebSocketConfiguration {

    @Bean
    public HandlerMapping webSocketMapping() {
        return new WebSocketMappingHandlerMapping();
    }

    @Bean
    public ConcurrentHashMap<String, WebSocketSender> senderMap() {
        return new ConcurrentHashMap<String, WebSocketSender>();
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }





        @Bean
        public MyWebSocketHandler getMyWebsocketHandler() {
            return new MyWebSocketHandler();
        }
        @Bean
        public HandlerMapping handlerMapping() {
            // 对相应的URL进行添加处理器
            Map<String, WebSocketHandler> map = new HashMap<>();
            map.put("/hello", getMyWebsocketHandler());

            SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
            mapping.setUrlMap(map);
            mapping.setOrder(-1);
            return mapping;
        }


}