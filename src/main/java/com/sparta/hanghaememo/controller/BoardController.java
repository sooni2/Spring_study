package com.sparta.hanghaememo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api")
public class BoardController {

    @GetMapping("/board")
    public ModelAndView board() {
        return new ModelAndView("index");
    }
}