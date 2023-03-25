package com.grupo01.proyecto01dbiiferreteriawebapp.model;

import java.io.Serializable;

public class EmployeeModel extends PersonModel implements Serializable{
    private String jobName;

    public EmployeeModel () {
        super();
    }

    public EmployeeModel(long cedula, long phoneNumber, String name, String lastName, String email, String jobName) {
        super(cedula, phoneNumber, name, lastName, email);
        this.jobName = jobName;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                "jobName='" + jobName + '\'' + '}');
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
}
