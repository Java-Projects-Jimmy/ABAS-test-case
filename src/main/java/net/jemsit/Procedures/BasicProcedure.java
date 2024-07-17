package net.jemsit.Procedures;

import net.jemsit.OrderPojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public abstract class BasicProcedure {
    public HashMap<Integer, List<OrderPojo>> groupOfOrders = new HashMap<>();

    public abstract void groupingOrders();

    public abstract boolean checkForEmptyOrder(OrderPojo orderPOJO);

    public abstract BigDecimal setPrecision(double target);

    public void displayGroups(){
       groupOfOrders.forEach((key,value)->{
           System.out.println(key + "-> " + value);
       });
    };
}
