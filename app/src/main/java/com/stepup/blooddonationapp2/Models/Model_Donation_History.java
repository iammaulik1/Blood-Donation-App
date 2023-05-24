package com.stepup.blooddonationapp2.Models;


import java.util.List;

public class Model_Donation_History {


    private Boolean status;

    private String message;

    private List<Model_Donation_History_Data> data = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Model_Donation_History_Data> getData() {
        return data;
    }

    public void setData(List<Model_Donation_History_Data> data) {
        this.data = data;
    }

}
