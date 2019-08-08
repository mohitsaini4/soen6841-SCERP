package com.scerp.salesdepartment.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.scerp.salesdepartment.repository.ToDoRepository;

@Service
public class ToDoService {
	@Autowired
	private ToDoRepository todoRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SalesQueryRepository salesQueryRepository;
	
	@Autowired
	private ShipmentRepository shipmentRepository;
	

	public Iterable<ToDoEvent> getAllnonDoneEvents() {
		return todoRepository.findAll();
	}
	
	
	public String getProductService() {
		return productRepository.findAll().toString();
//		return "hello prodcut, we just did inter project communication!";
	}
	
	public String loginService(EmployeeData employeedata) {
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("name", employeedata.getUsername());
		uriVariables.put("pass", employeedata.getPassword());
		ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/admin/checkSalesAuthorization/{name}/{pass}",String.class,uriVariables);
		return responseEntity.getBody();
}
	
	
	public String buyProductsService(OrderEntity orderInfo) {
		ProductEntity product = productRepository.findByProductId(orderInfo.getProductId());
		int oldQuantity = Integer.parseInt(product.getQuantity());
		int cusQuantity = Integer.parseInt(orderInfo.getQuantity());
		int newQuantity = oldQuantity - cusQuantity;
		
		if(cusQuantity>oldQuantity)
		return "product out of stock";
		else {		
		productRepository.resetInventory(""+newQuantity,product.getProductId());
		System.out.println(product.toString());
		orderInfo.setProductId(product.getProductId());
		orderInfo.setProductName(product.getProductName());
		if(orderInfo.isPaymentInfo()) {
			orderInfo.setProcessingStatus("shipped");
		}
		int totalInvoiceSum  = 0;
		totalInvoiceSum = Integer.parseInt(orderInfo.getQuantity())*Integer.parseInt(product.getPrice());
		orderInfo.setTotalInvoiceSum(""+totalInvoiceSum);
		
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("username", orderInfo.getCustomerUsername());
		ResponseEntity<CustomerData> responseEntity = new RestTemplate().getForEntity("http://localhost:8082/ec/findByUserName/{username}",CustomerData.class,uriVariables);
		CustomerData customerData = responseEntity.getBody();
		
		orderInfo.setCustomerName(customerData.getName());
		orderInfo.setCustomerUsername(customerData.getUsername());
		orderInfo.setDeliveryAddress(customerData.getAddress());
		orderRepository.save(orderInfo);
		return "Product succesfully bought";
		}
	}
	
	
	
	public String addProductService(ProductEntity productInfo){
		productRepository.save(productInfo);
		return "Product Added Succesfully";
	}
	
	
	public String deleteProductService(ProductEntity productInfo) {
		productRepository.deleteByproductId(productInfo.getProductId());
		return "Product Deleted Successfully";
	}
	
	
	public String serachProductService(ProductEntity productInfo) {
		Optional<ProductEntity> product = productRepository.findByProductName(productInfo.getProductName());
		if(product.isPresent())
		return product.toString();
		else return "Product Not found";
	}
	
	
	
	public String modifyProductDetailsService(ProductEntity productInfo) {
		productRepository.setNewProductDetailsForProduct(productInfo.getProductName(), productInfo.getPrice(), productInfo.getProductId() );
		return "Product Details Modified";
	}
	
	
	public String modifyProductInventoryService(ProductEntity productInfo) {
		productRepository.setNewQuantityForProduct(productInfo.getQuantity(), productInfo.getProductId());
		return "Product Inventory Modified";
	}
	
	
	public String createShipmentService(OrderData order){
		OrderEntity orderEntity = orderRepository.findById(Long.parseLong(order.getId()));
		if(orderEntity.isPaymentInfo()) {
		ShipmentEntity shipmentInfo = new ShipmentEntity();
		shipmentInfo.setProductId(orderEntity.getProductId());
		shipmentInfo.setAddress(orderEntity.getDeliveryAddress());
		shipmentInfo.setDeliveryStatus("Shipped");
		shipmentInfo.setOrderNumber(""+orderEntity.getId());
		shipmentInfo.setCourierCompany(order.getCourierCompany());
		shipmentRepository.save(shipmentInfo);
		return "Shipment Created Succesfully for orderId = " + shipmentInfo.getOrderNumber() ;
		}
		else {
			return "Shipment cannot be created";
		}
	}
	
	///very Important donot modify
	public String checkSalesAuthorizationService(String queryId,String query) {
		SalesQueryEntity salesQuery = new SalesQueryEntity();
		salesQuery.setQueryId(queryId);
		salesQuery.setQuery(query);
		salesQuery.setStatus(false);
		salesQueryRepository.save(salesQuery);
		return "Sales Querry Added";
			
	}
	
	public String viewSalesQueryService() {
		return salesQueryRepository.findAll().toString();
	}
	
	public String resolveSalesQueryService(SalesQueryEntity queryInfo){
		SalesQueryEntity query = salesQueryRepository.findByQueryId(queryInfo.getQueryId());
		
		if(query.getQueryId().equals(queryInfo.getQueryId())) {
			salesQueryRepository.setNewQueryDetailsForQuery(queryInfo.getSolution(),true, query.getQueryId());
			return "Query Resolved Successfully";
		}
		else {
			return "Invalid Query Id";
		}
	}
	
	public String viewAllOrdersService() {
		return orderRepository.findAll().toString();
	}
	
	
	public String deleteOrderService(OrderEntity orderInfo) {
		 orderRepository.deleteByCustomerUsername(orderInfo.getCustomerUsername());
		 return "order Successfully canceled";
	}


	public String viewAllShipmentsService() {
		return shipmentRepository.findAll().toString();
	}

	
}