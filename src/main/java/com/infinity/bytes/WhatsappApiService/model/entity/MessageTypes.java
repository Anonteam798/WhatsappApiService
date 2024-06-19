package com.infinity.bytes.WhatsappApiService.model.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity representing Message Types.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "message_types", catalog = "whatsappDb", schema = "public")
public class MessageTypes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;

    private String isActive;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;

    @OneToOne(mappedBy = "idTypeMessage", fetch = FetchType.LAZY)
    private WhatsappMensaje whatsappMensaje;

}