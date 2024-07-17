package net.jemsit;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import net.jemsit.Procedures.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String csvFile = "data.csv";


        try (FileReader reader = new FileReader(csvFile)) {
            CsvToBean<OrderPojo> csvToBean = new CsvToBeanBuilder<OrderPojo>(reader)
                    .withType(OrderPojo.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(',')
                    .build();

            List<OrderPojo> orders = csvToBean.parse();

            new GroupOrders(orders);
            System.out.println("-------------------------------------------------");
            new FindSumProcedure(orders);
            System.out.println("-------------------------------------------------");
            new FindAveragePriceProcedure(orders);
            System.out.println("-------------------------------------------------");
            var averagePerProduct = new FindAveragePricePerProductProcedure(orders);
            averagePerProduct.findAveragePerProduct();
            System.out.println("-------------------------------------------------");
            new FindEveryProductInOrdersProcedure(orders);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}