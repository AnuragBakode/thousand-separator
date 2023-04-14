package com.separator.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.separator.service.ThousandFormatterService;

@RestController
public class Controller {
	
	@Autowired
	ThousandFormatterService thousandformatterservice;
	
	
	@PostMapping("/test")
	public String thousandFormatter(@RequestBody BigDecimal number){
		return this.thousandformatterservice.thousandFormatter(number);
		
	}
}
