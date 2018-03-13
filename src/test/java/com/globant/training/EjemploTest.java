package com.globant.training;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EjemploTest {
	@Test(dataProvider = "Authentication")
	public void clase (String sUsername, String sPassword, String nNombre){
		String user = "Fulano";
		String pass = "hola";
		String nombre = "Bernardo";
		Assert.assertEquals(sUsername, user, "Usuario incorrecto");
		Assert.assertEquals(sPassword, pass, "Contraseña incorrecta");
		Assert.assertEquals(nNombre, nombre, "Nombre incorrecto");
		
		
		
	}
	@Test
	public void otraClase (){
		System.out.println("test otra clase");
	}
	@BeforeMethod
	public void hola (){
		System.out.println("estoy en Before Test");
	}
	@AfterMethod
	public void mundo (){
		System.out.println("estoy en After Test");
	}
	@BeforeClass
	public void globant (){
		System.out.println("estoy en Before Class");
	}
	@AfterClass
	public void nose (){
		System.out.println("estoy en After Class");
	}
	@DataProvider(name = "Authentication")
	public Object [][]credentials(){
		return new Object [][] {{"testuser-1", "Test@123","Juan"},{"testuser-1", "Test@123","Pedro"},{"Fulano", "hola","Bernardo"}};
	}
}
