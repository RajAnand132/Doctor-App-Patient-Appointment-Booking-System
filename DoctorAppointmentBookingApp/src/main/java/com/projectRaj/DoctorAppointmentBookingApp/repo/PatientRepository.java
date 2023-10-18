package com.projectRaj.DoctorAppointmentBookingApp.repo;

import com.projectRaj.DoctorAppointmentBookingApp.model.BloopGroup;
import com.projectRaj.DoctorAppointmentBookingApp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Integer> {


    Patient findFirstByPatientEmail(String newEmail);

    List<Patient> findByPatientBloodGroup(BloopGroup bloodGroup);
}
