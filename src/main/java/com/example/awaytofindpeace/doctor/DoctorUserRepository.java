package com.example.awaytofindpeace.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface DoctorUserRepository
        extends JpaRepository <DoctorUser, Long> {

//    Optional<DoctorUser> findByAvailableDateAndAvailableTime(LocalDate availableDate, String availableTime);

    Optional<DoctorUser> findById(Long id);

    Optional<DoctorUser> findAllByLastName(String email);
    //    @Transactional
//    @Modifying
//    @Query("UPDATE DoctorUser d " +
//            "SET d.availableDate = ?1, " +
//            "d.availableTime = ?2 " +
//            "where d.id = ?3")
//    int updateAppointmentDate(LocalDate availableDate, String availableTime, long id);
}
