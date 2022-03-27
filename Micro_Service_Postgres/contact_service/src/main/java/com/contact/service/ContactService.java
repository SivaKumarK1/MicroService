package com.contact.service;

import com.contact.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {


    void saveData(Contact contact);

     List<Contact>  fetchUser(Long userId);
}
