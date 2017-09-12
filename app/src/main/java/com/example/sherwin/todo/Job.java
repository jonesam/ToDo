package com.example.sherwin.todo;

/**
 * Created by Sherwin on 18/07/2017.
 */

public class Job {
    String jobNum;
    String jobDate;
    String jobPri;
    String jobDeet;
    String jobMch1;
    String jobMch2;

    public Job(String jobNum, String jobDate, String jobPri, String jobDeet, String jobMch1, String jobMch2) {
        this.jobNum = jobNum;
        this.jobDate = jobDate;
        this.jobPri = jobPri;
        this.jobDeet = jobDeet;
        this.jobMch1 = jobMch1;
        this.jobMch2 = jobMch2;
    }

    public String getJobNum() {
        return jobNum;
    }

    public String getJobDate() {
        return jobDate;
    }

    public String getJobPri() {
        return jobPri;
    }

    public String getJobDeet() {
        return jobDeet;
    }

    public String getJobMch1() {
        return jobMch1;
    }

    public String getJobMch2() {
        return jobMch2;
    }
}