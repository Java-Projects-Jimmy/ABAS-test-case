package net.jemsit;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderPojo {
    @CsvBindByName(column = "Sipariş")
    private int orderNo;
    @CsvBindByName(column = "Mal Numarası")
    private int productNo;
    @CsvBindByName(column = "Miktar")
    private int quantity;
    @CsvBindByName(column = "Birim Fiyat (TL)")
    private String price;

    public void setPrice(String price) {
        if (price.isEmpty() || price.isBlank()) this.price = "0";
        else this.price = price;
    }

    public double getPrice() {
        return Double.parseDouble(price.replace(",", "."));
    }


}
