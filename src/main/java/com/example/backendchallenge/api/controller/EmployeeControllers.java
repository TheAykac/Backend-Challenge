package com.example.backendchallenge.api.controller;

import com.example.backendchallenge.business.abstracts.EmployeeService;
import com.example.backendchallenge.business.requests.employeeRequest.CreateEmployeeRequest;
import com.example.backendchallenge.business.requests.employeeRequest.UpdateEmployeeRequest;
import com.example.backendchallenge.business.responses.employeeResponses.*;
import com.example.backendchallenge.core.utilities.result.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeControllers {
    private final EmployeeService employeeService;


    @PostMapping("/add")
    public DataResult<CreateEmployeeResponse> add(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        return this.employeeService.add(createEmployeeRequest);
    }

    @GetMapping("/getById/{employeeId}")
    public DataResult<GetEmployeeResponse> getById(@PathVariable int employeeId) {
        return this.employeeService.getById(employeeId);
    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllEmployeeResponse>> getAll() {
        return this.employeeService.getAll();
    }

    @DeleteMapping("/delete/{employeId}")
    public DataResult<DeleteEmployeeResponse> delete(@PathVariable int employeId) {
        return this.employeeService.delete(employeId);
    }


    @PutMapping("/update")
    public DataResult<UpdateEmployeeResponse> update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        return this.employeeService.update(updateEmployeeRequest);
    }
}
