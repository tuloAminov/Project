package ru.students.startup.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.students.startup.project.dto.Room;

@Controller
public class JoinController {

    @GetMapping("/join")
    public String join(Model model){
        model.addAttribute("room", new Room());
        return "join";
    }

    @PostMapping("/playing")
    public String playing() {
        return "redirect:/playing";
    }
}