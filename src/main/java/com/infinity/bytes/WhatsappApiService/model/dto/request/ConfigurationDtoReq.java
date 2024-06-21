package com.infinity.bytes.WhatsappApiService.model.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ConfigurationDtoReq {

    @NotBlank(message = "Es necesario establecer un ruta local de almacenamiento")
    private String mainLocalDirectory;
    private String mainRemoteDirectory;
    private String googleApiKey;
    private String emailCredential;
    private String whatasppCredential;
    private String isActive =  "S";
    private Date dateCreation = new Date();
}
