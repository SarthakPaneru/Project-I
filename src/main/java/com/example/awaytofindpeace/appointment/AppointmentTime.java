//package com.example.awaytofindpeace.appointmentTime;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Getter
//@Setter
//@Entity
//@Table
//@NoArgsConstructor
//public class AppointmentTime {
//
//    @Id
//    @SequenceGenerator(
//            name = "appointment_time_sequence",
//            sequenceName = "appointment_time_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "appointment_time_sequence"
//    )
//    private Long id;
//
//    private Integer appointmentTime;
//
//    public AppointmentTime(Integer appointmentTime) {
//        this.appointmentTime = appointmentTime;
//    }
//
//    public Integer getAppointmentTime() {
//        return appointmentTime;
//    }
//
//    public void setAppointmentTime(Integer appointmentTime) {
//        this.appointmentTime = appointmentTime;
//    }
//}
