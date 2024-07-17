package net.jemsit.Procedures;

import net.jemsit.OrderPojo;

import java.util.List;

public class FindSumProcedure extends GroupOrders{
    public FindSumProcedure(List<OrderPojo> orders) {
        super(orders);
        System.out.println("Üç siparişteki malların toplam tutarının, toplam fiyatinin çıktısı  => "+ setPrecision(findSum())        );
    }

    public double findSum() {
        return orders.stream().mapToDouble(OrderPojo::getPrice).sum();
    }
}
