/**
 * @author jvogt33
 * @version 1.00
 */
public abstract class Media implements Comparable<Media> {
    protected Genre genre;
    protected String name;
    protected int rating;
    protected double rentalPrice;

    /**
     * Constructor for new Media object. Should only be run by subclasses.
     * @param genre Genre object; the Genre of this piece of media
     * @param name String representing this Media's title
     * @param rating int representing user ratings
     * @param rentalPrice double-precision float representing rental price
     */
    protected Media(Genre genre, String name, int rating, double rentalPrice) {
        this.genre = genre;
        this.name = name;
        this.rating = rating;
        this.rentalPrice = rentalPrice;
    }

    /**
     * Constructor for new Media with default rental price 7.0.
     * @param genre Genre object; the Genre of this Media
     * @param name String representing the title of this Media
     * @param rating int representing the user ratings for this Media
     */
    protected Media(Genre genre, String name, int rating) {
        this(genre, name, rating, 7.0);
    }

    /**
     * Overrides Object.toString(); string representation of this Media.
     * @return String representing this Media object
     */
    @Override
    public String toString() {
        return String.format("Genre: %s, Name: %s, Rating: %d, Rental Price: $%.2f",
            genre, name, rating, rentalPrice);
    }

    /**
     * Overrides Object.equals(); represents Media object equality.
     * @param o the other Object to compare to
     * @return boolean whether or not the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (this.getClass() == o.getClass()) {
            return this.genre == ((Media) o).genre
                && this.name.equals(((Media) o).name)
                && this.rating == ((Media) o).rating
                && this.rentalPrice == ((Media) o).rentalPrice;
        }
        return false;
    }

    /**
     * Overrides Comparable.compareTo(), represents natural ordering of Media.
     * @param o Media object to compare to
     * @return int representing natural order of Media
     */
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
    /**
     * Getter for name.
     * @return String representing title of this Media
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for rating.
     * @return int representing user ratings
     */
    public int getRating() {
        return rating;
    }

    /**
     * Getter for rentalPrice.
     * @return double-precision float representing the rental price
     */
    public double getRentalPrice() {
        return rentalPrice;
    }
}
