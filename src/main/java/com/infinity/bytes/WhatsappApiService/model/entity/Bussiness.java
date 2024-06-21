/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinity.bytes.WhatsappApiService.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

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
public class Bussiness implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private String name;
    private String phone;
    private String direcction;
    private String ruc;
    private String razonSocial;
    private String email;
    private String facebookUrl;
    private String instagramUrl;
    private String tiktokUrl;
    private String twiterUrl;
    private String whatsappContactMe;
    @Lob
    @Column(name = "logo", columnDefinition = "BLOB")
    private byte[] logo;
    private String logoName;
    private String isActive;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;
    @OneToMany(mappedBy = "bussinessId", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Collection<Configuration> configurationCollection;

}
