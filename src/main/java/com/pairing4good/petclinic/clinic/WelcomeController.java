package com.pairing4good.petclinic.clinic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("petClinicName", "Bob's Pet Clinic");
        return modelAndView;
    }
}
