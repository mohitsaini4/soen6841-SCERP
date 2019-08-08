package com.scerp.customerservicedepartment.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "query")
public class QueryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String name;
	private String query;
	private String solution;
	private boolean farwardQueryToSales;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public boolean isFarwardQueryToSales() {
		return farwardQueryToSales;
	}
	public void setFarwardQueryToSales(boolean farwardQueryToSales) {
		this.farwardQueryToSales = farwardQueryToSales;
	}
	@Override
	public String toString() {
		return "QueryEntity [id=" + id + ", username=" + username + ", name=" + name + ", query=" + query
				+ ", solution=" + solution + ", farwardQueryToSales=" + farwardQueryToSales + "]";
	}
	
	
}
