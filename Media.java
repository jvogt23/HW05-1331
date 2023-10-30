/**
 * @author jvogt33
 * @version 1.00
 */
public abstract class Media implements Comparable<Media> {
    protected Genre genre;
    protected String name;
    protected int rating;
    protected double rentalPrice;
    public Media(Genre genre, String name, int rating, double rentalPrice) {
        this.genre = genre;
        this.name = name;
        this.rating = rating;
        this.rentalPrice = rentalPrice;
    }

    public Media(Genre genre, String name, int rating) {
        this(genre, name, rating, 7.0);
    }

    @Override
    public String toString() {
        return String.format("Genre: %s, Name: %s, Rating: %d, Rental Price: %.2f", 
            genre, name, rating, rentalPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null) {
            return false;
        }

        if (this.getClass() == o.getClass()) {
            return this.genre == ((Media)o).genre
                && this.name.equals(((Media)o).name)
                && this.rating == ((Media)o).rating
                && this.rentalPrice == ((Media)o).rentalPrice;
        }
        return false;
    }

    @Override
    public int compareTo(Media o) {
        if (this.genre.compareTo(o.genre) != 0) {
            return this.genre.compareTo(o.genre);
        }
        if (this.name.compareTo(o.name) != 0) {
            return this.name.compareTo(o.name);
        }
        return Integer.compare(this.rating, o.rating);
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }
}
