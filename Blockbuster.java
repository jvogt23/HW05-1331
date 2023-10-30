import java.util.ArrayList;
/**
 * @author jvogt33
 * @version 1.00
 */
public class Blockbuster {
    private ArrayList<Media> inventory;

    public Blockbuster() {
        inventory = new ArrayList<Media>();
    }

    public void addMedia(Media m) {
        if (m != null) {
            inventory.add(m);
        }
    }

    public Media removeMedia(Media m) {
        if (m == null) {
            return null;
        }
        
        for(int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).equals(m)) {
                return inventory.remove(i);
            }
        }
        return null;
    }

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

    public Media findMedia(Media m) {
        if (m == null) {
            return null;
        }
        int low = 0;
        int high = inventory.size() - 1;
        while(low <= high) {
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
