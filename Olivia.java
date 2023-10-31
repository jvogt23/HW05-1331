import java.util.ArrayList;
/**
 * @author jvogt33
 * @version 1.00
 */
public class Olivia {
    private static double budget;
    private static ArrayList<Media> cart;
    private static boolean canUseConsole;

    /**
     * Static method that finds a specified Media item in Blockbuster and adds to cart.
     * @param item Media object to attempt to add
     * @param bb Blockbuster object to search through
     * @return boolean whether or not media was added successfully
     */
    public static boolean addToCart(Media item, Blockbuster bb) {
        if (item == null || bb == null) {
            return false;
        }
        Media cartItem;
        if (budget >= item.getRentalPrice()
            && bb.findMedia(item) != null) {
            cartItem = bb.findMedia(item);
        } else {
            return false;
        }
        if (cartItem.getClass() == VideoGame.class
            && ((VideoGame) cartItem).getNeedsConsole()
            && !canUseConsole) {
            return false;
        }
        cart.add(bb.removeMedia(cartItem));
        budget -= cartItem.getRentalPrice();
        return true;
    }

    /**
     * Returns a Media object back to Blockbuster.
     * @param item Media object to attempt to remove from cart
     * @param bb Blockbuster object to add item to
     */
    public static void changeMind(Media item, Blockbuster bb) {
        if (item == null || bb == null) {
            return;
        }
        int rmIndex = -1;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).equals(item)) {
                rmIndex = i;
                break;
            }
        }
        if (rmIndex == -1) {
            return;
        }
        budget += cart.get(rmIndex).getRentalPrice();
        bb.addMedia(cart.remove(rmIndex));
    }
}
