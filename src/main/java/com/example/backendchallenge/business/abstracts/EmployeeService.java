package com.example.backendchallenge.business.abstracts;

import com.example.backendchallenge.business.requests.employeeRequest.CreateEmployeeRequest;
import com.example.backendchallenge.business.requests.employeeRequest.UpdateEmployeeRequest;
import com.example.backendchallenge.business.responses.employeeResponses.*;
import com.example.backendchallenge.core.utilities.result.DataResult;

import java.util.List;

public interface EmployeeService {

DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest);
DataResult<List<GetAllEmployeeResponse>> getAll();
DataResult<GetEmployeeResponse> getById(int employeeId);
DataResult<DeleteEmployeeResponse> delete(int employeId);
DataResult<UpdateEmployeeResponse> update (UpdateEmployeeRequest updateEmployeeRequest);
}
