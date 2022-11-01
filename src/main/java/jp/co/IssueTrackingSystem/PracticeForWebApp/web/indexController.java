package jp.co.IssueTrackingSystem.PracticeForWebApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class indexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
