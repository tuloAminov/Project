package ru.students.startup.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.students.startup.project.dto.LoginForm;
import ru.students.startup.project.exception.BookShelfLoginException;
import ru.students.startup.project.services.LoginService;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private Logger logger = Logger.getLogger(String.valueOf(LoginController.class));
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String login(Model model){
        logger.info("GET /login returns login_page.html");
        model.addAttribute("loginForm", new LoginForm());
        return "login_page";
    }

    @PostMapping("/auth")
    public String authenticate(LoginForm loginForm) throws BookShelfLoginException {
        if (loginService.authenticate(loginForm)){
            logger.info("login OK redirect to book shelf");
            return "redirect:/main";
        }
        else{
            logger.info("login FAIL redirect back to login");
            throw new BookShelfLoginException("invalid username or password");
        }
    }

    @ExceptionHandler(BookShelfLoginException.class)
    public String handleError(Model model, BookShelfLoginException exception){
        model.addAttribute("errorMessage", exception.getMessage());
        return "errors/404";
    }
}