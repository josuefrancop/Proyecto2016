package org.openxava.sistemafactura.calculators;

import static org.openxava.jpa.XPersistence.getManager;

import org.openxava.calculators.*;
import org.openxava.sistemafactura.model.*;

public class UnitPriceCalculator implements ICalculator {
	
	private int productNumber;  

	public Object calculate() throws Exception {
		Producto	product = getManager().find(Producto.class, productNumber);  
		return product.getUnitPrice();  	
	}

	public void setProductNumber(int productNumber) { 
		this.productNumber = productNumber;
	}

	public int getProductNumber() {
		return productNumber;
	}

}
