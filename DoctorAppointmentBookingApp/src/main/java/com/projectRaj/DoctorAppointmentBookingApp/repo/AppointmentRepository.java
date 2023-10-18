package com.projectRaj.DoctorAppointmentBookingApp.repo;

import com.projectRaj.DoctorAppointmentBookingApp.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
