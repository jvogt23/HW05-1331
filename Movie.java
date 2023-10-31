/**
 * @author jvogt33
 * @version 1.00
 */
public class Movie extends Media {
    private int runtime;

    /**
     * Constructor for new Movie object with specified values.
     * @param genre Genre object; the genre of this Movie
     * @param name String representing this Movie's title
     * @param rating int representing user ratings
     * @param rentalPrice double-precision float representing price to rent
     * @param runtime int representing time in minutes that the Movie runs
     */
    public Movie(Genre genre, String name, int rating, double rentalPrice, int runtime) {
        super(genre, name, rating, rentalPrice);
        this.runtime = runtime;
    }

    /**
     * Constructor for new Movie with default rentalPrice 5.0 and runtime 111.
     * @param genre Genre object; the genre of this Movie
     * @param name String representing the title of this Movie
     * @param rating int representing user ratings
     */
    public Movie(Genre genre, String name, int rating) {
        this(genre, name, rating, 5.0, 111);
    }

    /**
     * Overrides Media.toString(); string representation of this Movie.
     * @return string representing this Movie object
     */
    @Override
    public String toString() {
        String o = super.toString();
        o += String.format(", Runtime: %d", runtime);
        return o;
    }

    /**
     * Overrides Media.equals(); represents equality between two Movies.
     * @param o Object to compare to
     * @return boolean representing equality
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
            return super.equals((Media) o)
                && this.runtime == ((Movie) o).runtime;
        }
        return false;
    }
}
