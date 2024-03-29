package com.koioannis.javacourse_eshop.bizlogic;
import com.koioannis.javacourse_eshop.model.Coupon;
import com.koioannis.javacourse_eshop.model.Product;
import com.koioannis.javacourse_eshop.model.Shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AdminController {

    private Shop shop;
    private List<Product> productList;
    private List<Coupon> couponList;

    private static AdminController INSTANCE;

    public static AdminController getInstance () {
        return INSTANCE;
    }

    private AdminController() {
        productList = new ArrayList<>();
        productList.add (new Product (0.99, "Maça Fuji"));
        productList.add (new Product (800, "2019 8 core android"));
        productList.add (new Product (55.40, "Import java.extra.cd"));
        productList.add (new Product (0.05, "Antique Mips Chip"));
        couponList = new ArrayList<>();
        couponList.add (new Coupon ("SummerOffer", 20));
        couponList.add (new Coupon ("NewUser12542", 25));

        shop = new Shop (productList, couponList);
    }

    public Shop getShop(){
        return shop;
    }

    public Product getProduct (int index) {
        return shop.getExistingProducts().get(index);
    }

    public int getReduction (String code) {
        for (Coupon coupon: shop.getExistingCoupons()) {
            if (coupon.getCode().equals(code))
                return coupon.getPercentageReduction();
        }
        return -1;
    }

    public static void instantiateApp(){
        INSTANCE = new AdminController();
        OrderController.instantiateOrderController();
        BillingController.instantiateBillingController();
    }


}
