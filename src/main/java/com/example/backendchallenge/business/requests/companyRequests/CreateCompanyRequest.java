package com.example.backendchallenge.business.requests.companyRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyRequest {

    @NotNull
    private String name;
    @NotNull
    private String adress;
    @NotNull
    private String phoneNumber;
}
