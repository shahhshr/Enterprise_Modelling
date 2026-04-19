package com.example.doctorservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.doctorservice.model.Doctor;
import com.example.doctorservice.service.DoctorService;

@Controller
public class DoctorViewController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/doctors/add")
    public String showAddForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "add-doctor";
    }

    @PostMapping("/doctors/save")
    public String saveDoctor(@ModelAttribute Doctor doctor) {
        doctorService.addDoctor(doctor);
        return "redirect:/doctors/view";
    }

    @GetMapping("/doctors/view")
    public String viewDoctors(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "view-doctors";
    }

    @GetMapping("/doctors/delete/{id}")
    public String deleteDoctor(@PathVariable String id) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctors/view";
    }

    @GetMapping("/doctors/edit/{id}")
    public String editDoctor(@PathVariable String id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id).orElseThrow();
        model.addAttribute("doctor", doctor);
        return "edit-doctor";
    }

    @PostMapping("/doctors/update")
    public String updateDoctor(@ModelAttribute Doctor doctor) {
        doctorService.updateDoctor(doctor.getDoctorId(), doctor);
        return "redirect:/doctors/view";
    }
}