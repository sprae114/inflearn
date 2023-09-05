package hello.springmvc.basic.domain;

import lombok.Data;

@Data
public class Item {

    String itemName;
    int price;
    int quantity;
}
