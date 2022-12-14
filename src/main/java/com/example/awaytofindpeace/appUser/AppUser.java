package com.example.awaytofindpeace.appUser;

import com.example.awaytofindpeace.doctor.DoctorUser;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

// These annotations are from Lombok dependencies
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Component
public class AppUser implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    private Long id;

    //@NotEmpty(message = "")
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Nullable
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked;
    private Boolean enabled;

    public AppUser(String firstName,
                   String lastName,
                   String email,
                   String password,
                   String phoneNumber,
                   AppUserRole appUserRole,
                   Boolean locked,
                   Boolean enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber=phoneNumber;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public AppUserRole getAppUserRole() {
        return appUserRole;
    }
    public void setAppUserRole(AppUserRole appUserRole) {
        this.appUserRole = appUserRole;
    }
    public Boolean getLocked() {
        return locked;
    }
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
    public Boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
