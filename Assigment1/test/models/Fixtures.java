package models;

public class Fixtures
{
  public static User[] users =
  {
    new User ("Ondrej", "Svojse", 20,  "Student", "M", 2322323),
    new User ("Tomas", "Stastny", 20,  "Student", "M", 23223),
    new User ("Honza", "Dockal", 12,  "Student", "M", 2322),
    new User ("Barbora", "Mikova", 12,  "Student", "M", 232)
  };

  public static Movie[] movies =
  {
    new Movie ("The Prestige", "https://csfd.cz/the-prestige/", 1999),
    new Movie ("Cloud Atlas", "https://csfd.cz/cloud-atlas/", 1999),
    new Movie ("Matrix", "https://csfd.cz/matrix/", 1999),
    new Movie ("The Inception", "https://csfd.cz/the-inception/", 2003),
  };

  public static Rating[] ratings =
  {
    new Rating(0l, 0l, 8),
    new Rating(2l, 2l, 6),
    new Rating(3l, 3l, 8),
    new Rating(4l, 4l, 9)
  };
}


