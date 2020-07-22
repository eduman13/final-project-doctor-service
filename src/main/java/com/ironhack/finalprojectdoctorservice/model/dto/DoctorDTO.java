package com.ironhack.finalprojectdoctorservice.model.dto;

import com.ironhack.finalprojectdoctorservice.model.Doctor;

import java.time.LocalDate;

public class DoctorDTO {

    private Long id;
    private String name;
    private String surnames;
    private String schoolNumber;
    private LocalDate birthday;
    private String street;
    private Integer portal;
    private Integer number;

    public DoctorDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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

    public static DoctorDTO doctorToDoctorDTO(Doctor doctor) {
        DoctorDTO doctorDTO = new DoctorDTO();
            doctorDTO.setId(doctor.getId());
            doctorDTO.setName(doctor.getName());
            doctorDTO.setSurnames(doctor.getSurnames());
            doctorDTO.setSchoolNumber(doctor.getSchoolNumber());
            doctorDTO.setBirthday(doctor.getBirthday());
            doctorDTO.setStreet(doctor.getAddress().getStreet());
            doctorDTO.setPortal(doctor.getAddress().getPortal());
            doctorDTO.setNumber(doctor.getAddress().getNumber());
        return doctorDTO;
    }
}
