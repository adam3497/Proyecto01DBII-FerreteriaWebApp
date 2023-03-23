package com.grupo01.proyecto01dbiiferreteriawebapp.controller;

import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model.CustomerEntity;
import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model.EmployeeEntity;
import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model.JobEntity;
import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.repository.CustomerRepository;
import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.repository.EmployeeRepository;
import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.repository.JobRepository;
import com.grupo01.proyecto01dbiiferreteriawebapp.model.CustomerModel;
import com.grupo01.proyecto01dbiiferreteriawebapp.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class InsertController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/insert/insert_employee")
    public ModelAndView insertEmployeeForm() {
        EmployeeModel employee = new EmployeeModel();
        ModelAndView mv = new ModelAndView();
        mv.addObject("employee", employee);
        List<JobEntity> jobs = (List<JobEntity>) jobRepository.findAll();
        mv.addObject("jobs", jobs);
        return mv;
    }

    @PostMapping("/insert/insert_employee")
    public ModelAndView insertEmployeeSubmit(@ModelAttribute EmployeeModel newEmployee, ModelAndView mv) {
        EmployeeEntity employee = employeeRepository.findByCedula(newEmployee.getCedula());
        if(employee != null) {
            return mv.addObject("error", "El empleado ya existe en la base de datos");
        } else {
            JobEntity job = jobRepository.findByName(newEmployee.getJobName());
            employee = new EmployeeEntity(newEmployee.getCedula(), newEmployee.getName(),
                    newEmployee.getLastName(), newEmployee.getPhoneNumber(), job.getId(), newEmployee.getEmail());
            employeeRepository.save(employee);
            return mv.addObject("msg", "Empleado agregado a la base de datos");
        }
    }

    @GetMapping("/insert/insert_client")
    public ModelAndView insertCustomerForm() {
        CustomerModel customer = new CustomerModel();
        ModelAndView mv = new ModelAndView();
        mv.addObject("customer", customer);
        return mv;
    }

    @PostMapping("/insert/insert_client")
    public ModelAndView insertCustomerSubmit(@ModelAttribute CustomerModel newCustomer, ModelAndView mv) {
        CustomerEntity customer = customerRepository.findByCedula(newCustomer.getCedula());

        if(customer != null) {
            return mv.addObject("error", "El cliente ya existe en la base de datos");
        } else {
            customer = new CustomerEntity(newCustomer.getCedula(), newCustomer.getName(),
                    newCustomer.getLastName(), newCustomer.getPhoneNumber(), newCustomer.buildAddress(),
                    newCustomer.getEmail());
            customerRepository.save(customer);
            return mv.addObject("msg", "Cliente agregado a la base de datos");
        }
    }
}
