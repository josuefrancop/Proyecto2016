package org.openxava.sistemafactura.model;

import javax.persistence.*;

@Entity
public class Cliente {
	
	@Id
	private int number;
	
	@Column(length=40) 
	private String name;
	

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
