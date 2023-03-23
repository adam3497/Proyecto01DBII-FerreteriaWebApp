package com.grupo01.proyecto01dbiiferreteriawebapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    /*@GetMapping("/home")
    public ModelAndView index(RestTemplate restTemplate) {
        return null;
    }*/
}
