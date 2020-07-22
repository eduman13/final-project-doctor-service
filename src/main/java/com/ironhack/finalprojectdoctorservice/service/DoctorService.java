package com.ironhack.finalprojectdoctorservice.service;

import com.ironhack.finalprojectdoctorservice.model.Address;
import com.ironhack.finalprojectdoctorservice.model.Doctor;
import com.ironhack.finalprojectdoctorservice.model.dto.AddressDTO;
import com.ironhack.finalprojectdoctorservice.model.dto.DoctorDTO;
import com.ironhack.finalprojectdoctorservice.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public DoctorDTO findById(Long id) throws Exception {
        return DoctorDTO.doctorToDoctorDTO(doctorRepository.findById(id).orElseThrow(() -> new Exception("Not Found")));
    }

    public void updateAddress(Long id, AddressDTO addressDTO) throws Exception {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new Exception("Not Found"));
            doctor.setAddress(AddressDTO.addressDTOToAddress(addressDTO));
        doctorRepository.save(doctor);
    }

}
