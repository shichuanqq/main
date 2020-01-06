package com.example.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailUtils {

    @Value("${spring.mail.username}")
    private String form;

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 普通方法
     */
    public void sendEmail(String msg, String email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(form);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("这是一封邮件");
        simpleMailMessage.setText(msg);
        javaMailSender.send(simpleMailMessage);
    }

    public void sendHtmlEmail(String msg, String email){
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setFrom(form);
            messageHelper.setTo(email);
            messageHelper.setSubject("这是一封邮件");
            String html = "<div><h1><a>1111</a></h1></div>";
            messageHelper.setText(html, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
