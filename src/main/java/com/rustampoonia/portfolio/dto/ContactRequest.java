package com.rustampoonia.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactRequest {

    private String name;
    private String email;
    private String userType;
    private String message;
    private String phonenumber;
}
