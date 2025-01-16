package com.taxi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxi.Model.ContactForm;
@Repository
public interface ContactFormCrud extends JpaRepository< ContactForm, Integer> {
  
    
} 
