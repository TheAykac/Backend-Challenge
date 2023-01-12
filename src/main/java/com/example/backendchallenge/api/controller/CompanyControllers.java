package com.example.backendchallenge.api.controller;

import com.example.backendchallenge.business.abstracts.CompanyService;
import com.example.backendchallenge.business.requests.companyRequests.CreateCompanyRequest;
import com.example.backendchallenge.business.requests.companyRequests.UpdateCompanyRequest;
import com.example.backendchallenge.business.responses.companyResponses.*;
import com.example.backendchallenge.core.utilities.result.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
@AllArgsConstructor
public class CompanyControllers {
    private final CompanyService companyService;

    @PostMapping("/add")
    public DataResult<CreateCompanyResponse> add(@RequestBody CreateCompanyRequest createCompanyRequest) {
        return this.companyService.add(createCompanyRequest);
    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllCompanyResponse>> getAll() {
        return this.companyService.getAll();
    }

    @GetMapping("/getById/{companyId}")
    public DataResult<GetCompanyResponse> getById(@PathVariable int companyId) {
        return this.companyService.getById(companyId);
    }

    @DeleteMapping("/delete/{companyId}")
    public DataResult<DeleteCompanyResponse> delete(@PathVariable int companyId) {
        return this.companyService.delete(companyId);
    }

    @PutMapping("/update")
    public DataResult<UpdateCompanyResponse> update(@RequestBody UpdateCompanyRequest updateCompanyRequest) {
        return this.companyService.update(updateCompanyRequest);
    }


}
