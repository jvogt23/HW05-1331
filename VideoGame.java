/**
 * @author jvogt33
 * @version 1.00
 */
public class VideoGame extends Media {
    private int maxPlayers;
    private boolean needsConsole;

    /**
     * Constructor for new VideoGame with specified values.
     * @param genre Takes in Genre for this VideoGame
     * @param name String representing the title of the game
     * @param rating Int representing user ratings
     * @param rentalPrice double-precision float representing the rental price
     * @param maxPlayers Positive int representing how many players you can have
     * @param needsConsole Boolean whether or not a console is required
     */
    public VideoGame(Genre genre, String name, int rating, double rentalPrice, int maxPlayers, boolean needsConsole) {
        super(genre, name, rating, rentalPrice);
        this.maxPlayers = maxPlayers;
        this.needsConsole = needsConsole;
    }

    /**
     * Constructor for new VideoGame with default price 5.0, maxPlayers 2, needsConsole false.
     * @param genre Genre object representing the genre of this VideoGame
     * @param name String representing the title of this VideoGame
     * @param rating int representing the user ratings
     */
    public VideoGame(Genre genre, String name, int rating) {
        this(genre, name, rating, 5.0, 2, false);
    }

    /**
     * Overrides Media.toString(), String representation of a VideoGame.
     * @return String representing this VideoGame object
     */
    @Override
    public String toString() {
        String o = super.toString();
        o += String.format(", Players: %d, %s need console",
            maxPlayers,
            (needsConsole ? "does" : "does not"));
        return o;
    }

    /**
     * Overrides Media.equals(), represents equality of two VideoGames.
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
                && this.maxPlayers == ((VideoGame) o).maxPlayers
                && this.needsConsole == ((VideoGame) o).needsConsole;
        }
        return false;
    }

    /**
     * Getter for the needsConsole variable.
     * @return boolean whether or not this VideoGame needs a console
     */
    public boolean getNeedsConsole() {
        return needsConsole;
    }
}