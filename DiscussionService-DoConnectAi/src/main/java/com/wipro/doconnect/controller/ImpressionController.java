package com.wipro.doconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.doconnect.dto.ImpressionDto;
import com.wipro.doconnect.service.ImpressionService;

@RestController
@RequestMapping("/impressions")
public class ImpressionController {

	@Autowired
	private ImpressionService impressionService;

	@PostMapping
	public ImpressionDto saveImpression(@RequestBody ImpressionDto dto) {
		return impressionService.saveImpression(dto);
	}
}
