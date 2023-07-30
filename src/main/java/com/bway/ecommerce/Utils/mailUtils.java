package com.bway.ecommerce.Utils;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;


import com.bway.ecommerce.model.User;
import com.bway.ecommerce.repository.UserRepository;
import com.bway.ecommerce.service.UserService;

@Component
public class mailUtils {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserService userService;
	@Autowired
    private JavaMailSender javaMailSender;
	
	
	public void forgetpwdEmail(String toEmail) {

		
		UUID uuid = UUID.randomUUID();
		String uuidString = uuid.toString().replace("-","");
		String pwd = uuidString.substring(0,8);
		User email = userService.getUserByEmail(toEmail);
		if (email == null) {
			System.out.println("Email doesnot exist");
		}
		System.out.println(email);
	    email.setPassword(DigestUtils.md5DigestAsHex(pwd.getBytes()));
	    userRepo.save(email);
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(toEmail);

        msg.setSubject("Rest your password");
        msg.setText("This is you password" + pwd);

        javaMailSender.send(msg);

    }
}
