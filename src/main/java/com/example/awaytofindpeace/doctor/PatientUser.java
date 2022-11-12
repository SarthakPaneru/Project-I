package com.example.awaytofindpeace.doctor;

import com.example.awaytofindpeace.appUser.AppUser;

import javax.persistence.*;

@Entity
@Table
public class PatientUser {

    @Id
    @SequenceGenerator(name = "patient_sequence_generator", sequenceName = "patient_sequence_generator",initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_user_sequence")
    private Long id;

//    @Transient
//    private AppUser appUser;
}
