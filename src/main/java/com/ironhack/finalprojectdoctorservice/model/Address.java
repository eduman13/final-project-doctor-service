package com.ironhack.finalprojectdoctorservice.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;
    private Integer portal;
    private Integer number;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getPortal() {
        return portal;
    }

    public void setPortal(Integer portal) {
        this.portal = portal;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", portal=" + portal +
                ", number=" + number +
                '}';
    }
}
