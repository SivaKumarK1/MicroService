package com.contact.controller;

import com.contact.entity.Contact;
import com.contact.service.ContactService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;
//     Logger logger = (Logger) LoggerFactory.getLogger(ContactController.class);


    @PostMapping("/user/{userId}")
    public Contact saveUser(@RequestBody Contact contact, @PathVariable("userId") Long userId){
        contactService.saveData(contact);
//        logger.info();
        System.out.println("Contact Data: "+contact.getContactName());
        return contact;
    }

    @GetMapping("/user/{userId}")
    public List<Contact> getContacts(@PathVariable("userId") Long userId) {
        System.out.println("UserId : "+userId);
        return contactService.fetchUser(userId);
    }

}
