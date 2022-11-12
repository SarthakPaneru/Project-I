package com.example.awaytofindpeace.doctor;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService {

    private final String DATE_NOT_FOUND_MSG = "Sorry date is not available";

    private final DoctorUserRepository doctorUserRepository;

    public void saveDoctorUser(DoctorUser doctor) {

        doctorUserRepository.save(doctor);
    }

    public List<DoctorUser> findDoctors() {
        return doctorUserRepository.findAll();
    }


}
