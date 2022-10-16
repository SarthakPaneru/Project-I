package com.example.awaytofindpeace.registration;

import lombok.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // Used against @AllArgsConstructor to remove error
@Getter
@EqualsAndHashCode
@ToString
public class RegistrationService {
//    private final String firstName;
//    private final String lastName;
//    private final String email;
//    private final String password;

    public String register(RegistrationRequest request) {
        return "works";
    }
}
