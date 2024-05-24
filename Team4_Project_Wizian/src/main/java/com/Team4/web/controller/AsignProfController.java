package com.Team4.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AsignProfController {
	
	
	@GetMapping("/profcusl")
	public String profCusl() {
		return "profcusl/professerConsultation";
	}
	
	@GetMapping("/calendar")
	public String calendar(HttpSession session) {
		return "profcusl/calendartest";
	}
	
	@GetMapping("/profcusl/profComplite")
	public String profResult() {
		return "profcusl/profComplite";
	}
	
	
}
