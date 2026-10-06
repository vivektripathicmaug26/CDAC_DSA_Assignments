import java.util.ArrayList;

class CartItem {
    String name;
    int price;
    int qty;

    CartItem(String name, int price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    int lineTotal() {
        return price * qty;
    }
}

public class ShoppingCart {
    private ArrayList<CartItem> items = new ArrayList<>();

    private int indexOf(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).name.equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public void add(String name, int price, int qty) {
        int idx = indexOf(name);
        if (idx != -1) {
            items.get(idx).qty += qty;
        } else {
            items.add(new CartItem(name, price, qty));
        }
    }

    public void remove(String name) {
        int idx = indexOf(name);
        if (idx != -1) items.remove(idx);
    }

    public void updateQty(String name, int qty) {
        int idx = indexOf(name);
        if (idx != -1) {
            if (qty <= 0) items.remove(idx);
            else items.get(idx).qty = qty;
        }
    }

    public void printBill() {
        int subtotal = 0;
        for (CartItem item : items) {
            subtotal += item.lineTotal();
        }
        int discount = (subtotal >= 1000) ? subtotal / 10 : 0;
        int afterDiscount = subtotal - discount;
        int delivery = (afterDiscount < 500 && afterDiscount > 0) ? 40 : 0;
        int total = afterDiscount + delivery;

        System.out.println("Bill: Subtotal " + subtotal + " | Discount " + discount + " | Delivery " + delivery + " | Total " + total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.add("Shoes", 600, 2);
        cart.add("Socks", 100, 3);
        cart.printBill();
    }
}
