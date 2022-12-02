package ru.students.startup.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayingController {

    @GetMapping("/playing")
    public String playing(Model model){
        return "playing";
    }
}