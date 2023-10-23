
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    static int orderNum = 1;

    // 주문한 제품 객체들이 들어가있는 리스트
    static ArrayList<Product> orderList = new ArrayList<>();
    static ArrayList<Product> burgers = new ArrayList<>();
    static ArrayList<Product> drinks = new ArrayList<>();
    static ArrayList<Product> sides = new ArrayList<>();

    static void printMainMenu() throws InterruptedException {
        System.out.println("맥도날드에 오신것을 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라주세요");
        System.out.println();
        System.out.println("[Menu]");
        System.out.print("1. Burgers");
        System.out.println("| 햄버거입니다.");
        System.out.print("2. Drinks");
        System.out.println("| 음료입니다.");
        System.out.print("3. Sides");
        System.out.println("| 사이드입니다.");
        System.out.println();
        System.out.println("[Order Menu]");
        System.out.println("4. Order");
        System.out.println("5. Cancel");

        Scanner sc = new Scanner(System.in);
        int select = Integer.parseInt(sc.nextLine());

        if (select == 1) {
            printDetailMenu("Burgers");
        } else if (select == 2) {
            printDetailMenu("Drinks");
        } else if (select == 3) {
            printDetailMenu("Sides");
        } else if (select == 4) {
            printOrder();
        } else if (select == 5) {
            cancel();
        } else {
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            printMainMenu();
        }
    }

    // 버거 메뉴 페이지
    static void printDetailMenu(String p) throws InterruptedException {
        ArrayList<Product> s;
        if (p.equals("Burgers")) {
            s = burgers;
        } else if (p.equals("Drinks")) {
            s = drinks;
        } else {
            s = sides;
        }
        System.out.println("맥도날드에 오신것을 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라주세요");
        System.out.println();
        System.out.println("[" + p + " Menu]");
        for (int i = 0; i < s.size(); i++) {
            System.out.println(i + 1 + ". " + s.get(i).name + " | " + s.get(i).price + "원" + " | " + s.get(i).description);
        }
        System.out.println("\n0. 메인화면으로 돌아가기");
        Scanner sc = new Scanner(System.in);
        int select = Integer.parseInt(sc.nextLine());

        if (select == 0) {  // 초기화 후 메인페이지로 이동
            printMainMenu();
        } else if (0 < select && select <= s.size()) {
            confirmAddMenu(s.get(select - 1), p);
        } else {
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            printDetailMenu(p);
        }
    }

    static void confirmAddMenu(Product food, String p) throws InterruptedException {
        System.out.println("\"" + food.name + " | " + food.price + "원" + " | " + food.description + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하겠습니까?");
        System.out.println("1. 확인  2. 취소");
        Scanner sc = new Scanner(System.in);
        int select = Integer.parseInt(sc.nextLine());
        if (select == 1) {
            //추가하고 메인메뉴 페이지 이동
            orderList.add(food);
            printMainMenu();
        } else if (select == 2) {
            // 취소하고 세부 메뉴 페이지로 이동
            printDetailMenu(p);
        } else {
            System.out.println("잘못 입력하셨습니다.");
            confirmAddMenu(food, p);
        }
    }

    static void printOrder() throws InterruptedException {
        int total = 0;
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[Orders]");
        for (Product product : orderList) {
            System.out.println(product.name + " | " + product.description + " | " +
                    product.price);
            total += product.price;
        }
        System.out.println("\n[Total]");
        System.out.println(total + "원");
        System.out.println("1. 주문 2. 메뉴판\n");

        Scanner sc = new Scanner(System.in);
        int select = Integer.parseInt(sc.nextLine());

        if (select == 1) {
            orderComplete();
        } else if (select == 2) {
            printMainMenu();
        } else {
            System.out.println("잘못 입력하셨습니다.");
            printOrder();
        }
    }

    static void orderComplete() throws InterruptedException {
        System.out.println("주문이 완료되었습니다!\n");
        System.out.println("대기번호는 [" + orderNum++ + "] 번 입니다.");
        System.out.println("3초후 메뉴판으로 이동합니다.\n");
        Thread.sleep(3000);

        //다시 시작
        init();
    }

    static void init() throws InterruptedException {
        orderList = new ArrayList<>();
        printMainMenu();
    }

    static void cancel() throws InterruptedException {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인 2. 취소");
        Scanner sc = new Scanner(System.in);
        int select = Integer.parseInt(sc.nextLine());
        if(select == 1){
            init();
        }else if (select == 2){
            printMainMenu();
        }
        else {
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            cancel();
        }
    }
}
