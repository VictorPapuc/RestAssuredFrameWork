package com.paymentexample.pojo;

import java.util.List;

public class PostObject {

    private List<Transactions> types;

    private String timeZone;
    private Name name;
    private Redirect_urls redirect_urls;
    private String email;


    public List<Transactions> getTypes() {
        return types;
    }

    public void setTypes(List<Transactions> types) {
        this.types = types;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Redirect_urls getRedirect_urls() {
        return redirect_urls;
    }

    public void setRedirect_urls(Redirect_urls redirect_urls) {
        this.redirect_urls = redirect_urls;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
