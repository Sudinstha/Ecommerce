package com.bway.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product_tbl")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	@Column( columnDefinition = "text")
	private String description;
	@OneToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	@OneToOne
	@JoinColumn(name = "brandId")
	private Brand brand;
	private String image;
	private Double price;
}
