/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinity.bytes.WhatsappApiService.model;

import java.io.Serializable;
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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Order", catalog = "whatsappDb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")})
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer orderId;
    private Integer clientFrom;
    private String description;
    private String delyveryAddres;
    private String isFully;
    private String listContactNotify;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @JoinColumn(name = "keywordResponse", referencedColumnName = "keyWordId")
    @ManyToOne(fetch = FetchType.LAZY)
    private WhatsappKeyWords keywordResponse;

}
