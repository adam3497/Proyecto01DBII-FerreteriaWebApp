package com.grupo01.proyecto01dbiiferreteriawebapp.controller;

import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model.EmployeeEntity;
import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model.JobEntity;
import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.repository.*;
import com.grupo01.proyecto01dbiiferreteriawebapp.model.EmployeeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

@RestController
public class EditController {

    private static final Logger log = LoggerFactory.getLogger(EditController.class);
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/edit/edit_employee")
    public ModelAndView searchEmployeeForm() {
        ModelAndView mv = new ModelAndView();
        EmployeeModel employee = new EmployeeModel();
        mv.addObject("employee", employee);
        return mv;
    }

    @PostMapping("/edit/edit_employee/search")
    public ModelAndView searchEmployeeSubmit(@ModelAttribute("employee") EmployeeModel employeeToSearch,
                                             ModelAndView mv) {
        EmployeeEntity employeeRetrieved;

        if(employeeToSearch.getCedula() != 0L) {
            employeeRetrieved = employeeRepository.findByCedula(employeeToSearch.getCedula());
            if(employeeRetrieved != null) {
                // The employee was found and its cedula is sent as a parameter in the url
                mv.setViewName("redirect:/edit/edit_employee_form?cedula=" + employeeRetrieved.getCedula());
                return mv;
            }
            String errorMsg = "El empleado no existe en la base de datos";
            mv.addObject("errorMsg", errorMsg);
        } else {
            String errorMsg = "Hubo un error en la transacción";
            mv.addObject("errorMsg", errorMsg);
        }
        mv.setViewName("redirect:/edit/edit_employee?error");
        return mv;
    }

    @GetMapping("/edit/edit_employee_form")
    public ModelAndView updateEmployeeForm(@ModelAttribute("employee") EmployeeModel employee) {
        ModelAndView mv = new ModelAndView();
        log.info(employee.getCedula() + "");
        EmployeeEntity employeeDB = employeeRepository.findByCedula(employee.getCedula());
        if(employeeDB != null) {
            employee.setName(employeeDB.getName());
            employee.setLastName(employeeDB.getLastName());
            employee.setPhoneNumber(employeeDB.getPhoneNumber());
            JobEntity currentJob = jobRepository.findById(employeeDB.getJobID());
            employee.setJobName(currentJob.getName());
        }
        List<JobEntity> availableJobs = (List<JobEntity>) jobRepository.findAll();
        mv.addObject("employee", employee);
        mv.addObject("jobs", availableJobs);
        return mv;
    }

    @PostMapping("/edit/edit_employee_form/update")
    public ModelAndView updateEmployeeSubmit(@ModelAttribute("employee") EmployeeModel employeeData,
                                             ModelAndView modelAndView) {
        log.info(employeeData.toString());
        EmployeeEntity employeeDB = employeeRepository.findByCedula(employeeData.getCedula());

        if(employeeDB != null) {
            employeeDB.setName(employeeData.getName());
            employeeDB.setLastName(employeeData.getLastName());
            employeeDB.setPhoneNumber(employeeData.getPhoneNumber());
            JobEntity newJob = jobRepository.findByName(employeeData.getJobName());
            employeeDB.setJobID(newJob.getId());
            employeeRepository.save(employeeDB);
            String successMsg = "Empleado actualizado";
            modelAndView.addObject("successMsg", successMsg);
            modelAndView.setViewName("redirect:/edit/edit_employee_form?success");
        } else {
            String errorMsg = "Ha ocurrido un error, el empleado no existe en la base de datos";
            modelAndView.addObject("errorMsg", errorMsg);
            modelAndView.setViewName("redirect:/edit/edit_employee_form?error");
        }
        return modelAndView;
    }

}
