public class Main {
    public static void main(String[] args) {
        Order o = new Order();
        Product[] products = {new Product("버거","맛있는 버거","빅맥","맛있는 빅맥"),
                new Product("버거","맛있는 버거","치즈버거","맛있는 치즈버거"),
                new Product("버거","맛있는 버거","치킨버거","맛있는 치킨버거"),
                new Product("버거","맛있는 버거","불고기버거","맛있는 불고기버거")};

        o.addOrder(products[1]);
        o.addOrder(products[3]);
        o.resultOrder();
    }

}
