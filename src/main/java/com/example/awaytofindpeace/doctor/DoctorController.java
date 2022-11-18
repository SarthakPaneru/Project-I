package com.example.awaytofindpeace.doctor;

import com.example.awaytofindpeace.appUser.AppUser;
import com.example.awaytofindpeace.appointment.Appointment;
import com.example.awaytofindpeace.appointment.AppointmentService;
import com.sun.istack.NotNull;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
//@AllArgsConstructor
@Validated
public class DoctorController {

    private final DoctorService doctorService;
    private final AppointmentService appointmentService;
    private AppUser appUser;

    @Autowired
    public DoctorController(DoctorService doctorService, AppointmentService appointmentService) {
        this.doctorService = doctorService;
        this.appointmentService = appointmentService;
    }

    @PostMapping("/scheduled/{id}") // DoctorUser ko id
    public RedirectView scheduleAppointment(
            @PathVariable Integer id,
            @Validated
            @ModelAttribute("patient")
            @NotNull
            Appointment patient,
            Model model,
            RedirectAttributes attributes
        ) {

//        System.out.println(patient.getId());
//        if (result.hasErrors()) {
//            return "redirect:/";
//        }

        model.addAttribute("patient", patient);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        appUser = (AppUser) authentication.getPrincipal();
        DoctorUser doctorUser = doctorService.findById(id);

        System.out.println("\n\n\n");
        System.out.println(patient.getAppointmentDate() + "  " + patient.getAppointmentTime());
        System.out.println("\n\n\n");


        Appointment appointment = new Appointment(
                appUser,
                doctorUser,
                patient.getAppointmentDate(),
                patient.getAppointmentTime()
        );
//        System.out.println(patient.getAppointmentDate());
//        ModelAndView mav = new ModelAndView("redirect:/choose-doctor/payment-method");


        Appointment appointment1 = appointmentService.appointmentCreated(appointment);
        int id1 = Math.toIntExact(appointment1.getId());

//        attributes.addFlashAttribute("id1", id1);

        return new RedirectView("/choose-doctor/payment-method/"+id1);

    }

    @GetMapping("/choose-doctor/payment-method/{id}") // Appointment ko id
    public String choosePayment(
            @PathVariable Integer id,
            @Validated
            @ModelAttribute("patient") Appointment patient,
            Model model) {

        model.addAttribute("id", id);



        return "choosePayment";
    }

}
