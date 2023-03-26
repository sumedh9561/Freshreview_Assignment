package com.freshview.model;

import java.util.ArrayList;
import java.util.List;

import com.freshview.DTO.ItemsDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@OneToMany
	private List<Order> orders;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "order_Items", joinColumns = @JoinColumn(name ="customer_id", referencedColumnName = "itemId"))
	private List<Order> order = new ArrayList<>();

	@Column(name = "number_of_orders")
	private int numberOfOrders;

}
