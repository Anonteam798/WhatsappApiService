/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinity.bytes.WhatsappApiService.model;

import java.io.Serializable;
import java.util.Collection;
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
@Table(catalog = "whatsappDb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "MessageTypes.findAll", query = "SELECT m FROM MessageTypes m")})
public class MessageTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private String type;
    private String isActive;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;
    @OneToMany(mappedBy = "idTypeMessage", fetch = FetchType.LAZY)
    private Collection<WhatsappMensaje> whatsappMensajeCollection;

}
