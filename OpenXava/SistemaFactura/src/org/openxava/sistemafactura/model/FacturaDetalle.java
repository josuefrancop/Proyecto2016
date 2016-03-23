package org.openxava.sistemafactura.model;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.sistemafactura.calculators.*;

@Embeddable
public class FacturaDetalle {
		
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	private Producto product;

	@Required 
	@DefaultValueCalculator(  
		value=UnitPriceCalculator.class,
		properties=@PropertyValue(
			name="productNumber",
			from="product.number")
	)
	private BigDecimal unitPrice;
		
	@Required
	private int quantity;
	

	@Depends("unitPrice, quantity") 
	public BigDecimal getAmount() {
		return new BigDecimal(getQuantity()).multiply(getUnitPrice()); 
	}

	public Producto getProduct() {
		return product;
	}

	public void setProduct(Producto product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice == null?new BigDecimal("0.00"):unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}
