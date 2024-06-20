/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinity.bytes.WhatsappApiService.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author LuisQM
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(catalog = "whatsappDb", schema = "public")
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Basic(optional = false,)
    private Integer id;
    private String phoneNumber;
    private String alias;
    private String contactName;
    private String isContact;
    private String isUser;
    private String isActive;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;
    @OneToMany(mappedBy = "idContactFrom", fetch = FetchType.LAZY)
    private Collection<WhatsappMensaje> whatsappMensajeCollection;
    @OneToMany(mappedBy = "idContactTo", fetch = FetchType.LAZY)
    private Collection<WhatsappMensaje> whatsappMensajeCollection1;
    @OneToMany(mappedBy = "idContact", fetch = FetchType.LAZY)
    private Collection<Client> clientCollection;

}
