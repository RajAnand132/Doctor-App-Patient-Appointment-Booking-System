package com.projectRaj.DoctorAppointmentBookingApp.model.dto;

import com.projectRaj.DoctorAppointmentBookingApp.model.Appointment;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleAppointmentDto {

    AuthenticationInputDto authInfo;
    Appointment appointment;
}
