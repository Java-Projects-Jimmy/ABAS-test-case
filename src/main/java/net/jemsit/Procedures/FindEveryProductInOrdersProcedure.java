package net.jemsit.Procedures;

import net.jemsit.OrderPojo;

import java.util.HashMap;
import java.util.List;

public class FindEveryProductInOrdersProcedure extends GroupOrders{
    public FindEveryProductInOrdersProcedure(List<OrderPojo> orders) {
        super(orders);
        findEachProductsCountInEachOrder();
    }

    public void findEachProductsCountInEachOrder() {
        HashMap<Integer, OrderCounts> mapOfCounts = new HashMap<>();
        for (OrderPojo order : orders) {
            mapOfCounts.put(
                    order.getProductNo(),
                    mapOfCounts.getOrDefault(order.getProductNo(), new OrderCounts(order.getOrderNo()))
                            .addNewCount(order.getOrderNo())
            );
        }
        mapOfCounts.forEach((key,value)->{
            System.out.println("Mal numarası "+key + " olan mal=>"+value);
        });

    }
}
