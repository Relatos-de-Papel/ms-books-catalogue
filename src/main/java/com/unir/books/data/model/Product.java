package com.unir.books.data.model;

import com.unir.books.controller.model.ProductDto;
import com.unir.books.data.utils.Consts;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = Consts.NAME, unique = true)
	private String name;
	
	@Column(name = Consts.COUNTRY)
	private String country;
	
	@Column(name = Consts.DESCRIPTION)
	private String description;
	
	@Column(name = Consts.VISIBLE)
	private Boolean visible;

	public void update(ProductDto productDto) {
		this.name = productDto.getName();
		this.country = productDto.getCountry();
		this.description = productDto.getDescription();
		this.visible = productDto.getVisible();
	}

}
