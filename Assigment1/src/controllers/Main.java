package controllers;

import java.io.File;
import java.io.IOException;



import utils.Serializer;
import utils.XMLSerializer;
import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import models.Movie;
import models.User;


public class Main
{
  
	
	public movieAPI movAPI;

	  public Main() throws Exception
	  {
	    File datastore = new File("datastore1.xml");
	    Serializer serializer = new XMLSerializer(datastore);

	    movAPI = new movieAPI(serializer);
	    
	    //if (datastore.isFile())
	    //{
	    	//movAPI.load();
	    //}
	 }
	  
	  public static void main(String[] args) throws Exception
	  {
	    Main main = new Main();

	    Shell shell = ShellFactory.createConsoleShell("pm", "Movie Recommender API - ?help for instructions", main);
	    shell.commandLoop();
	    
	    main.movAPI.write();
	  }
	  
	  @Command(description="Initial Load from file")
	  public void initialLoad() throws Exception
	  {
		  movAPI.initialLoad();
		 
	  }
	  
	  
	  @Command(description="Add a new User")
	  public void addUser (@Param(name="first name") String firstName, @Param(name="last name") String lastName, 
	                          @Param(name="age")      int age,     @Param(name="gender")  String gender,
	  						 @Param(name="occupation")      String occupation,     @Param(name="zipCode")  int zipCode)
	  {
	    movAPI.addUser(firstName, lastName, age, gender, occupation, zipCode);
	    
	  }
	  
	  @Command(description="Get a User")
	  public void getUser (@Param(name="User ID") Long id)
	  {
	    System.out.println("Name " + movAPI.getUser(id).firstName + movAPI.getUser(id).lastName);
	    System.out.println("Age: " + movAPI.getUser(id).age);
	    System.out.println("Occupation: " + movAPI.getUser(id).occupation);
	    System.out.println("ZipCode: " + movAPI.getUser(id).zipCode);
	    System.out.println("Gender: " + movAPI.getUser(id).gender);
	  }
	  
	  
	  
	  @Command(description="Delete User")
	  public void deleteUser (@Param(name="User ID") Long id)
	  {
		 movAPI.deleteUser(id);
		  
	  }
	  
	  
	  
	  @Command(description="List of Users")
	  public void userList ()
	  {
		  System.out.println("Name           Age         Occupation       ZipCode      Gender");
		  for(User user : movAPI.UserList()) {
			  System.out.println(user.firstName + " " + user.lastName + "   " + user.age + "        " + user.occupation + "       " + user.zipCode + "     " + user.gender);
		  }
		  
	  }
	  
	  
	  @Command(description="Add a new Movie")
	  public void addMovie (@Param(name="Title") String title, @Param(name="Year")  int year,
			  				@Param(name="URL")  String url)
	  						
	  {
	    movAPI.addMovie(title, url, year);
	    
	  }
	  
	  @Command(description="Get a Movie")
	  public void getMovie (@Param(name="Movie ID") Long id)
	  {
	    System.out.println("Title " + movAPI.getMovie(id).title);
	    System.out.println("Year : " + movAPI.getMovie(id).year);
	    System.out.println("URL : " + movAPI.getMovie(id).url);
	    
	  }
	  
	  
	  
	  @Command(description="Delete User")
	  public void deleteMovie (@Param(name="Movie ID") Long id)
	  {
		 movAPI.deleteMovie(id);
		  
	  }
	  
	  
	  
	  @Command(description="List of Users")
	  public void movieList ()
	  {
		  System.out.println("Title           Year        URL ");
		  for(Movie movie : movAPI.movieList()) {
			  System.out.println(movie.title + "   " + movie.year + "        " + movie.url);
		  }
		  
	  }
	  
	  
	  @Command(description="Movies by title")
	  public void sortedByTitle ()
	  {
		  System.out.println("Title           Year        URL ");
		  for(Movie movie : movAPI.sortedByTitle()) {
			  System.out.println(movie.title + "   " + movie.year + "        " + movie.url);
		  }
		  
	  }
	  
	  
	  @Command(description="Sort by Year")
	  public void sortedByYear ()
	  {
		  System.out.println("Title           Year        URL ");
		  for(Movie movie : movAPI.sortedByYear()) {
			  System.out.println(movie.title + "   " + movie.year + "        " + movie.url);
		  }
		  
	  }
	  
	  
	  @Command(description="Add a new Rating")
	  public void addRating (@Param(name="user ID") Long userID, @Param(name="movie ID")  Long movieID,
			  				@Param(name="rating")  int rating)
	  						
	  {
	    movAPI.addRating(userID, movieID, rating);
	    
	  }
	  
	  @Command(description="Delete a movie Rating")
	  public void deleteRating (@Param(name="userID") Long userID, @Param(name="movieID")  Long movieID)
	  						
	  {
	    movAPI.removeRating(userID, movieID);
	    
	  }
	  
	  @Command (description="Get average rating of user on Movies")
		public void getUsersTop(@Param(name="user ID")Long userID) {
			movAPI.getTopMovies();
		}
	  
  
  
  
}
 
  
  

  

  
