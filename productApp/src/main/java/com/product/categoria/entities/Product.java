package com.product.categoria.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	 
	@Column(name="description")
	private String description;	
	
	@OneToOne
	@JoinColumn(name="category_id", referencedColumnName="id", unique=true)	
	private Categories categories;
	
	@OneToOne
	@JoinColumn(name="marca_id", referencedColumnName="id", unique=true)
	private Marca marca;
	
	@OneToOne
	@JoinColumn(name="genero_id", referencedColumnName="id", unique=true)
	private Genero genero;
	
	@OneToOne
	@JoinColumn(name="currency_id", referencedColumnName="id", unique=true)
	private Currency currency;

	@OneToOne
	@JoinColumn(name="color_id", referencedColumnName="id", unique=true)
	private Color color;
	
	@OneToOne
	@JoinColumn(name="model_id", referencedColumnName="id", unique=true)
	private Models models;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	
	public Categories getCategories() {
		return categories;
	}

	

	public Models getModels() {
		return models;
	}

	public void setModels(Models models) {
		this.models = models;
	}

	

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

    

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
