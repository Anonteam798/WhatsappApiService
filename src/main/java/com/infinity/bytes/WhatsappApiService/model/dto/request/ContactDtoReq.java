package com.infinity.bytes.WhatsappApiService.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ContactDtoReq {
    private String contactName;
    private String phoneNumber;
}
