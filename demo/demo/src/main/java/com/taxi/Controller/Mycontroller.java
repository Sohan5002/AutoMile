package com.taxi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.taxi.Model.ContactForm;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class Mycontroller {
    @GetMapping(path = {"/","home","Welcome","index"})
    public String welcomeView(HttpServletRequest req, Model m) {
        String requestURI = req.getRequestURI();
        m.addAttribute("mycurrentpage", requestURI);
        return "index";
    }

    @GetMapping(path = {"about"})
    public String AboutView(HttpServletRequest req, Model m) {
        String requestURI = req.getRequestURI();
        m.addAttribute("mycurrentpage", requestURI);
        return "about";
    }

    @GetMapping(path = {"Contacts"})
    public String ContactView(HttpServletRequest req, Model m) {
        String requestURI = req.getRequestURI();
        m.addAttribute("mycurrentpage", requestURI);
        m.addAttribute("contactform", new ContactForm());
        return "Contacts";
    }

    @GetMapping(path = {"Cars"})
    public String CarView(HttpServletRequest req, Model m) {
        String requestURI = req.getRequestURI();
        m.addAttribute("mycurrentpage", requestURI);
        return "Cars";
    }

    @GetMapping(path = {"Services"})
    public String ServicesView(HttpServletRequest req, Model m) { 
        String requestURI = req.getRequestURI();
        m.addAttribute("mycurrentpage", requestURI);
        return "Services";
    }

    @PostMapping("contactform") 
    public String contactForm( @Valid @ModelAttribute ContactForm contactForm, 
        BindingResult bindingResult ,Model m){
        if(bindingResult.hasErrors()){
            m.addAttribute("bindingResult",bindingResult);
            return "Contacts";  
        }
        System.out.println(contactForm);
        return "contacts"; // Ensure this view exists
    }
}