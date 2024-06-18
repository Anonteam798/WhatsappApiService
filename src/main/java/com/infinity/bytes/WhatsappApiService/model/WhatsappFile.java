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
    @NamedQuery(name = "WhatsappFile.findAll", query = "SELECT w FROM WhatsappFile w")})
public class WhatsappFile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer uuid;
    private String name;
    private String fullPath;
    private String extension;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Double size;
    private String isUploaded;
    private String uploadUrl;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;
    private String isActive;

}
