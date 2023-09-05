package hello.springmvc.basic.domain;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ItemsRepository {
    public static Map<Item, Integer> itemRepository = new HashMap<>();
    private static int num = 0;

    public void save(Item item){
        itemRepository.put(item, num++);
    }
}
