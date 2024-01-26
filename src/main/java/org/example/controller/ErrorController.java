package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        return "error"; // Assuming you have an "error.html" page in your static directory
    }
}
