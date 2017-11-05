package models;

import static com.google.common.base.MoreObjects.toStringHelper;


import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;



public class User {

	static Long   counter = 0l;
	
	public Long id;
	public String firstName;
	public String lastName;
	public String gender;
	public String occupation;
	public int age;
	public int zipCode;
	public Map<Long,Rating> ratingMap;
	
	
	public User() {}
	


	public User (String firstName, String lastName, int age, String gender, String occupation, int zipCode)
	  {
	    this.id = counter++;
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.gender = gender;
	    this.occupation = occupation;
	    this.age = age;
	    this.zipCode = zipCode;
	    this.ratingMap = new HashMap<Long,Rating>();
	  }

	
	  @Override
	  public String toString()
	  {
	    return toStringHelper(this).addValue(id)
	                               .addValue(firstName)
	                               .addValue(lastName)
	                               .addValue(age)
	                               .addValue(gender)
	                               .addValue(occupation) 
	                               .addValue(zipCode) 
	                               .addValue(ratingMap)
	                               .toString();
	  }
	  
	  @Override  
	  public int hashCode()  
	  {  
	     return Objects.hashCode(this.id, this.firstName, this.lastName, this.age, this.gender, this.occupation, this.zipCode, this.ratingMap);  
	  } 
	  
	  @Override
	  public boolean equals(final Object obj)
	  {
	    if (obj instanceof User)
	    {
	      final User other = (User) obj;
	      return Objects.equal(firstName, other.firstName) 
	          && Objects.equal(lastName, other.lastName)
	      && Objects.equal(age, other.age)
	      && Objects.equal(gender, other.gender)
	      && Objects.equal(occupation, other.occupation)
	      && Objects.equal(zipCode, other.zipCode)
	      && Objects.equal(ratingMap, other.ratingMap);
	    }
	    else
	    {
	      return false;
	    }
	  }



	public void addRating(Movie movie, Rating rating) {
		ratingMap.put(id, rating);
	}


	public Map<Long, Rating> getRatingMap() {
		return ratingMap;
	}


	public Long getUserID() {
		return id;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
