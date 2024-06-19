package com.infinity.bytes.WhatsappApiService.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WhatsappMessageDtoReq {

    @NotBlank(message = "Es obligatorio definir el cuerpo del mensaje")
    private String message;

    @NotNull()
    private Boolean isMediaMessage;

    private String uuidMediaMessage;

    private Integer idWhatsAppFile;

    /*
    @NotNull(message = "Debe existir un remitente del mensaje")
    private ContactDtoReq idContactFrom;

    @NotNull(message = "Debe existir un receptor del mensaje")
    private ContactDtoReq idContactTo;
*/
    private String groupId;

}
