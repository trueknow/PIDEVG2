package tn.esprit.spring.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;
import tn.esprit.spring.entity.Emailler;
import tn.esprit.spring.entity.OffdateVerif;

@RestController
@RequestMapping("/OffdateVerif")
public class verificationController {


    private Emailler Emailler;

    public verificationController(Emailler Emailler) {
        this.Emailler = Emailler;
    }

    @PostMapping
    public void sendFeedback(@RequestBody OffdateVerif OffdateVerif,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException("OffdateVerif is not valid");
        }

        // Create a mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.Emailler.getHost());
        mailSender.setPort(this.Emailler.getPort());
        mailSender.setUsername(this.Emailler.getUsername());
        mailSender.setPassword(this.Emailler.getPassword());

        // Create an email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(OffdateVerif.getEmail());
        mailMessage.setTo("Validator@OffdateVerif.com");
        mailMessage.setSubject("New OffdateVerif from " + OffdateVerif.getName());
        mailMessage.setText(OffdateVerif.getFeedback());

        // Send mail
        mailSender.send(mailMessage);
    }
    
}
