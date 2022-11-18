package com.example.awaytofindpeace.doctor;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public DoctorUser findById(Integer id) {
        return doctorUserRepository.findById(id.longValue())
                .orElse(null);
    }
}
