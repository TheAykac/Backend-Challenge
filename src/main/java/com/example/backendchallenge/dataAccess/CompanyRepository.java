package com.example.backendchallenge.dataAccess;

import com.example.backendchallenge.entities.concretes.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
