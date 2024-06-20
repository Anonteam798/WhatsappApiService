package com.infinity.bytes.WhatsappApiService.model.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity representing WhatsApp Messages.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "whatsapp_mensaje", catalog = "whatsappDb", schema = "public")
public class WhatsappMensaje implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;

    private String message;

    private Boolean isMediaMessage;

    private String uuidMediaMessage;

    private Integer idWhatsAppFile;

    private String groupId;

    private Boolean flagSent;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contact_from", referencedColumnName = "id")
    private Contact idContactFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contact_to", referencedColumnName = "id")
    private Contact idContactTo;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_message", referencedColumnName = "id")
    private MessageTypes idTypeMessage;

}