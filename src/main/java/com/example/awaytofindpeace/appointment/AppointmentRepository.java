package com.example.awaytofindpeace.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AppointmentRepository
    extends JpaRepository<Appointment, Long> {

//    public List<Appointment> getAll();

    public Appointment getById(Long id);

    @Modifying
    @Query("update Appointment a "
            + "set a.appointmentPaid = ?2 "
            + "where a.id = ?1")
    public int updateAppointmentPaid(Long id, String appointmentPaid);
}
