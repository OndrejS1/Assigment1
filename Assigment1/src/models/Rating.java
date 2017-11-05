package models;

import static com.google.common.base.MoreObjects.toStringHelper;

import com.google.common.base.Objects;

public class Rating {

	public int rating;
	public Long userID;
	public Long movieID;
	
	
	
	public Rating() {}
	
	
	
	public Rating(Long userID, Long movieID, int rating) {
		
		
		this.rating = rating;
		this.userID = userID;
		this.movieID = movieID;
		
	}
	
	  @Override
	  public String toString()
	  {
	    return toStringHelper(this).addValue(userID)
	                               .addValue(movieID)
	                               .addValue(rating)
	                               .toString();
	  }
	  
	  @Override  
	  public int hashCode()  
	  {  
	     return Objects.hashCode(this.userID, this.movieID, this.rating);  
	  } 
	  
	  @Override
	  public boolean equals(final Object obj)
	  {
	    if (obj instanceof Rating)
	    {
	      final Rating other = (Rating) obj;
	      return Objects.equal(userID, other.userID) 
	          && Objects.equal(movieID, other.movieID)
	      && Objects.equal(rating, other.rating);
	      
	    }
	    else
	    {
	      return false;
	    }
	  }
	  
	  public int getRating() {
			return rating;
		}

	public Long getMovieID() {
		
		return movieID;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setMovieID(Long movieID) {
		this.movieID = movieID;
	}

	

	
	
	
	
}
