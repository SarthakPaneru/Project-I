package com.example.awaytofindpeace.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @GetMapping(path = "services")
    public String getServices() {
        return "services";
    }

    @GetMapping(path = "about")
    public String getAbout() {
        return "about";
    }

    @GetMapping(path = "profile")
    public String getProfile() {
        return "profile";
    }
}
