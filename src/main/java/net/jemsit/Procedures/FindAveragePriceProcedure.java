package net.jemsit.Procedures;

import net.jemsit.OrderPojo;

import java.util.List;

public class FindAveragePriceProcedure extends GroupOrders {
    public FindAveragePriceProcedure(List<OrderPojo> orders) {
        super(orders);
        System.out.println("Üç siparişteki bütün malların ortalama fiyatı => " + setPrecision(findAveragePrice()));
    }
    public double findAveragePrice(){
        int totalCount = orders.stream().mapToInt(OrderPojo::getQuantity).sum();
        double totalPrice = orders.stream().mapToDouble(OrderPojo::getPrice).sum();
        return totalPrice / totalCount;
    }
}
