package com.example.awaytofindpeace.appointment;

import com.example.awaytofindpeace.doctor.DoctorUser;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class AppointmentDate {

    @Id
    @SequenceGenerator(
            name = "appointment_date_sequence",
            sequenceName = "appointment_date_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appointment_date_sequence"
    )
    private Long id;

    private LocalDate localDate;

//    @OneToMany(mappedBy = "apppointment_time_id", cascade = CascadeType.ALL)
//    @JoinColumn(
//            nullable = false,
//            name = "appointment_time_id"
//    )
//    private AppointmentTime appointmentTime;

    @ManyToOne
    @JoinColumn(
//            nullable = false,
            name = "doctor_user_id"
    )
    private DoctorUser doctorUser;


    public AppointmentDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
