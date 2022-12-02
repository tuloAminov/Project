package ru.students.startup.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.students.startup.project.dto.Room;

import java.util.logging.Logger;

@Controller
public class JoinController {

    @GetMapping("/join")
    public String join(Model model){
        model.addAttribute("id", new Room().getId());
        return "join";
    }
}
