import java.util.ArrayList;
/**
 * @author jvogt33
 * @version 1.00
 */
public class Blockbuster {
    private ArrayList<Media> inventory;

    /**
     * No-Arg constructor for new Blockbuster.
     * Creates empty inventory
     */
    public Blockbuster() {
        inventory = new ArrayList<Media>();
    }

    /**
     * Adds a Media object to the inventory array.
     * @param m Media object to add to inventory
     */
    public void addMedia(Media m) {
        if (m != null) {
            inventory.add(m);
        }
    }

    /**
     * Performs a linear search for a Media object and removes it from inventory.
     * @param m Media object to attempt to remove
     * @return Media object that was removed
     */
    public Media removeMedia(Media m) {
        if (m == null) {
            return null;
        }

        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).equals(m)) {
                return inventory.remove(i);
            }
        }
        return null;
    }

    /**
     * Sorts media using bubble sort algorithm.
     */
    public void sortMedia() {
        for (int i = 1; i < inventory.size(); i++) {
            for (int j = 0; j < inventory.size() - i; j++) {
                if (inventory.get(j).compareTo(inventory.get(j + 1)) > 0) {
                    Media x = inventory.get(j);
                    inventory.set(j, inventory.get(j + 1));
                    inventory.set(j + 1, x);
                }
            }
        }
    }

    //implements a binary search
    //Time complexity: Log(n) base2
    /**
     * Finds specified Media object using binary search, returning null if not found.
     * @param m Media object to attempt to find
     * @return Media object found
     */
    public Media findMedia(Media m) {
        if (m == null) {
            return null;
        }
        int low = 0;
        int high = inventory.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (inventory.get(mid).compareTo(m) == 0) {
                return inventory.get(mid);
            }
            if (inventory.get(mid).compareTo(m) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    /**
     * Finds Movie with highest ratings and first lexicographical ordering.
     * @return Movie object representing most popular Movie
     */
    public Movie getMostPopularMovie() {
        int max = -1;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getClass() == Movie.class) {
                max = i;
                break;
            }
        }
        if (max == -1) {
            return null;
        }

        for (int i = max + 1; i < inventory.size(); i++) {
            if (inventory.get(i).getClass() == Movie.class) {
                if (inventory.get(i).getRating() > inventory.get(max).getRating()) {
                    max = i;
                } else if (inventory.get(i).getRating() == inventory.get(max).getRating()
                    && inventory.get(i).getName().compareTo(inventory.get(max).getName()) < 0) {
                    max = i;
                }
            }
        }
        return (Movie) inventory.get(max);
    }
}
