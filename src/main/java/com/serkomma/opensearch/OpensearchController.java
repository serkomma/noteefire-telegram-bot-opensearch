package com.serkomma.opensearch;

import com.serkomma.opensearch.services.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Controller
public class OpensearchController {
    private final NotificationService notificationService;

    OpensearchController(NotificationService notificationService){
        this.notificationService = notificationService;
    }
    @GetMapping(value = "/", produces="application/json;charset=UTF-8" )
    public ResponseEntity<?> search(@RequestHeader Map<String, String> requestEntity){
        return new ResponseEntity<>(
                notificationService.search(
                        URLDecoder.decode(requestEntity.get("phrase"), StandardCharsets.UTF_8),
                        Long.parseLong(requestEntity.get("chatid"))),
                HttpStatus.OK);
    }
}
