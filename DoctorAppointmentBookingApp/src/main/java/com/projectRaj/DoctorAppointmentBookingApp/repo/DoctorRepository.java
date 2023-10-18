package com.projectRaj.DoctorAppointmentBookingApp.repo;

import com.projectRaj.DoctorAppointmentBookingApp.model.Doctor;
import com.projectRaj.DoctorAppointmentBookingApp.model.Qualification;
import com.projectRaj.DoctorAppointmentBookingApp.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    List<Doctor> findByDocQualificationOrDocSpecialization(Qualification qual, Specialization spec);
}
