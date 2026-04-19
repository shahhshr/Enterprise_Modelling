package com.example.appointmentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.appointmentservice.model.Appointment;
import com.example.appointmentservice.service.AppointmentService;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/appointments/add")
    public String showAddForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "add-appointment";
    }

    @PostMapping("/appointments/save")
    public String saveAppointment(@ModelAttribute Appointment appointment, Model model) {
        try {
            appointmentService.addAppointment(appointment);
            return "redirect:/appointments/view";
        } catch (Exception e) {
            model.addAttribute("appointment", appointment);
            model.addAttribute("errorMessage", "Patient ID or Doctor ID is invalid, or related services are not running.");
            return "add-appointment";
        }
    }

    @GetMapping("/appointments/view")
    public String viewAppointments(Model model) {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        model.addAttribute("appointments", appointments);
        return "view-appointments";
    }

    @GetMapping("/appointments/delete/{id}")
    public String deleteAppointment(@PathVariable String id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments/view";
    }

    @GetMapping("/appointments/edit/{id}")
    public String editAppointment(@PathVariable String id, Model model) {
        Appointment appointment = appointmentService.getAppointmentById(id).orElseThrow();
        model.addAttribute("appointment", appointment);
        return "edit-appointment";
    }

    @PostMapping("/appointments/update")
    public String updateAppointment(@ModelAttribute Appointment appointment) {
        appointmentService.updateAppointment(appointment.getAppointmentId(), appointment);
        return "redirect:/appointments/view";
    }
}