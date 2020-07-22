package com.ironhack.finalprojectdoctorservice.model.dto;

import com.ironhack.finalprojectdoctorservice.model.Address;

public class AddressDTO {

    private String street;
    private Integer portal;
    private Integer number;

    public AddressDTO() {
    }

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

    public static Address addressDTOToAddress(AddressDTO addressDTO) {
        Address address = new Address();
            address.setStreet(addressDTO.getStreet());
            address.setPortal(addressDTO.getPortal());
            address.setNumber(addressDTO.getNumber());
        return address;
    }
}
