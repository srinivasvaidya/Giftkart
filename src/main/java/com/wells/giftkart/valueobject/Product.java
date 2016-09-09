package com.wells.giftkart.valueobject;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@XmlRootElement
@Entity(name="t_gk_products")
public class Product extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name = "increment", strategy = "increment")
	@GeneratedValue(generator = "increment")
	//@GeneratedValue(strategy=GenerationType.increment, generator="productidseq")
	@Column(name="productId", unique=true, nullable=false)
	private long productId;
	
	@Column(name="prodname", unique=true, nullable=false)
	private String prodname;
	
	@Column(name="price", unique=true, nullable=false)
	private double price;
	
	@Column(name="colour", unique=true, nullable=false)
	private String colour;
	
	@ManyToOne
	@JoinColumn(name="categoryid", referencedColumnName="categoryid")
	private ProductCategory category;
	
	public String getProdname() {
		return prodname;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
}
