package com.infinity.bytes.WhatsappApiService.model.dto.request;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WspMediaFileDtoReq {

    @NotBlank(message = "Es necesario incluir un nombre en el archivo")
    private String name;
    @NotBlank(message = "Es necesario definir la ruta completa del archivo")
    private String fullPath;
    private String extension;

    @NotBlank(message = "Es obligatorio definir el hash del archivo")
    private String hash;

    @NotNull(message = "Es necesario conocer el tamaño del archivo")
    private Double size;
    private String isUploaded;
    private String uploadUrl;

}
