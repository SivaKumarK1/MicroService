package com.contact.repo;

import com.contact.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {

//    @Query("select c from Contact as c where c.userId=?1 ")
     List<Contact> findByUserId(Long userId);

    List<Contact> findAllByUserId(Long userId);
}
