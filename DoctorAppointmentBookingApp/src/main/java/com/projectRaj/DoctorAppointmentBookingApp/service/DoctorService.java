package com.projectRaj.DoctorAppointmentBookingApp.service;


import com.projectRaj.DoctorAppointmentBookingApp.model.Doctor;
import com.projectRaj.DoctorAppointmentBookingApp.model.Qualification;
import com.projectRaj.DoctorAppointmentBookingApp.model.Specialization;
import com.projectRaj.DoctorAppointmentBookingApp.model.dto.AuthenticationInputDto;
import com.projectRaj.DoctorAppointmentBookingApp.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepo;

    @Autowired
    PTokenService pTokenService;


    public List<Doctor> getAllDoctors(AuthenticationInputDto authInfo) {
        if(pTokenService.authenticate(authInfo)) {
            return doctorRepo.findAll();
        }
        else {
            return null;
        }
    }

    public String addDoctor(Doctor newDoctor) {

        Integer docId = newDoctor.getDocId();

        if(docId!=null && doctorRepo.existsById(docId))
        {
            return "doctor already exists!!!";
        }

        newDoctor.setAppointments(null);// linking anyway does not happen from non fk side

        doctorRepo.save(newDoctor);

        return "doctor added!!!";
    }

    public Doctor getDoctorById(Integer id) {

        return doctorRepo.findById(id).orElseThrow();

    }

    public List<Doctor> getDoctorsByQualificationOrSpec(AuthenticationInputDto authInfo,Qualification qual, Specialization spec) {

        if(pTokenService.authenticate(authInfo)) {

            List<Doctor> doctors = doctorRepo.findByDocQualificationOrDocSpecialization(qual, spec);

            return doctors.stream().
                    map(doc -> {
                        doc.setAppointments(null);
                        return doc;
                    })
                    .collect(Collectors.toList());

        }
        else {
            return null;
        }
    }
}
