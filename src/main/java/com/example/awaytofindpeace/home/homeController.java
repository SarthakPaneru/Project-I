package com.example.awaytofindpeace.home;

import com.example.awaytofindpeace.doctor.DoctorUserRepository;
import com.example.awaytofindpeace.doctor.DoctorService;
import com.example.awaytofindpeace.doctor.DoctorUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class homeController {

    private DoctorService doctorService;
    private DoctorUserRepository doctorUserRepository;

    @GetMapping(path = "/services")
    public String getServices() {
        return "services";
    }

    @GetMapping(path = "/about")
    public String getAbout() {
        return "about";
    }

    @GetMapping(path = "/profile")
    public String getProfile() {
        return "profile";
    }

    @GetMapping(path = "/pricing")
    public String getPricing() {

        return "pricing";
    }

    @GetMapping(path = "/register")
    public String getSignup() { return "signup";}

    @GetMapping(path = "/login_page")
    public String loginPage() { return "login"; }

    @GetMapping(path = "/contact_us")
    public String contacPage() { return "contacts"; }

    @GetMapping(path = "/choose-doctor/doc/{id}")
    public ModelAndView chooseDoctor(Model model, @PathVariable Integer id) {
        id = id-1;
        ModelAndView mav = new ModelAndView("product");
        List<DoctorUser> doctors = doctorService.findDoctors();
        DoctorUser doctorUser = doctors.get(id);
        mav.addObject("doctors", doctors);
        mav.addObject("doctorUser", doctorUser);
        return mav;
    }

//    @GetMapping(path = "choose-doctor")
//    public String chooseDoctor() {
//        List<DoctorUser> doctors = doctorUserRepository.findAll();
//        System.out.println(doctors);
//        return "product";
//    }


    @PostMapping("/success")
        public String success(){

        return "success";
        }

}
