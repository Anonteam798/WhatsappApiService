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
@Table(catalog = "whatsappDb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Configuration.findAll", query = "SELECT c FROM Configuration c")})
public class Configuration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private String mainLocalDirectory;
    private String mainRemoteDirectory;
    private String googleApiKey;
    private String emailCredential;
    private String whatasppCredential;
    private String isActive;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;
    @JoinColumn(name = "bussinessId", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bussiness bussinessId;

}
