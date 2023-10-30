/**
 * @author jvogt33
 * @version 1.00
 */
public class Movie extends Media{
    private int runtime;

    public Movie(Genre genre, String name, int rating, double rentalPrice, int runtime) {
        super(genre, name, rating, rentalPrice);
        this.runtime = runtime;
    }

    public Movie(Genre genre, String name, int rating) {
        this(genre, name, rating, 5.0, 111);
    }

    @Override
    public String toString() {
        String o = super.toString();
        o += String.format(", Runtime: %d", runtime);
        return o;
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
            return super.equals((Media) o)
                && this.runtime == ((Movie) o).runtime;
        }
        return false;
    }
}
