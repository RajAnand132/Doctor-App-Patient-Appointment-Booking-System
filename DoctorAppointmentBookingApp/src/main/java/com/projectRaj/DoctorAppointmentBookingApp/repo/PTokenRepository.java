package com.projectRaj.DoctorAppointmentBookingApp.repo;

import com.projectRaj.DoctorAppointmentBookingApp.model.PatientAuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PTokenRepository extends JpaRepository<PatientAuthenticationToken,Integer> {
    PatientAuthenticationToken findFirstByTokenValue(String tokenValue);
}
