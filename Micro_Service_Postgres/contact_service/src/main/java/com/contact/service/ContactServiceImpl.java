package com.contact.service;

import com.contact.entity.Contact;
import com.contact.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
@Autowired
private ContactRepo contactRepo;
    //fake list of contacts

//    List<Contact> list = List.of(
//            new Contact(1L, "kumar@gmail.com", "Kumar", 1311L),
//            new Contact(2L, "anil@gmail.com", "Anil", 1311L),
//            new Contact(3L, "siva@gmail.com", "Siva", 1312L),
//            new Contact(4L, "rakesh@gmail.com", "Rakesh", 1314L)
//    );


    @Override
    public  List<Contact> fetchUser(Long userId) {
        System.out.println("users id is: "+ userId);
        List<Contact> contact = contactRepo.findByUserId(userId);
//        contactRepo.findAllByUserId(userId);
        System.out.println(userId);
        if(Objects.isNull(contact)){
            System.out.println("Not Available");
        }
        return contact;
    }



    @Override
    public void saveData(Contact contact) {

        contactRepo.save(contact);
    }

//    @Override
//    public List<Contact> fetchUser(Long userId) {
//        return null;
//    }
}
