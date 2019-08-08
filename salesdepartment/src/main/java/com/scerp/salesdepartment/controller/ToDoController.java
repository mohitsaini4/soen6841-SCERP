package com.scerp.salesdepartment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.scerp.salesdepartment.domain.CustomerData;
import com.scerp.salesdepartment.domain.EmployeeData;
import com.scerp.salesdepartment.domain.OrderEntity;
import com.scerp.salesdepartment.domain.ProductEntity;
import com.scerp.salesdepartment.domain.SalesQueryEntity;
import com.scerp.salesdepartment.domain.ShipmentEntity;
import com.scerp.salesdepartment.domain.ToDoEvent;
import com.scerp.salesdepartment.repository.OrderData;
import com.scerp.salesdepartment.repository.OrderRepository;
import com.scerp.salesdepartment.repository.ProductRepository;
import com.scerp.salesdepartment.repository.SalesQueryRepository;
import com.scerp.salesdepartment.repository.ShipmentRepository;
import com.scerp.salesdepartment.service.ToDoService;


@RestController
@RequestMapping("/")
public class ToDoController {
	@Autowired
	private ToDoService toDoService;


	@GetMapping
	public Iterable<ToDoEvent> getToDoEvent() {
		return toDoService.getAllnonDoneEvents();
	}
	
	@GetMapping
	@RequestMapping("/getProducts")
	public String getProduct() {
		return toDoService.getProductService();
	}
	
	@PostMapping(value="/login")
	public String login(@RequestBody EmployeeData employeedata) {
		return toDoService.loginService(employeedata);
}
	
	@PostMapping
	@RequestMapping("/buyProducts")
	public String buyProducts(@RequestBody OrderEntity orderInfo) {
		return toDoService.buyProductsService(orderInfo);
	}
	
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(@RequestBody ProductEntity productInfo){
		return toDoService.addProductService(productInfo);
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
	public String deleteProduct(@RequestBody ProductEntity productInfo) {
		return toDoService.deleteProductService(productInfo);
	}
	
	@RequestMapping(value = "/searchProduct", method = RequestMethod.POST)
	public String serachProduct(@RequestBody ProductEntity productInfo) {
		return toDoService.serachProductService(productInfo);
	}
	
	
	@RequestMapping(value = "/modifyProduct")
	public String modifyProductDetails(@RequestBody ProductEntity productInfo) {
		return toDoService.modifyProductDetailsService(productInfo);
	}
	
	@RequestMapping(value = "/monitorInventory", method = RequestMethod.POST)
	public String modifyProductInventory(@RequestBody ProductEntity productInfo) {
		return toDoService.modifyProductInventoryService(productInfo);
	}
	
	@RequestMapping(value = "/createShipment", method = RequestMethod.POST)
	public String createShipment(@RequestBody OrderData order){
		return toDoService.createShipmentService(order);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/addSalesQuery/{queryId}/{query}")
	@ResponseBody
	public String checkSalesAuthorization(@PathVariable() String queryId,@PathVariable() String query) {
		return toDoService.checkSalesAuthorizationService(queryId, query);
			
	}
	
	@GetMapping
	@RequestMapping("/viewSalesQuery")
	public String viewSalesQuery() {
		return toDoService.viewSalesQueryService();
	}
	
	@RequestMapping(value = "/resolveSalesQuery", method = RequestMethod.POST)
	public String resolveSalesQuery(@RequestBody SalesQueryEntity queryInfo){
		return toDoService.resolveSalesQueryService(queryInfo);
	}
	
	
	@GetMapping
	@RequestMapping("/viewAllOrders")
	public String viewAllOrders() {
		return toDoService.viewAllOrdersService();

	}
	
	@GetMapping
	@RequestMapping("/viewAllShipments")
	public String viewAllShipments() {
		return toDoService.viewAllShipmentsService();

	}
	
	@RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
	public String deleteEmployee(@RequestBody OrderEntity orderInfo) {
		return toDoService.deleteOrderService(orderInfo);
	}
	
}