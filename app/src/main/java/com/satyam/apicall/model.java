package com.satyam.apicall;

public class model {
    String payment_type;
    String payment_type_key;
    String name;
    String title;

    public model(String payment_type, String payment_type_key, String name, String title) {
        this.payment_type = payment_type;
        this.payment_type_key = payment_type_key;
        this.name = name;
        this.title = title;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getPayment_type_key() {
        return payment_type_key;
    }

    public void setPayment_type_key(String payment_type_key) {
        this.payment_type_key = payment_type_key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
