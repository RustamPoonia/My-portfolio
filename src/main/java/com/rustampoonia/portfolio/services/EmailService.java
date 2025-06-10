package com.rustampoonia.portfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.rustampoonia.portfolio.dto.ContactRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendMail( ContactRequest request)
    {
        SimpleMailMessage message =new SimpleMailMessage();
       
        message.setTo("rustampoonia@gmail.com");
        message.setSubject(request.getName()+"Want to contact you");
        message.setText("Name: "+request.getName()+"\n"+"Email: "+request.getEmail()+"\n"+"Company :"+request.getUserType()+"\n\n"+"Message:\n"+request.getMessage());
        mailSender.send(message);
    }
}
