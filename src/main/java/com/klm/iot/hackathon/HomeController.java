package com.klm.iot.hackathon;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @GetMapping("/getBaggageStatus")
    public ResponseEntity<?> getBaggageStatus(HttpServletRequest request) {
        System.out.println("controller called");
        return ResponseEntity.ok(80);

    }
    @GetMapping("/")
    public Object welcome(Model model) {
        model.addAttribute("searchResult", new SearchResult());
        return "/home";
    }

    @GetMapping("/loggedIn")
    public String loggedIn(Model model) {
        return "/loggedIn";
    }


    @PostMapping("/login")
    public String loginResultViaAjax(Model model,
                                     @ModelAttribute(value="searchResult") SearchResult searchResult, HttpServletRequest request, HttpServletResponse response) {

        String pnr = searchResult.getPnr().toUpperCase();
        model.addAttribute("pnr", pnr);
        int data = 20;
       /* if(loginService.doesUserExist(userName)){
            data = 50;
        } else if(loginService.getPlayerNo() >=4){
            data = 51;
        }else {

            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.addCookie(new Cookie("user", userName));
            quizService.login(userName);
            loginService.addPlayer(userName);

            data = timerService.getData();
            model.addAttribute("user", userName);
        }*/
        model.addAttribute("data", data);
        return "/loggedIn";
    }

}
