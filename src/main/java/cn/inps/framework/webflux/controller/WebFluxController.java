package cn.inps.framework.webflux.controller;

import cn.inps.framework.webflux.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class WebFluxController {

//    @GetMapping("/hello")
//    public String hello() {
//        return "Hello, WebFlux !";
//    }

    @GetMapping("/user")
    public Mono<User> getUser() {
        User user = new User();
        user.setName("中文名称");
        user.setDesc("内容描述 描述");
        return Mono.just(user);
    }

}
