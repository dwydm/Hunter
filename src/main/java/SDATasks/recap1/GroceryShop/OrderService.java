package SDATasks.recap1.GroceryShop;

public class OrderService {

    public void sumBasketValue(Basket basket) {
        System.out.println(basket.getBasketContent().stream()
                .mapToDouble(product -> product.getProductPrice() * product.getProductCount())
                .sum());
    }

}
