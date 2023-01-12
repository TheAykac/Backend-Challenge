package com.example.backendchallenge.business.concretes;

import com.example.backendchallenge.business.abstracts.EmployeeService;
import com.example.backendchallenge.business.requests.employeeRequest.CreateEmployeeRequest;
import com.example.backendchallenge.business.requests.employeeRequest.UpdateEmployeeRequest;
import com.example.backendchallenge.business.responses.employeeResponses.*;
import com.example.backendchallenge.core.utilities.exceptions.BusinessException;
import com.example.backendchallenge.core.utilities.mapping.ModelMapperService;
import com.example.backendchallenge.core.utilities.messages.BusinessMessage;
import com.example.backendchallenge.core.utilities.result.DataResult;
import com.example.backendchallenge.core.utilities.result.SuccessDataResult;
import com.example.backendchallenge.dataAccess.EmployeeRepository;
import com.example.backendchallenge.entities.concretes.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapperService modelMapperService;


    @Override
    public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest,Employee.class);
        this.employeeRepository.save(employee);
        CreateEmployeeResponse createEmployeeResponse= this.modelMapperService.forResponse().map(employee, CreateEmployeeResponse.class);
        return new SuccessDataResult<>(createEmployeeResponse, BusinessMessage.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
    }

    @Override
    public DataResult<List<GetAllEmployeeResponse>> getAll() {

        List<Employee> employees = this.employeeRepository.findAll();
        List<GetAllEmployeeResponse> getAllEmployeeResponses = employees.stream().map(employee -> this.modelMapperService.forResponse().map(employee,GetAllEmployeeResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(getAllEmployeeResponses,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<GetEmployeeResponse> getById(int employeeId) {
        checkIfExistsById(employeeId);
        Employee employee = this.employeeRepository.findById(employeeId).get();
        GetEmployeeResponse getAllEmployeeResponse= this.modelMapperService.forResponse().map(employee, GetEmployeeResponse.class);
        return new SuccessDataResult<>(getAllEmployeeResponse,BusinessMessage.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<DeleteEmployeeResponse> delete(int employeId) {
        checkIfExistsById(employeId);
        Employee employee = this.employeeRepository.findById(employeId).get();
        DeleteEmployeeResponse deleteEmployeeResponse = this.modelMapperService.forResponse().map(employee, DeleteEmployeeResponse.class);
        this.employeeRepository.delete(employee);
        return new SuccessDataResult<>(deleteEmployeeResponse,BusinessMessage.GlobalMessages.DATA_DELETED_SUCCESSFULLY);
    }

    @Override
    public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest) {
        checkIfExistsById(updateEmployeeRequest.getId());
        Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest,Employee.class);
        this.employeeRepository.save(employee);
        UpdateEmployeeResponse updateEmployeeResponse= this.modelMapperService.forResponse().map(employee, UpdateEmployeeResponse.class);
        return new SuccessDataResult<>(updateEmployeeResponse, BusinessMessage.GlobalMessages.DATA_ADDED_SUCCESSFULLY);

    }


    private void checkIfExistsById(int employeeId) {
        if (!this.employeeRepository.existsById(employeeId)){
            throw new BusinessException(BusinessMessage.Employee.Employee_LIST_EMPTY+employeeId);
        }
    }
}
