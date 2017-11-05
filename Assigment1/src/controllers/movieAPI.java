package controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Scanner;
import models.Movie;
import models.Rating;
import models.User;
import utils.Serializer;


public class movieAPI implements InterfaceMethods.MovieApIInterface
{
	
  private Serializer serializer;
  private Map<Long, User> userMap = new HashMap<>();
  private Map<Long, Movie>   movieMap = new HashMap<>();
  private Map<Long, Integer> ratingsMap = new HashMap<>();
  private List<Rating> ratings = new ArrayList<Rating>();
  


  public movieAPI()
  {}

  
  public movieAPI(Serializer serializer)
  {
    this.serializer = serializer;
  }
  
  @SuppressWarnings("unchecked")
  public void load() throws Exception
  {

    serializer.read();
    
    userMap = (Map<Long, User>) serializer.pop();
    movieMap = (Map<Long, Movie>)   serializer.pop();
    ratings = (List<Rating>) serializer.pop();
    
  }
  
  public void write() throws Exception
  {
    serializer.push(userMap);
    serializer.push(movieMap);
    serializer.push(ratings);
    serializer.write(); 
  }
  
  
  
  
  // Functions related to User
  
  public User addUser (String firstName, String lastName, int age, String gender, String occupation, int zipCode) 
  {
	
    User user = new User (firstName, lastName, age, gender, occupation, zipCode);
    userMap.put(user.id, user);
    return user;
    
  }

  public User getUser (Long id) {
	  
	User user = userMap.get(id); 
	return user;
	
	
  }
  
public void deleteUser (Long id) {
	  
	  if (userMap.containsKey(id)) {
		  userMap.remove(id);
	  }
  }
  
  
  public List<User> UserList() {
	  
	List<User> userList = new ArrayList<User>(userMap.values());
	return userList;
	  
  }
  
  // Functions related to Movie
  
  public Movie addMovie (String title, String url, int year) 
  {
	  
    Movie movie = new Movie (title, url, year);
    movieMap.put(movie.id, movie);
    return movie;
    
  }

  public Movie getMovie (Long id) {
	  
	Movie movie = movieMap.get(id); 
	return movie;

	  
  }
  
  public void deleteMovie (Long id) {
	  
	  if (movieMap.containsKey(id)) {
		  movieMap.remove(id);
	  }
  }
  
  
  public List<Movie> movieList() {
	  
	List<Movie> movieList = new ArrayList<Movie>(movieMap.values());
	return movieList;
	  
  }
  
  
  
  // Related to Rating
  
  
  
  
  // Add Rating
  public void addRating (Long userID, Long movieID, int rating)
  {
	  Rating newRating = new Rating(userID, movieID, rating);
	  ratings.add(newRating);
	  
  }

  
  // Remove Rating
  
  public void removeRating (Long userID, Long movieID)
  {
	  for (Rating rating : ratings)
	  {
		 if (rating.userID == userID && rating.movieID == movieID) {
			 ratings.remove(rating);
			 System.out.println("Success!");
		 }
		 
	  }
	  
  }
  
  
  // Get top movies with average rating of users
  
  public void getTopMovies() 
	{
	  Map<Long, Integer> occurencies = new HashMap<Long, Integer>();
	  Map<Long, Double> ScoreBoard = new HashMap<Long, Double>();
	  
	  for (Rating rat : ratings) {
		  
		  if (occurencies.containsKey(rat.movieID)) {
			  occurencies.put(rat.movieID, occurencies.get(rat.movieID) + 1);
			  } else {
				  occurencies.put(rat.movieID, 1); 
			  }
		  
		  if (ratingsMap.containsKey(rat.movieID)) {
			  int newValue = ratingsMap.get(rat.movieID) + rat.rating;
			  ratingsMap.put(rat.movieID, newValue);
			  
		  } else {
			  
			  ratingsMap.put(rat.movieID, rat.rating);
			  
		  }  
	  }		 
	  double average = 0;
	  for (Long key : ratingsMap.keySet()) {
		    int value1 = ratingsMap.get(key);
		    int value2 = occurencies.get(key);
		    average = value1 / value2;
		    ScoreBoard.put(key, average);
		}
	  
	  for (Map.Entry<Long, Double> entry : ScoreBoard.entrySet())
	  {
	      System.out.println(movieMap.get(entry.getKey()) + " ---- Rating:  " + entry.getValue()) ;
	  }
	  
  
	}
  

  // Movies Alphabetically sorted
  
  
public Collection<Movie> sortedByTitle() {
	  
	  List<Movie> sortedByTitle = new ArrayList<Movie>(movieMap.values());
	  Collections.sort(sortedByTitle, new AlphabeticalComparator());
	  
	  return sortedByTitle;
  }
  
  
  // Movies By Year sorted
  
  public Collection<Movie> sortedByYear() {
	  
	  List<Movie> sortedByYear = new ArrayList<Movie>(movieMap.values());
	  Collections.sort(sortedByYear, new YearComparator());
	  
	  return sortedByYear;
  }
  
  class YearComparator implements Comparator<Movie> {
	    @Override
	    public int compare(Movie a, Movie b) {
	        return a.year < b.year ? -1 : a.year == b.year ? 0 : 1;
	    }
	}
  
  class AlphabeticalComparator implements Comparator<Movie> {
	    @Override
	    public int compare(Movie a, Movie b) {
	        return a.title.compareToIgnoreCase(b.title);
	    }
	}
  
  
  
  // Initial Load of datas from Files
  public void initialLoad () throws IOException
  {
	  Long userID = 0l;
	  Long movieID = 0l;
	  
	  
	  // Loading movies datas
	  String delims = "[|]";
      Scanner scanner = new Scanner(new File("./data/items5.dat"));
      while (scanner.hasNextLine()) {
          String movieDetails = scanner.nextLine();
          // parse user details string
          String[] movieTokens = movieDetails.split(delims);
          
          // Extracting year from brackets ----- (1995)
          int year;
        	  year = Integer.parseInt(movieTokens[1].substring(movieTokens[1].indexOf("(")+1,movieTokens[1].indexOf(")")));
              
     
          Movie movie = new Movie(movieTokens[1], movieTokens[3], year);
          movieMap.put(movieID, movie);
          movieID++;
         
          
          }
      scanner.close();
      // Loading Ratings data
      Scanner scanner1 = new Scanner(new File("./data/ratings5.dat"));
      while (scanner1.hasNextLine()) {
          String ratingDetails = scanner1.nextLine();
          // Parse user details string
          String[] strings = ratingDetails.split(delims);
          // Convert String input to Integers
          long usID = Long.parseLong(strings[0]);
          long movID = Long.parseLong(strings[1]);
          int scoreRating = Integer.parseInt(strings[2]);
          
          Rating rating = new Rating(usID, movID, scoreRating);
          ratings.add(rating);
          
      }
      scanner1.close();
      // loading user datas
      Scanner scanner2 = new Scanner(new File("./data/users5.dat"));
      while (scanner2.hasNextLine()) {
          String userDetails = scanner2.nextLine();
          // parse user details string
          String[] userTokens = userDetails.split(delims);
          
          User user = new User(userTokens[1], userTokens[2], Integer.parseInt(userTokens[3]),userTokens[4], userTokens[5], Integer.parseInt(userTokens[6]));
          userMap.put(userID, user);
          userID++;
          
      }
      scanner2.close();
      
	  
  }
  
  

  }

 

