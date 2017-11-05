package models;

import static org.junit.Assert.*;

import org.junit.Test;

import static models.Fixtures.users;


	public class UserTests
	{
	  User ondrej = new User ("Ondrej", "Svojse", 20, "M", "Student", 32323);

	  @Test
	  public void testCreate()
	  {
	    assertEquals ("Ondrej", ondrej.firstName);
	    assertEquals ("Svojse", ondrej.lastName);
	    assertEquals (20, ondrej.age);   
	    assertEquals ("Student", ondrej.occupation);
	    assertEquals ("M", ondrej.gender);
	    assertEquals (32323, ondrej.zipCode); 
	  }
	  
	  @Test
	  public void testEquals()
	  {
	    User pavel = new User ("Pavel", "Stastny", 30, "Programmer",  "M", 3434); 
	    User jiri   = new User ("Jiri", "Kunert", 20, "Student",  "M", 122132); 

	    assertEquals(pavel, pavel);
	    assertNotEquals(pavel, jiri);
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	}
	