package com.infinity.bytes.WhatsappApiService.model.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageTypeDTOResp {
    private String type;
    private String isActive;
    private Date dateCreation;

}
