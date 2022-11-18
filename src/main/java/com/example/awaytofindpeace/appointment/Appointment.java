package com.example.awaytofindpeace.appointment;

import com.example.awaytofindpeace.appUser.AppUser;
import com.example.awaytofindpeace.doctor.DoctorUser;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.time.LocalDate;

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

    private String appointmentType = "basic";

    @ManyToOne
    private AppUser appUser;

    @ManyToOne
    private DoctorUser doctorUser;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate appointmentDate;
    private String appointmentTime;

    private String appointmentPaid;

    public Appointment(AppUser appUser, DoctorUser doctorUser, LocalDate appointmentDate, String appointmentTime) {
        this.appUser = appUser;
        this.doctorUser = doctorUser;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public Appointment(AppUser appUser, DoctorUser doctorUser, LocalDate appointmentDate, String appointmentTime, String appointmentPaid) {
        this.appUser = appUser;
        this.doctorUser = doctorUser;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.appointmentPaid = appointmentPaid;
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
    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    @Autowired
    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Autowired
    public String getAppointmentTime() {
        return appointmentTime;
    }

    @Autowired
    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    @Autowired
    public String getAppointmentPaid() {
        return appointmentPaid;
    }

    @Autowired
    public void setAppointmentPaid(String appointmentPaid) {
        this.appointmentPaid = appointmentPaid;
    }

    @Autowired
    public String getAppointmentType() {
        return appointmentType;
    }

    @Autowired
    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }
}
