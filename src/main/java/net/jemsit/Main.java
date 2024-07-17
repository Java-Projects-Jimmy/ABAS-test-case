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


        try {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "--data":
                        if (i + 1 < args.length) {
                            csvFile = args[i + 1];
                            i++;
                        } else {
                            System.err.println("Error: --config requires a file path");
                            return;
                        }
                        break;
                    default:
                        System.err.println("Unknown argument: " + args[i]);
                        return;
                }
            }
            FileReader reader = new FileReader(csvFile);

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