package com.example.backendchallenge.business.abstracts;

import com.example.backendchallenge.business.requests.companyRequests.CreateCompanyRequest;
import com.example.backendchallenge.business.requests.companyRequests.UpdateCompanyRequest;
import com.example.backendchallenge.business.responses.companyResponses.*;
import com.example.backendchallenge.core.utilities.result.DataResult;

import java.util.List;

public interface CompanyService {

    DataResult<CreateCompanyResponse> add(CreateCompanyRequest createCompanyRequest);

    DataResult<List<GetAllCompanyResponse>> getAll();

    DataResult<GetCompanyResponse> getById(int companyId);

    DataResult<DeleteCompanyResponse> delete(int companyId);

    DataResult<UpdateCompanyResponse> update(UpdateCompanyRequest updateCompanyRequest);
}
