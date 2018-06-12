package com.klm.iot.hackathon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    MessageService messageService;

    @GetMapping("/getNoiseLevel")
    public ResponseEntity<?> getBaggageStatus(HttpServletRequest request) {
        System.out.println("controller called");
        return ResponseEntity.ok(messageService.getData());

    }
    @GetMapping("/")
    public Object welcome(Model model) {
        model.addAttribute("data", messageService.getData());
        return "/home";
    }

}
