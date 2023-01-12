package com.example.backendchallenge.business.responses.companyResponses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCompanyResponse {
    private int id;
    private String name;
    private String adress;
    private String phoneNumber;
}
