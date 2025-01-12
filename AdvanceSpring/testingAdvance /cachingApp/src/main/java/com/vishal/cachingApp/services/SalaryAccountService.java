package com.vishal.cachingApp.services;

import com.vishal.cachingApp.entities.Employee;
import com.vishal.cachingApp.entities.SalaryAccount;

public interface SalaryAccountService {
    void createAccount(Employee employee);

    SalaryAccount incrementBalance(Long accountId);
}
