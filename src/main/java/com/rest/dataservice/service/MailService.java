package com.rest.dataservice.service;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.HelpFeedback;
import com.rest.dataservice.entity.MailHeader;
import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.repository.MailHeaderRepository;
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
	
	private static final Logger logger = LoggerFactory.getLogger(MailService.class);


	private static final String QUERY = "query";

	private static final String NO_QUERY_FOUND = "No Query found";

	private static final String HELP_QUERY = "Help Query";

	private static final String APP_URL = "appUrl";

	private static final String BODY = "body";

	private static final String USER = "user";

	private static final String MAIL_SENDING_FAILED = "Mail Sending failed";

	private static final String CHANGE_PASSWORD = "change password";

	private static final String MAIL_SENT_SUCCESSFULLY = "Mail sent Successfully";

	private static final  CommonApiStatus SuccessApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS,
			HttpStatus.OK, ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);

	private static final  CommonApiStatus failedApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
			HttpStatus.INTERNAL_SERVER_ERROR, "Error in Sending mail");

	private JavaMailSender javaMailSender;

	@Autowired
	private SpringTemplateEngine templateEngine;

	@Autowired
	private MailHeaderRepository mailContentRepository;

	@Autowired
	UserService userService;

	@Value("${ds.base.url}")
	String baseUrl;

	@Value("${app.login.url}")
	String applicationUrl;

	@Value("${server.servlet.context-path}")
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
			MailHeader header=mailContentRepository.findByFilter(CHANGE_PASSWORD);	
			Context context = new Context();
			Map<String, Object> model = new HashMap<>();
			model.put(USER, user);
			model.put(BODY,header.getMailBody());
			model.put(APP_URL,applicationUrl);
			String url = baseUrl+apiMap;

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(ApplicationConstants.DATE_TIME_FORMATTER);  
			LocalDateTime now = LocalDateTime.now();  
			String currenDate=dtf.format(now);
			String fieldData=user.getEmail()+","+currenDate;
			String encryptedData=Base64.getEncoder().encodeToString(RSAUtil.encrypt(fieldData, userService.getUserPublicKey(user.getUserName())));
			model.put("resetUrl", url + "/reset-password?fields="+encryptedData+"&username="+user.getUserName());


			context.setVariables(model);
			String html = templateEngine.process("change-pwd-mail", context);

			//SimpleMailMessage mail = new SimpleMailMessage();

			mail.setTo(user.getEmail());
			mail.setSubject(header.getMailSubject());
			mail.setText(html,true);
			mail.setSentDate(new Date());

			javaMailSender.send(message);

			return new ResponseObject(MAIL_SENT_SUCCESSFULLY, SuccessApiStatus);

		}catch(Exception e) {
			
			logger.error("Error inside method sendEmail :: "+e.getMessage());

			return new ResponseObject(MAIL_SENDING_FAILED, failedApiStatus);

		}

	}

	public ResponseObject sendFeedbackEmail(HelpFeedback helpFeedbackOp) {

		try {

			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper mail = new MimeMessageHelper(message,
					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			MailHeader header=mailContentRepository.findByFilter(HELP_QUERY);	
			Context context = new Context();
			Map<String, Object> model = new HashMap<>();
			model.put(USER, helpFeedbackOp);
			model.put(BODY,header.getMailBody());
			model.put(QUERY,helpFeedbackOp.getQuery() == null ? NO_QUERY_FOUND : helpFeedbackOp.getQuery());
			model.put(APP_URL,applicationUrl);
			String url = baseUrl+apiMap;

			context.setVariables(model);
			String html = templateEngine.process("help-query-mail", context);

			//SimpleMailMessage mail = new SimpleMailMessage();

			mail.setTo(helpFeedbackOp.getEmail());
			mail.setSubject(header.getMailSubject());
			mail.setText(html,true);
			mail.setSentDate(new Date());

			javaMailSender.send(message);

			return new ResponseObject(MAIL_SENT_SUCCESSFULLY, SuccessApiStatus);

		}catch(Exception e) {
			
			logger.error("Error inside method sendFeedback :: "+e.getMessage());

			return new ResponseObject(MAIL_SENDING_FAILED, failedApiStatus);

		}


	}

}
