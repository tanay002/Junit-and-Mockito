package com.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

class Employee
{
	private String name;

	Employee()
	{

	}

	Employee(String name)
	{
		this.name=name;
	}
}
public class ObjectHelperAssertNullCheck {

	@Test
	public void checkObjectData() {
		Employee e=null;
		Employee e1=new Employee();
		assertNull(e);  // valid
		assertNull(e1);  // InValid
		
		assertNotNull(e1);  // Valid
		assertNotNull(e);  //Invalid
	}

}
