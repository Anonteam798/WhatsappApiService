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
    @NamedQuery(name = "PaymentMethods.findAll", query = "SELECT p FROM PaymentMethods p")})
public class PaymentMethods implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer id;
    private String description;
    private String isActive;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;
    @OneToMany(mappedBy = "paymentMetodId", fetch = FetchType.LAZY)
    private Collection<Sale> saleCollection;

}
