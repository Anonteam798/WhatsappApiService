package com.infinity.bytes.WhatsappApiService.model.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BussinessDtoReq {
    @NotBlank(message = "Es obligatorio la asignacion de un nombre")
    private String name;
    @NotBlank(message = "Es necesario un numero telefonico")
    private String phone;

    private String direcction;

    private String ruc;

    private String razonSocial;

    @NotBlank(message = "Es necesario un correo electronico")
    private String email;
    private String facebookUrl;
    private String instagramUrl;
    private String tiktokUrl;
    private String twiterUrl;
    private String whatsappContactMe;
    private String logoBase64;
    private String logoName;

    @JsonIgnore
    private String isActive =  "S";
    @JsonIgnore
    private Date dateCreation = new Date();

    private Collection<ConfigurationDtoReq> configurationCollection;



}
