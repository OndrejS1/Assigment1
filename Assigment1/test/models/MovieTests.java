package models;


import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTests {

	Movie movie = new Movie ("The Prestige",  "https://csfd.cz/the-prestige/", 2000);
	Movie movie2 = new Movie ("The Inception", "https://csfd.cz/the-inception/", 2003);

	  @Test
	  public void testMovie()
	  {
	    assertEquals ("The Prestige", movie.title);
	    assertEquals ("fridge", movie.url);
	    assertEquals (2000,   movie.year);    
	  }
	  
	  @Test
	  public void testEquals()
	  {
	   

	    assertEquals(movie, movie);
	    assertNotEquals(movie, movie2);
	  }
	  
	  

}
