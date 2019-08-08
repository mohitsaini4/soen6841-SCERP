package com.scerp.customerservicedepartment.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.scerp.customerservicedepartment.domain.FeedbackEntity;
import com.scerp.customerservicedepartment.domain.Id;
import com.scerp.customerservicedepartment.domain.QueryEntity;
import com.scerp.customerservicedepartment.domain.ToDoEvent;
import com.scerp.customerservicedepartment.repository.FeedbackRepository;
import com.scerp.customerservicedepartment.repository.QueryRepository;
import com.scerp.customerservicedepartment.repository.ToDoRepository;

@Service
public class ToDoService {
	@Autowired
	private ToDoRepository todoRepository;
	
	@Autowired
	private QueryRepository queryRepository;
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	
	public String addQueryService(QueryEntity queryInfo){
		queryRepository.save(queryInfo);
		return "Query Added Succesfully";
	}
	
	public String monitorQueryService() {
		return queryRepository.findAll().toString();
	}
	
	public String resolveQueryService(Id id){
		Optional<QueryEntity> query = queryRepository.findById(Long.parseLong(id.getId()));
		System.out.println("hello");
		
		if(query.isPresent()) {
			System.out.println("hello1");
			queryRepository.setNewQueryDetailsForQuery(id.getSolution(), query.get().getUsername());
			return "Query Resolved Successfully";
		}
		else {
			return "Invalid Query Id";
		}
	}
	
	public String farwardQueryService(Id id) {
		Optional<QueryEntity> query = queryRepository.findById(Long.parseLong(id.getId()));
		
		if(query.isPresent()) {
		Map<String, String> urlvariables = new HashMap<>();
		urlvariables.put("queryId", ""+query.get().getId());
		urlvariables.put("query", ""+query.get().getQuery());
		
		if(query.get().isFarwardQueryToSales()==false) {
		ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:8088/sales/addSalesQuery/{queryId}/{query}",String.class,urlvariables);
		String s = responseEntity.getBody();
		queryRepository.setFarwardQueryToSales(true , query.get().getUsername());
		return "Query Successfully farwarded "+s;
		}
		
		else
			return"Query Already transfered";
		}
		else return "Invalid Query Id";
	}
	
	public String addFeedback(FeedbackEntity feedbackInfo){
		feedbackRepository.save(feedbackInfo);
		return "Feedback Added Succesfully";
	}
	
	public String generateFeedbackReportService() {
		return feedbackRepository.findAll().toString();
	}
	
	
	
	@GetMapping
	public Iterable<ToDoEvent> getAllnonDoneEvents() {
		return todoRepository.findAll();
	}

}