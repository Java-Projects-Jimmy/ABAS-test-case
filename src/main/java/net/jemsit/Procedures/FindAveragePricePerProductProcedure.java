package net.jemsit.Procedures;

import net.jemsit.OrderPojo;

import java.util.Comparator;
import java.util.List;

public class FindAveragePricePerProductProcedure extends GroupOrders{
    public FindAveragePricePerProductProcedure(List<OrderPojo> orders) {
        super(orders);
    }

    public void findAveragePerProduct() {
        orders.removeIf(super::checkForEmptyOrder);
        orders = orders.stream().sorted(Comparator.comparingInt(OrderPojo::getProductNo)).toList();
        int tempQuantity = 0;
        double tempPRice = 0;
        OrderPojo tempOrder = null;
        for (OrderPojo order : orders) {
            if (tempOrder != null && tempOrder.getProductNo() != order.getProductNo()) {
                System.out.println("Mal numarası " + tempOrder.getProductNo() + " olan malin, mal bazlı ortalama fiyatı=> " + setPrecision(tempPRice / tempQuantity));
                tempQuantity = 0;
                tempPRice = 0;
            }
            tempOrder = order;
            tempQuantity += tempOrder.getQuantity();
            tempPRice += tempOrder.getPrice();
        }
        System.out.println("Mal numarası " + tempOrder.getProductNo() + " olan malin, mal bazlı ortalama fiyatı=> " + setPrecision(tempPRice / tempQuantity));
    }
}
