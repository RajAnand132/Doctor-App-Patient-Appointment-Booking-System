package com.projectRaj.DoctorAppointmentBookingApp.controller;


import com.projectRaj.DoctorAppointmentBookingApp.model.BloopGroup;
import com.projectRaj.DoctorAppointmentBookingApp.model.Doctor;
import com.projectRaj.DoctorAppointmentBookingApp.model.Patient;
import com.projectRaj.DoctorAppointmentBookingApp.service.DoctorService;
import com.projectRaj.DoctorAppointmentBookingApp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class AdminController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    @GetMapping("patients")
    public List<Patient> getAllPatients()
    {
        return patientService.getAllPatients();
    }

    @PostMapping("doctor")
    public String addDoctor(@RequestBody Doctor newDoctor)
    {
        return doctorService.addDoctor(newDoctor);
    }

    @GetMapping("patients/bloodGroup/{bloodGroup}")
    public List<Patient> getAllPatientsByBloodGroup(@PathVariable BloopGroup bloodGroup)
    {
        return patientService.getAllPatientsByBloodGroup(bloodGroup);
    }


}
