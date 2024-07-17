package net.jemsit.Procedures;

import lombok.Getter;
import lombok.Setter;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class OrderCounts {
    private HashMap<Integer, Integer> countsOfProduct=new HashMap<>();

    public OrderCounts(int orderNo) {
        countsOfProduct.put(orderNo, countsOfProduct.getOrDefault(orderNo, 0));
    }

    public  OrderCounts addNewCount(int orderNo) {
        countsOfProduct.put(orderNo, countsOfProduct.getOrDefault(orderNo, 0) + 1);
        return this;
    }

    @Override
    public String toString() {
        String result = "";
        int counter = 0;
        for (Map.Entry<Integer, Integer> count : countsOfProduct.entrySet()) {
            if (!result.isBlank()) result += " ".repeat(28);
            result +=  count.getKey() + " sipariş numarada " + count.getValue() + " tane";
            counter++;
            if (counter < countsOfProduct.size()) result += "\n";
        }
        return result;
    }
}
