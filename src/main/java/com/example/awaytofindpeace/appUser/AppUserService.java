package com.example.awaytofindpeace.appUser;

import com.example.awaytofindpeace.doctor.DoctorUserRepository;
import com.example.awaytofindpeace.doctor.DoctorUser;
import com.example.awaytofindpeace.registration.token.ConfirmationToken;
import com.example.awaytofindpeace.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
    import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with %s not found";
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    private final DoctorUserRepository doctorUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(AppUser appUser) {
        Optional<AppUser> user = appUserRepository.findByEmail(appUser.getEmail());

        boolean userExists = user.isPresent();

        if (userExists) {

            if (user.get().getEnabled()) {
                System.out.println("Hello");
                throw new IllegalStateException("Email already taken");
            }
            this.enableAppUser(appUser.getEmail());
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);

        // Copy the details of AppUser to DoctorUser
        if(appUser.getAppUserRole().equals("DOCTOR")) {
            DoctorUser doctorUser1 = new DoctorUser(
                    appUser.getFirstName(),
                    appUser.getLastName(),
                    appUser.getEmail(),
                    "Hey"
            );
        }

        // Send Confirmation token
        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken
        );

        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

//    public void isDoctor(AppUser appUser) {
//        if (appUser.getAppUserRole().equals("DOCTOR")) {
//
//        }
//    }

    // Insert data in database at system startup
    @EventListener
    public void atStart(ApplicationReadyEvent event) {
        appUserRepository.save(new AppUser(
                "hello",
                "hello",
                "hello@gmail.com",
                bCryptPasswordEncoder.encode("hello"),
                "123456789",
                AppUserRole.ADMIN,
                false,
                true
        ));
        appUserRepository.save(new AppUser(
                "hello1",
                "hello",
                "hello1@gmail.com",
                bCryptPasswordEncoder.encode("hello"),
                "123456789",
                AppUserRole.USER,
                false,
                true
        ));
        appUserRepository.save(new AppUser(
                "hello2",
                "hello",
                "hello2@gmail.com",
                bCryptPasswordEncoder.encode("hello"),
                "123456789",
                AppUserRole.USER,
                false,
                true
        ));
        appUserRepository.save(new AppUser(
                "hello3",
                "hello",
                "hello3@gmail.com",
                bCryptPasswordEncoder.encode("hello"),
                "123456789",
                AppUserRole.USER,
                false,
                true
        ));
        AppUser appUser1 = appUserRepository.save(new AppUser(
                "hello4",
                "hello",
                "hello4@gmail.com",
                bCryptPasswordEncoder.encode("hello"),
                null,
                AppUserRole.DOCTOR,
                false,
                true
        ));
        AppUser appUser2 = appUserRepository.save(new AppUser(
                "hello5",
                "hello",
                "hello5@gmail.com",
                bCryptPasswordEncoder.encode("hello"),
                null,
                AppUserRole.DOCTOR,
                false,
                true
        ));


//        Optional<AppUser> appUser1 = appUserRepository.findByEmail("hello4@gmail.com");
//        Optional<AppUser> appUser2 = appUserRepository.findByEmail("hello5@gmail.com");

        doctorUserRepository.save( new DoctorUser(
                appUser1.getFirstName(),
                appUser1.getLastName(),
                appUser1.getEmail(),
                "Hey there from hello4"

        ));

        doctorUserRepository.save( new DoctorUser(
                appUser2.getFirstName(),
                appUser2.getLastName(),
                appUser2.getEmail(),
                "Hey there from hello5"

        ));

    }
}
