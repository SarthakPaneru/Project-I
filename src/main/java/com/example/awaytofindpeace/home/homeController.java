package com.example.awaytofindpeace.home;

import com.example.awaytofindpeace.appUser.AppUser;
import com.example.awaytofindpeace.appUser.AppUserService;
import com.example.awaytofindpeace.appointment.Appointment;
import com.example.awaytofindpeace.appointment.AppointmentService;
import com.example.awaytofindpeace.doctor.DoctorUserRepository;
import com.example.awaytofindpeace.doctor.DoctorService;
import com.example.awaytofindpeace.doctor.DoctorUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class homeController {

    private DoctorService doctorService;
    private DoctorUserRepository doctorUserRepository;
    private AppUser appUser;
    private AppUserService appUserService;
    private AppointmentService appointmentService;

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
        return "admin/profile";
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
        ModelAndView mav = new ModelAndView("product");
        List<DoctorUser> doctors = doctorService.findDoctors();
//        id = id-1;
//        Optional<DoctorUser> doctorUser = doctorUserRepository.findById(id.longValue());
        DoctorUser doctorUser = doctorService.findById(id);
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


    @RequestMapping(value = "/success/{id}",method = {RequestMethod.PUT, RequestMethod.GET}) // Appointment id
    @ResponseBody
    public ModelAndView success(
            @PathVariable Integer id,
            @RequestParam String appointmentPaid,
            @Validated
            @ModelAttribute("patient") Appointment patient,
            BindingResult result,
            Model model,
            RedirectView redirectView){

        if (result.hasErrors()) {
            return new ModelAndView("/pricing");
        }

        appointmentService.setAppointmentPaid(id, appointmentPaid);

        ModelAndView mav = new ModelAndView("/admin/profile");

        return mav;
    }

//    @GetMapping("/error")
//    public String getErrorView() {
//        return "error";
//    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "/admin/admin";
    }

    @GetMapping("/table")
    public ModelAndView getTable(Model model) {
        ModelAndView mav = new ModelAndView("admin/table");

        List<AppUser> appUserList = appUserService.getAllUser();
        mav.addObject("userList", appUserList);
        return mav;
    }

    @DeleteMapping("/deleteUser/{id}")
    public ModelAndView deleteUser(
            @PathVariable Integer id,
            Model model) {

        ModelAndView mav = new ModelAndView("admin/table");

        appUserService.deleteUser(id);

        List<AppUser> appUserList = appUserService.getAllUser();
        mav.addObject("userList", appUserList);

        return mav;
    }
}
