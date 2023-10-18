package com.projectRaj.DoctorAppointmentBookingApp.service;


import com.projectRaj.DoctorAppointmentBookingApp.model.PatientAuthenticationToken;
import com.projectRaj.DoctorAppointmentBookingApp.model.dto.AuthenticationInputDto;
import com.projectRaj.DoctorAppointmentBookingApp.repo.PTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PTokenService {


    @Autowired
    PTokenRepository pTokenRepository;

    public void createToken(PatientAuthenticationToken token) {
        pTokenRepository.save(token);
    }

    public void deleteToken(String tokenValue) {

        PatientAuthenticationToken token =  pTokenRepository.findFirstByTokenValue(tokenValue);
        pTokenRepository.delete(token);

    }

    public boolean authenticate(AuthenticationInputDto authInfo) {

        String email = authInfo.getEmail();
        String tokenValue = authInfo.getTokenValue();

        //find thr actual token -> get the connected patient -> get its email-> verify with passed email

       //return pTokenRepository.findFirstByTokenValue(tokenValue).getPatient().getPatientEmail().equals(email);

        PatientAuthenticationToken token =  pTokenRepository.findFirstByTokenValue(tokenValue);
       if(token!=null)
       {
           return token.getPatient().getPatientEmail().equals(email);
       }
       else
       {
           return false;
       }

    }
}
