public class Main {
    public static void main(String[] args) throws InterruptedException {
        Order o = new Order();
        Order.burgers.add(new Product("빅맥","맛있는 빅맥입니다.",1000));
        Order.burgers.add(new Product("치즈버거","맛있는 치즈버거입니다.",2000));
        Order.burgers.add(new Product("불고기버거","맛있는 불고기버거입니다.",3000));
        Order.burgers.add(new Product("치킨버거","맛있는 치킨버거입니다.",4000));
        Order.drinks.add(new Product("콜라","맛있는 콜라입니다.",1000));
        Order.drinks.add(new Product("사이다","맛있는 사이다입니다.",2000));
        Order.drinks.add(new Product("환타","맛있는 환타입니다.",3000));
        Order.sides.add(new Product("아이스크림","맛있는 아이스크림입니다.",2000));
        Order.sides.add(new Product("너겟","맛있는 너겟입니다.",3000));
        Order.sides.add(new Product("감자튀김","맛있는 감자튀김입니다.",4000));

        Order.printMainMenu();
    }

}
