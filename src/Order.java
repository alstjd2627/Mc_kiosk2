import javax.swing.*;
import java.util.ArrayList;

public class Order {

    // 주문한 제품 객체들이 들어가있는 리스틔
    ArrayList<Product> orderList = new ArrayList<>();

    // 주문 리스트에 제품 추가
    void addOrder(Product p){
        orderList.add(p);
    }

    // 주문 리스트에서 특정 제품 주문 취소(삭제)
    void deleteOrder(Product p){
        for(int i = 0 ; i < orderList.size(); i++){
            if (orderList.get(i).equals(p)){
                orderList.remove(i);
                break;
            }
        }
    }

    void resultOrder(){
        for (Product product : orderList) {
            System.out.println(product.productName);
        }
    }
}
