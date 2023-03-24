package com.grupo01.proyecto01dbiiferreteriawebapp.model;

import java.io.Serializable;

public class JobModel implements Serializable {
    private String name, jobDescription;

    public JobModel() {}

    public JobModel(String name, String jobDescription) {
        this.name = name;
        this.jobDescription = jobDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
