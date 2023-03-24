package com.grupo01.proyecto01dbiiferreteriawebapp.controller;

import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model.*;
import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.repository.*;
import com.grupo01.proyecto01dbiiferreteriawebapp.model.*;
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
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/insert/insert_employee")
    public ModelAndView insertEmployeeForm() {
        EmployeeModel employee = new EmployeeModel();
        ModelAndView mv = new ModelAndView();
        mv.addObject("employee", employee);
        List<JobEntity> jobs = (List<JobEntity>) jobRepository.findAll();
        mv.addObject("jobs", jobs);
        return mv;
    }

    @PostMapping("/insert/insert_employee/save")
    public ModelAndView insertEmployeeSubmit(@ModelAttribute EmployeeModel newEmployee, ModelAndView mv) {
        EmployeeEntity employee = employeeRepository.findByCedula(newEmployee.getCedula());
        if(employee != null) {
            mv.setViewName("redirect:/insert/insert_employee?error");
        } else {
            JobEntity job = jobRepository.findByName(newEmployee.getJobName());
            employee = new EmployeeEntity(newEmployee.getCedula(), newEmployee.getName(),
                    newEmployee.getLastName(), newEmployee.getPhoneNumber(), job.getId(), newEmployee.getEmail());
            employeeRepository.save(employee);
            mv.setViewName("redirect:/insert/insert_employee?success");
        }
        return mv;
    }

    @GetMapping("/insert/insert_client")
    public ModelAndView insertCustomerForm() {
        CustomerModel customer = new CustomerModel();
        ModelAndView mv = new ModelAndView();
        mv.addObject("customer", customer);
        return mv;
    }

    @PostMapping("/insert/insert_client/save")
    public ModelAndView insertCustomerSubmit(@ModelAttribute CustomerModel newCustomer, ModelAndView mv) {
        CustomerEntity customer = customerRepository.findByCedula(newCustomer.getCedula());

        if(customer != null) {
            mv.setViewName("redirect:/insert/insert_client?error");
        } else {
            customer = new CustomerEntity(newCustomer.getCedula(), newCustomer.getName(),
                    newCustomer.getLastName(), newCustomer.getPhoneNumber(), newCustomer.buildAddress(),
                    newCustomer.getEmail());
            customerRepository.save(customer);
            mv.setViewName("redirect:/insert/insert_client?success");
        }
        return mv;
    }

    @GetMapping("/insert/insert_product")
    public ModelAndView insertProductForm() {
        ModelAndView mv = new ModelAndView();
        ProductModel product = new ProductModel();
        mv.addObject("product", product);
        List<CategoryEntity> categories = (List<CategoryEntity>) categoryRepository.findAll();
        mv.addObject("categories", categories);
        return mv;
    }

    @PostMapping("/insert/insert_product/save")
    public ModelAndView insertProductSubmit(@ModelAttribute ProductModel newProduct, ModelAndView mv) {
        ProductEntity product = productRepository.findByName(newProduct.getName());

        if(product != null) {
            mv.setViewName("redirect:/insert/insert_product?error");
        } else {
            CategoryEntity category = categoryRepository.findByName(newProduct.getCategoryName());
            product = new ProductEntity(newProduct.getName(), newProduct.getPrice(),
                    newProduct.getExpirationDate(), newProduct.getAmount(), category.getId());
            productRepository.save(product);
            mv.setViewName("redirect:/insert/insert_product?success");
        }
        return mv;
    }

    @GetMapping("/insert/insert_job")
    public ModelAndView insertJobForm() {
        ModelAndView mv = new ModelAndView();
        JobModel job = new JobModel();
        mv.addObject("job", job);
        return mv;
    }

    @PostMapping("/insert/insert_job/save")
    public ModelAndView insertJobSubmit(@ModelAttribute JobModel newJob, ModelAndView mv) {
        JobEntity job = jobRepository.findByName(newJob.getName());

        if(job != null) {
            mv.setViewName("redirect:/insert/insert_job?error");
        } else {
            job = new JobEntity(newJob.getName(), newJob.getJobDescription());
            jobRepository.save(job);
            mv.setViewName("redirect:/insert/insert_job?success");
        }
        return mv;
    }

    @GetMapping("/insert/insert_category")
    public ModelAndView insertCategoryForm() {
        ModelAndView mv = new ModelAndView();
        CategoryModel category = new CategoryModel();
        mv.addObject("category", category);
        return mv;
    }

    @PostMapping("/insert/insert_category/save")
    public ModelAndView insertCategorySubmit(@ModelAttribute CategoryModel newCategory, ModelAndView mv) {
        CategoryEntity category = categoryRepository.findByName(newCategory.getName());

        if(category != null) {
            mv.setViewName("redirect:/insert/insert_category?error");
        } else {
            category = new CategoryEntity(newCategory.getName());
            categoryRepository.save(category);
            mv.setViewName("redirect:/insert/insert_category?success");
        }
        return mv;
    }
}
