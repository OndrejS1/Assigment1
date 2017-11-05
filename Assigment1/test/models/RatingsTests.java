package models;


import static org.junit.Assert.*;

import org.junit.Test;

public class RatingsTests {

	Rating r1 = new Rating(1L, 1L, 8);
	Rating r2 = new Rating(1L, 2L, 8);

	  @Test
	  public void testMovie()
	  {
	    assertEquals (Long.valueOf(1L), r1.userID);
	    assertEquals (Long.valueOf(1L), r1.movieID);
	    assertEquals (8, r1.rating);    
	  }
	  
	  @Test
	  public void testEquals()
	  {
	   

	    assertEquals(r1, r1);
	    assertNotEquals(r1, r2);
	  }
	  
	  

}
