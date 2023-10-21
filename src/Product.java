public class Product extends Menu{
    String productName;
    String productDescription;
    Product(String mn, String md, String pn, String pd){
        super(mn,md);
        productName = pn;
        productDescription = pd;
    }
}
