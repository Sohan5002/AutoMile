
package com.taxi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.Dao.ContactFormCrud;
import com.taxi.Model.ContactForm;
@Service
public class ContactFormServiceImpl implements ContactFormService {



    private ContactFormCrud contactFormCrud;
    @Autowired
    public void setContactFormCrud(ContactFormCrud contactFormCrud) {
        this.contactFormCrud = contactFormCrud;
    }   
    @Override
    public ContactForm saveContactForm(ContactForm contactForm) {
        return contactFormCrud.save(contactForm);
    }
}
  


































