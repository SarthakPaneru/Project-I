package com.example.awaytofindpeace.registration;

import com.example.awaytofindpeace.appUser.AppUser;
import com.example.awaytofindpeace.appUser.AppUserRole;
import com.example.awaytofindpeace.appUser.AppUserService;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid");
        }
        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER,
                        false,
                        true
                )
        );
    }
}
