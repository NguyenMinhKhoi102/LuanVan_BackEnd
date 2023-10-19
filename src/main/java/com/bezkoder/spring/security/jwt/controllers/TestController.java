package com.bezkoder.spring.security.jwt.controllers;

import com.bezkoder.spring.security.jwt.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

	@Autowired
	MailService mailService;


	@GetMapping("/all")
	public String allAccess() {
		try{
//			String htmlContent = "<!DOCTYPE html>\n" +
//					"<html>\n" +
//					"<head>\n" +
//					"<style>\n" +
//					"  body {\n" +
//					"    font-family: Arial, sans-serif;\n" +
//					"    background-color: #f2f2f2;\n" +
//					"  }\n" +
//					"  .container {\n" +
//					"    background-color: #ffffff;\n" +
//					"    padding: 20px;\n" +
//					"    border-radius: 5px;\n" +
//					"    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
//					"  }\n" +
//					"  h1 {\n" +
//					"    color: blue;\n" +
//					"  }\n" +
//					"  p {\n" +
//					"    color: #666666;\n" +
//					"  }\n" +
//					"</style>\n" +
//					"</head>\n" +
//					"<body>\n" +
//					"<div class=\"container\">\n" +
//					"  <h1>Hello, World!</h1>\n" +
//					"  <p>This is an HTML email with CSS styling.</p>\n" +
//					"</div>\n" +
//					"</body>\n" +
//					"</html>";
//
//
//			String filePath = "/Users/user/Downloads/spring-boot-refresh-token-jwt-master/src/main/resources/templates/CT06_Phiếu_từ_chối_tiếp_nhận,_giải_quyết_hồ_sơ.doc";
//			Path path = Paths.get(filePath);
//
//			byte[] fileBytes = Files.readAllBytes(path);
//			mailService.sendEmailWithAttachment("nguyenkhoi25022018@gmail.com", "Test", htmlContent, fileBytes, "test.doc");
			return "Public Content.";
		}catch (Exception e){
			System.out.println(e);
			return "Lỗi";
		}

	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('PROVINCE') or hasRole('DISTRICT') or hasRole('WARD') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('DISTRICT')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
