package com.taxi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taxi.Model.ContactForm;
import com.taxi.Service.ContactFormService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class Mycontroller {
   
    private ContactFormService contactFormService;
    @Autowired
    public void saveContactFormService(ContactFormService contactFormService) {
        this.contactFormService = contactFormService;
    }
    @GetMapping(path = {"/","home","Welcome","index"})
    public String welcomeView(HttpServletRequest req, Model m) {
        String requestURI = req.getRequestURI();
        m.addAttribute("mycurrentpage", requestURI);
        return "index";
    }

    @GetMapping("/About")
    public String AboutView(HttpServletRequest req, Model m) {
        String requestURI = req.getRequestURI();
        m.addAttribute("mycurrentpage", requestURI);
        return "about";
    }

    @GetMapping("/Contacts")
    public String ContactView(HttpServletRequest req, Model m) {
        String requestURI = req.getRequestURI();
        m.addAttribute("mycurrentpage", requestURI);
        m.addAttribute("contactform", new ContactForm());
        return "contacts";
    }

    @GetMapping("/Cars")
    public String CarView(HttpServletRequest req, Model m) {
        String requestURI = req.getRequestURI();
        m.addAttribute("mycurrentpage", requestURI);
        return "Cars";
    }

    @GetMapping("/Services")
    public String ServicesView(HttpServletRequest req, Model m) { 
        String requestURI = req.getRequestURI();
        m.addAttribute("mycurrentpage", requestURI);
        return "Services";
    }

    @PostMapping("/contactform") 
    public String contactForm( @Valid @ModelAttribute ContactForm contactForm, 
        BindingResult bindingResult ,Model m, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            m.addAttribute("bindingResult",bindingResult);
            return "contacts";  
        }
        ContactForm saveContactFormService = contactFormService.saveContactForm(contactForm);
          if(saveContactFormService != null){
            redirectAttributes.addFlashAttribute("message","Contact Form Submitted Successfully");    

          }
        else{
            redirectAttributes.addFlashAttribute("message","Failed to Submit Contact Form");
        }




        return "contacts"; // Ensure this view exists
    }
}