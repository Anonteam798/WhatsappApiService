package com.infinity.bytes.WhatsappApiService.service;


import com.infinity.bytes.WhatsappApiService.model.dto.request.ContactDtoReq;
import com.infinity.bytes.WhatsappApiService.model.entity.Contact;
import com.infinity.bytes.WhatsappApiService.repository.IContactRepository;
import com.infinity.bytes.WhatsappApiService.service.interfaces.AbstractMainService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class ContactServiceImpl extends AbstractMainService<Contact> {

    private final IContactRepository objContactRepository;

    public ContactServiceImpl(IContactRepository objContactRepository) {
        this.objContactRepository = objContactRepository;
    }

    public Contact createNewContact(ContactDtoReq req){
            log.debug("ContactRequestDto a buscar: " + req.toString());
            Optional<Contact> cont = findPhone(req.getPhoneNumber());

            if (cont.isPresent()) {
                log.debug("Existe el contacto con id: " + cont.get()
                        .getId() + " retornando el contacto existente");
                return cont.get();}

            log.debug("Se procede a crear el registro");

            Contact created =  this
                    .objContactRepository.save(
                            Contact.builder()
                                    .phoneNumber(req.getPhoneNumber())
                                    .alias(req.getContactName())
                                    .isActive("S")
                                    .dateCreation(new Date())
                                    .build()
                    );

            log.debug("Entidad creada: " + created);


            return created;

    }

    @Override
    public Optional<Contact> findItem(Object id) {
        return this.objContactRepository.findById((int)id);
    }


    public Optional<Contact> findPhone(String phone) {
        return this.objContactRepository.findByPhoneNumber(phone);
    }
}
