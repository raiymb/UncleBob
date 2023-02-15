import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Film> cart;

    public Cart() {
        cart = new ArrayList<>();
    }

    public void addToCart(Film film) {
        cart.add(film);
    }

    public void removeFromCart(Film film) {
        cart.remove(film);
    }

    public List<Film> getCart() {
        return cart;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Film film : cart) {
            totalPrice += film.getPrice();
        }
        return totalPrice;
    }

    public void clearCart() {
        cart.clear();
    }

    public boolean isCartEmpty() {
        return cart.isEmpty();
    }
}
