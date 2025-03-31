package com.jinhui.wmiss.controller;


import com.jinhui.wmiss.root.R;
import com.jinhui.wmiss.root.TestDeepSeekService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@RestController
@RequestMapping("/api/v1/deepSeek")
public class DeepSeekController {
    @Autowired
    private TestDeepSeekService deepSeekService;
    @GetMapping("/retrieveAnswer")
    public R<?> retrieve(@RequestParam String userMessage) {
        String retrievedAnswer = deepSeekService.retrieveAnswer(userMessage)
                ;
        log.info("DeepSeek answer is: {}", retrievedAnswer);
        log.info("DeepSeek Contorller's call back is: {}", R.ok(retrievedAnswer));
        return R.ok(retrievedAnswer);
    }

}
