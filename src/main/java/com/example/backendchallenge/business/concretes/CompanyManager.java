package com.example.backendchallenge.business.concretes;

import com.example.backendchallenge.business.abstracts.CompanyService;
import com.example.backendchallenge.business.requests.companyRequests.CreateCompanyRequest;
import com.example.backendchallenge.business.requests.companyRequests.UpdateCompanyRequest;
import com.example.backendchallenge.business.responses.companyResponses.*;
import com.example.backendchallenge.core.utilities.exceptions.BusinessException;
import com.example.backendchallenge.core.utilities.mapping.ModelMapperService;
import com.example.backendchallenge.core.utilities.messages.BusinessMessage;
import com.example.backendchallenge.core.utilities.result.DataResult;
import com.example.backendchallenge.core.utilities.result.SuccessDataResult;
import com.example.backendchallenge.dataAccess.CompanyRepository;
import com.example.backendchallenge.entities.concretes.Company;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyManager implements CompanyService {
    private final CompanyRepository companyRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<CreateCompanyResponse> add(CreateCompanyRequest createCompanyRequest) {
        Company company = this.modelMapperService.forRequest().map(createCompanyRequest, Company.class);
        this.companyRepository.save(company);
        CreateCompanyResponse createCompanyResponse = this.modelMapperService.forResponse().map(company, CreateCompanyResponse.class);

        return new SuccessDataResult<>(createCompanyResponse, BusinessMessage.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
    }

    @Override
    public DataResult<List<GetAllCompanyResponse>> getAll() {

        List<Company> companies = this.companyRepository.findAll();
        List<GetAllCompanyResponse> getAllCompanyResponses = companies.stream().map(company -> this.modelMapperService.forResponse().map(company, GetAllCompanyResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(getAllCompanyResponses, BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<GetCompanyResponse> getById(int companyId) {
        checkIfExistsById(companyId);
        Company company = this.companyRepository.findById(companyId).get();
        GetCompanyResponse getCompanyResponse = this.modelMapperService.forResponse().map(company, GetCompanyResponse.class);
        return new SuccessDataResult<>(getCompanyResponse, BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<DeleteCompanyResponse> delete(int companyId) {
        checkIfExistsById(companyId);
        Company company = this.companyRepository.findById(companyId).get();
        DeleteCompanyResponse deleteCompanyResponse = this.modelMapperService.forResponse().map(company, DeleteCompanyResponse.class);
        this.companyRepository.delete(company);
        return new SuccessDataResult<>(deleteCompanyResponse, BusinessMessage.GlobalMessages.DATA_DELETED_SUCCESSFULLY);

    }

    @Override
    public DataResult<UpdateCompanyResponse> update(UpdateCompanyRequest updateCompanyRequest) {
        checkIfExistsById(updateCompanyRequest.getId());
        Company company = this.modelMapperService.forRequest().map(updateCompanyRequest, Company.class);
        UpdateCompanyResponse updateCompanyResponse = this.modelMapperService.forResponse().map(company, UpdateCompanyResponse.class);
        this.companyRepository.save(company);
        return new SuccessDataResult<>(updateCompanyResponse, BusinessMessage.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
    }



    private void checkIfExistsById(int companyId) {
        if (!this.companyRepository.existsById(companyId)){
            throw new BusinessException(BusinessMessage.Company.COMPANY_ID_NOT_FOUND+companyId);
        }
    }
}
