package com.infinity.bytes.WhatsappApiService.repository;

import com.infinity.bytes.WhatsappApiService.model.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IContactRepository extends JpaRepository<Contact, Integer> {

    Optional<Contact> findByPhoneNumber(String phoneNumber);
    Optional<Contact> findByContactName(String ContactName);

}
