package com.example.patientservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.patientservice.model.Patient;
import com.example.patientservice.service.PatientService;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Home Page
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Show Add Patient Form
    @GetMapping("/patients/add")
    public String showAddForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient";
    }

    // Save Patient
    @PostMapping("/patients/save")
    public String savePatient(@ModelAttribute Patient patient) {
        patientService.addPatient(patient);
        return "redirect:/patients/view";
    }

    // View All Patients
    @GetMapping("/patients/view")
    public String viewPatients(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "view-patients";
    }

    // Delete Patient
    @GetMapping("/patients/delete/{id}")
    public String deletePatient(@PathVariable String id) {
        patientService.deletePatient(id);
        return "redirect:/patients/view";
    }

    // Edit Patient Form
    @GetMapping("/patients/edit/{id}")
    public String editPatient(@PathVariable String id, Model model) {
        Patient patient = patientService.getPatientById(id).orElseThrow();
        model.addAttribute("patient", patient);
        return "edit-patient";
    }

    // Update Patient
    @PostMapping("/patients/update")
    public String updatePatient(@ModelAttribute Patient patient) {
        patientService.updatePatient(patient.getPatientId(), patient);
        return "redirect:/patients/view";
    }
}