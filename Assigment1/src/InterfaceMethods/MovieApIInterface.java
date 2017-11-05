package InterfaceMethods;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import models.Movie;
import models.User;

public interface MovieApIInterface {

	// Serializing objects
	public void write() throws Exception;
	// Loading objects
	public void load() throws Exception;
	//Adding a new User
	public User addUser (String firstName, String lastName, int age, String gender, String occupation, int zipCode);
	// Retriving a User
	public User getUser (Long id);
	// Deleting a User
	public void deleteUser (Long id);
	// List of all Users in loaded in system
	public List<User> UserList();
	// Adding a new Movie
	public Movie addMovie (String title, String url, int year);
	// Retriving a Movie
	public Movie getMovie (Long id);
	// Deleting a Movie
	public void deleteMovie (Long id);
	// List of all Movies in system
	public List<Movie> movieList();
	// Adding a new rating
	public void addRating (Long userID, Long movieID, int rating);
	// Removing a rating
	public void removeRating (Long userID, Long movieID);
	// Getting Users rated movies with average rating
	public void getTopMovies();
	// Getting Movies sorted by Title
	public Collection<Movie> sortedByTitle();
	// Getting Movies sorted By Year
	public Collection<Movie> sortedByYear();
	// Initial load of datas from .dat files
	public void initialLoad () throws IOException;
	
	
	
	
}
