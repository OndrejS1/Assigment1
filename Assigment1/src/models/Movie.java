package models;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;

public class Movie {

	static Long   counter = 0l;
	public String title;
	public String url;
	public int year;
	public Long id;
	public List<Rating> MovieRatings = new ArrayList<>();
	
	
	
	public Movie() {
		
	}
	
	

	  @Override  
	  public int hashCode()  
	  {  
	     return Objects.hashCode(this.id, this.title, this.url, this.year);  
	  } 
	
	public Movie (String title, String url, int year) {
		
		this.title = title;
		this.url = url;
		this.year = year;
		this.id = counter++;
		
	}
		  @Override
		  public String toString()
		  {
		    return toStringHelper(this).addValue(id)
		                               .addValue(title)
		                               .addValue(url)
		                               .toString();
		  }
		  
		
		  @Override
		  public boolean equals(final Object obj)
		  {
		    if (obj instanceof Movie)
		    {
		      final Movie other = (Movie) obj;
		      return Objects.equal(title, other.title) 
		          && Objects.equal(url, other.url)
		          && Objects.equal(year, other.year);
		     
		    }
		    else
		    {
		      return false;
		    }
		  }

		public Long getMovieID() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		
		
	}


