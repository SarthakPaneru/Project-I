package com.example.awaytofindpeace.doctor;

import com.example.awaytofindpeace.appUser.AppUser;
import com.example.awaytofindpeace.appUser.AppUserRole;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table
public class DoctorUser {

    @SequenceGenerator(
            name = "doctor_user_sequence",
            sequenceName = "doctor_user_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doctor_user_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String desc;



    @ManyToOne
    @JoinColumn(
//            nullable = false,
            name = "doctor_user_id1"
    )
    private AppUser appUser;

    // Doctor ko appointment date hunu vanda patient ko banako ramro
//    @OneToMany
//    @JoinColumn(
//            nullable = false,
//            name = "doctor_user_id"
//    )
//    private Set<AppointmentDate> appointmentDate;


    public DoctorUser(String firstName, String lastName, String email, String desc) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.desc = desc;
    }

    @Autowired
    public Long getId() {
        return id;
    }

    @Autowired
    public void setId(Long id) {
        this.id = id;
    }

    @Autowired
    public String getFirstName() {
        return firstName;
    }

    @Autowired
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Autowired
    public String getLastName() {
        return lastName;
    }

    @Autowired
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Autowired
    public String getEmail() {
        return email;
    }

    @Autowired
    public void setEmail(String email) {
        this.email = email;
    }

    @Autowired
    public String getDesc() {
        return desc;
    }

    @Autowired
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
