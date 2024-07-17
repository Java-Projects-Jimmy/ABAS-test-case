package net.jemsit.Procedures;

import net.jemsit.OrderPojo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class GroupOrders extends BasicProcedure {
    public List<OrderPojo> orders;
    public GroupOrders(List<OrderPojo> orders) {
        this.orders = orders;
    }

    @Override
    public void groupingOrders() {
        List<OrderPojo> group = new ArrayList<>();
        int groupNo = 1;
        for (OrderPojo order : orders) {
            if (checkForEmptyOrder(order)) {
                groupOfOrders.put(groupNo, group);
                group = new ArrayList<>();
                groupNo++;
            }else {
                group.add(order);
            }
        }
        groupOfOrders.put(groupNo, group);
    }

    @Override
    public boolean checkForEmptyOrder(OrderPojo orderPOJO) {
        return orderPOJO.getOrderNo() == 0
                && orderPOJO.getProductNo() == 0
                && orderPOJO.getQuantity() ==0
                &&orderPOJO.getPrice() ==0;
    }

    @Override
    public BigDecimal setPrecision(double target) {
        return BigDecimal.valueOf(target).setScale(2, RoundingMode.HALF_UP);
    }

}
