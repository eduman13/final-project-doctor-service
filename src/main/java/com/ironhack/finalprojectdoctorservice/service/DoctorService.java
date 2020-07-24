package com.ironhack.finalprojectdoctorservice.service;

import com.ironhack.finalprojectdoctorservice.exception.NotFoundDoctorException;
import com.ironhack.finalprojectdoctorservice.model.Doctor;
import com.ironhack.finalprojectdoctorservice.model.dto.AddressDTO;
import com.ironhack.finalprojectdoctorservice.model.dto.DoctorDTO;
import com.ironhack.finalprojectdoctorservice.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public DoctorDTO findById(Long id) throws NotFoundDoctorException {
        return DoctorDTO.doctorToDoctorDTO(doctorRepository.findById(id).orElseThrow(() -> new NotFoundDoctorException("Doctor " + id + " does not exist")));
    }

    public void updateAddress(Long id, AddressDTO addressDTO) throws NotFoundDoctorException {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new NotFoundDoctorException("Doctor " + id + " does not exist"));
            doctor.setAddress(AddressDTO.addressDTOToAddress(addressDTO));
        doctorRepository.save(doctor);
    }

    public List<DoctorDTO> findAll() {
        return doctorRepository.findAll().stream().map(DoctorDTO::doctorToDoctorDTO).collect(Collectors.toList());
    }

    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        return DoctorDTO.doctorToDoctorDTO(doctorRepository.save(DoctorDTO.doctorDTOToDoctor(doctorDTO)));
    }

}
