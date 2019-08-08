package com.scerp.customerservicedepartment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.scerp.customerservicedepartment.domain.FeedbackEntity;
import com.scerp.customerservicedepartment.domain.Id;
import com.scerp.customerservicedepartment.domain.QueryData;
import com.scerp.customerservicedepartment.domain.QueryEntity;
import com.scerp.customerservicedepartment.domain.ToDoEvent;
import com.scerp.customerservicedepartment.service.ToDoService;




@RestController
@RequestMapping("/")
public class ToDoController {
	@Autowired
	private ToDoService toDoService;
	
	@RequestMapping(value = "/submitQuery", method = RequestMethod.POST)
	public String addQuery(@RequestBody QueryEntity queryInfo){
		return toDoService.addQueryService(queryInfo);
	}
	
	@GetMapping
	@RequestMapping("/monitorQuery")
	public String monitorQuery() {
		return toDoService.monitorQueryService();
	}
	
	
	@RequestMapping(value = "/resolveQuery", method = RequestMethod.POST)
	public String resolveQuery(@RequestBody Id id){
		return toDoService.resolveQueryService(id);

	}
	
	@RequestMapping(value = "/farwardQueryToSales", method = RequestMethod.POST)
	public String farwardQuery(@RequestBody Id id) {
		return toDoService.farwardQueryService(id);
	}
	
	@RequestMapping(value = "/fillFeedback", method = RequestMethod.POST)
	public String addQuery(@RequestBody FeedbackEntity feedbackInfo){
		return toDoService.addFeedback(feedbackInfo);
	}
	
	@GetMapping
	@RequestMapping("/generateFeedbackReport")
	public String generateFeedbackReport() {
		return toDoService.generateFeedbackReportService();
	}
	
	
	
	
}