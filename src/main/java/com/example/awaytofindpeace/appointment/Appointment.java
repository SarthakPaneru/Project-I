package com.example.awaytofindpeace.appointment;

import com.example.awaytofindpeace.appUser.AppUser;
import com.example.awaytofindpeace.doctor.DoctorUser;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Appointment {

    @Id
    @SequenceGenerator(
            name = "appointment_sequence",
            sequenceName = "appointment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appointment_sequence"
    )
    private Long id;

    @ManyToOne
    private AppUser appUser;

    @ManyToOne
    private DoctorUser doctorUser;

    @ManyToOne
    private AppointmentDate appointmentDate;

    public Appointment(AppUser appUser, DoctorUser doctorUser, AppointmentDate appointmentDate) {
        this.appUser = appUser;
        this.doctorUser = doctorUser;
        this.appointmentDate = appointmentDate;
    }

    @Autowired
    public Long getId() {
        return id;
    }

    @Autowired
    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    @Autowired
    public DoctorUser getDoctorUser() {
        return doctorUser;
    }

    @Autowired
    public void setDoctorUser(DoctorUser doctorUser) {
        this.doctorUser = doctorUser;
    }

    @Autowired
    public AppointmentDate getAppointmentDate() {
        return appointmentDate;
    }

    @Autowired
    public void setAppointmentDate(AppointmentDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
