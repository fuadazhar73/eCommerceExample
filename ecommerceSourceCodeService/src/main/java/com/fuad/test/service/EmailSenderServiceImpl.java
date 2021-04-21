package com.fuad.test.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.fuad.test.model.Code;
import com.fuad.test.model.Customer;
import com.fuad.test.service.CodeService;
import com.fuad.test.service.EmailSenderService;

@Service
public class EmailSenderServiceImpl implements EmailSenderService{

	@Autowired
	private CodeService codeService;
	@Autowired
	private MailSender mailSender;
	@Value("${fromAddress}")
	private String fromAddress;
	@Value("${websiteAddr}")
	private String websiteAddr;
	
	public void sendMail(String toAddress, String subject, String msgBody){
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(fromAddress);
		msg.setTo(toAddress);
		msg.setSubject(subject);
		msg.setText(msgBody);
		mailSender.send(msg);
	}
	
	public void sendActiveCode(Customer customer){
		List<Code> codes = codeService.findByCodeTypeAndCustomer(0, customer);
		String msgBody = "Click or copy this link to the browser -> http://" + websiteAddr + "/rg/";
		for(Code code : codes){
			msgBody = msgBody + code.getCodeStr();
			break;
		}
		sendMail(customer.getEmail(), "Active Your Account", msgBody);
		
	}
	
	public void sendResetPasswordCode(Customer customer){
		Code code = new Code();
		code.setCodeDate(new Date());
		code.setCodeType(1);
		code.setCustomer(customer);
		
		codeService.save(code);
		String msgBody = websiteAddr + "/rp/" + code.getCodeStr();
		sendMail(customer.getEmail(), "Reset Your Passowrd", msgBody);
	}
}
