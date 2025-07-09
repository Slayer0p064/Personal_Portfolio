package com.prototype.pryt3.controller;

import com.prototype.pryt3.model.Contact;
import com.prototype.pryt3.repository.ContactRepository;
import com.prototype.pryt3.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:5173")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping
    public String receiveMessage(@RequestBody Contact contact) {
        contactRepository.save(contact);


        emailService.sendContactNotification(
                contact.getName(),
                contact.getEmail(),
                contact.getMessage()
        );

        return "Message received from " + contact.getName();
    }

    @GetMapping
    public String testContactApi() {
        return "✅ Contact API is running!";
    }

    @GetMapping("/all")
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
