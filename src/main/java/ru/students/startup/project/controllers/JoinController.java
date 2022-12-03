package ru.students.startup.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.students.startup.project.dto.Room;
import ru.students.startup.project.exception.RoomLoginException;
import ru.students.startup.project.services.JoinService;

import java.util.logging.Logger;

@Controller
public class JoinController {

    private Logger logger = Logger.getLogger(String.valueOf(LoginController.class));
    private JoinService joinService;

    @Autowired
    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @GetMapping("/join")
    public String join(Model model){
        model.addAttribute("room", new Room());
        return "join";
    }

    @PostMapping("/playing")
    public String joining(Room room) throws RoomLoginException {
        if (joinService.joining(room.getId())){
            Long id = room.getId();
            logger.info("login OK redirect to book shelf");
            return "redirect:/playing/" + id;
        }
        else{
            logger.info("login FAIL redirect back to login");
            throw new RoomLoginException("invalid id");
        }
    }

    @GetMapping("/playing/{id}")
    public String playing(@PathVariable("id") Long id, Model model) {
        model.addAttribute("room", joinService.getRoomById(id));
        logger.info("login OK redirect to book shelf");
        return "playing";
    }

    @ExceptionHandler(RoomLoginException.class)
    public String handleError(Model model, RoomLoginException exception){
        model.addAttribute("errorMessage", exception.getMessage());
        return "errors/404";
    }
}