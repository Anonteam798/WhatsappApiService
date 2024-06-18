/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinity.bytes.WhatsappApiService.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
@Table(name = "Whatsapp_Mensaje", catalog = "whatsappDb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "WhatsappMensaje.findAll", query = "SELECT w FROM WhatsappMensaje w")})
public class WhatsappMensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer messageId;
    private String message;
    private String isMediaMessage;
    private String uuidMediaMessage;
    private Integer idWhatsAppFile;
    private String flagSent;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @JoinColumn(name = "idContactFrom", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contact idContactFrom;
    @JoinColumn(name = "idContactTo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contact idContactTo;
    @JoinColumn(name = "idTypeMessage", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private MessageTypes idTypeMessage;

}
