/**
 * @author jvogt33
 * @version 1.00
 */
public class VideoGame extends Media {
    private int maxPlayers;
    private boolean needsConsole;

    public VideoGame(Genre genre, String name, int rating, double rentalPrice, int maxPlayers, boolean needsConsole) {
        super(genre, name, rating, rentalPrice);
        this.maxPlayers = maxPlayers;
        this.needsConsole = needsConsole;
    }

    public VideoGame(Genre genre, String name, int rating) {
        this(genre, name, rating, 5.0, 2, false);
    }

    @Override
    public String toString() {
        String o = super.toString();
        o += String.format(", Players: %d, %s need console",
            maxPlayers,
            (needsConsole ? "does" : "does not"));
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
                && this.maxPlayers == ((VideoGame) o).maxPlayers
                && this.needsConsole == ((VideoGame)o).needsConsole;
        }
        return false;
    }

    public boolean getNeedsConsole() {
        return needsConsole;
    }
}