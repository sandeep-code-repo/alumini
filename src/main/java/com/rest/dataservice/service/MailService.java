package com.rest.dataservice.service;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.RSAUtil;
import com.rest.dataservice.util.ResponseObject;

import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author Kamal
 *
 */
@Service
public class MailService {

	
	private JavaMailSender javaMailSender;
	
	@Autowired
    private SpringTemplateEngine templateEngine;
	
	@Autowired
	UserService userService;
	
	@Value("ds_base_url")
	String baseUrl;
	
	@Value("server.servlet.context-path")
	String apiMap;

	/**
	 * 
	 * @param javaMailSender
	 */
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	/**
	 * This function is used to send mail without attachment.
	 * @param user
	 * @throws MailException
	 */
	public ResponseObject sendEmail(UserInfo user) throws MailException {
        
		
		try {
			
			MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper mail = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
			
		Context context = new Context();
		Map<String, Object> model = new HashMap<>();
        model.put("user", user);
        model.put("signature", "nucigent.in");
        String url = baseUrl+apiMap;
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(ApplicationConstants.DATE_TIME_FORMATTER);  
        LocalDateTime now = LocalDateTime.now();  
        String currenDate=dtf.format(now);
        String fieldData=user.getEmail()+","+currenDate;
        String encryptedData=Base64.getEncoder().encodeToString(RSAUtil.encrypt(fieldData, userService.getUserPublicKey(user.getUserName())));
        model.put("resetUrl", url + "/reset-password?fields="+encryptedData+"&username="+user.getUserName());
		
		
        context.setVariables(model);
        String html = templateEngine.process("reset-email", context);
        
		//SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setSubject("OSASP Password Reset request");
		mail.setText(html,true);
		mail.setSentDate(new Date());
		

		javaMailSender.send(message);
		CommonApiStatus SuccessApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS,
				HttpStatus.OK, ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
		return new ResponseObject("Mail sent Successfully", SuccessApiStatus);
		
		}catch(Exception e) {
			
			CommonApiStatus failedApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
					HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
			return new ResponseObject("Mail Sending failed", failedApiStatus);
			
		}
		
	}

}
