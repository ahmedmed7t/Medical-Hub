package com.example.crazynet.medicalhub.Model;

/**
 * Created by CrazyNet on 12/06/2019.
 */

public class Report {

    private String doctorName;
    private String doctorSpec;
    private String report;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSpec() {
        return doctorSpec;
    }

    public void setDoctorSpec(String doctorSpec) {
        this.doctorSpec = doctorSpec;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Report() {

    }

    public Report(String doctorName, String doctorSpec, String report, String date) {
        this.doctorName = doctorName;
        this.doctorSpec = doctorSpec;
        this.report = report;
        this.date = date;
    }
}
