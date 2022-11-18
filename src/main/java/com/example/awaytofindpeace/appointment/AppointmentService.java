package com.example.awaytofindpeace.appointment;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentService {

//    private final Appointment appointment;
    private final AppointmentRepository appointmentRepository;

    public Appointment appointmentCreated(Appointment appointment) {

        appointment.getAppointmentDate();
        appointment.getDoctorUser();
        appointment.getAppUser();
        appointment.getAppointmentTime();

        return appointmentRepository.save(appointment);
    }

    public Appointment getById(Integer id) {
        return appointmentRepository.getById(id.longValue());
    }

    public int setAppointmentPaid(Integer id, String appointmentPaid) {
        return appointmentRepository.updateAppointmentPaid(id.longValue(), appointmentPaid);
    }

}
