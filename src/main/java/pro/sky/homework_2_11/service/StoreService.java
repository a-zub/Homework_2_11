package pro.sky.homework_2_11.service;

import org.springframework.stereotype.Service;
import pro.sky.homework_2_11.component.Basket;
import pro.sky.homework_2_11.model.Item;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StoreService {

    private final Basket basket;
    private final Map<Integer, Item> items;

    public StoreService(Basket basket) {
        this.basket = basket;
        this.items = Map.of(
                1, new Item(1, "Чайник", 2_000),
                2, new Item(2, "Кофеварка ", 25_000),
                3, new Item(3, "Телефон", 25_000),
                4, new Item(4, "Фен", 500),
                5, new Item(5, "Настольная лампа", 1_000),
                6, new Item(6, "Пылесос", 4_000)
        );
    }

    public void add(List<Integer> ids) {
       basket.add( ids.stream()
               .map(items::get)
               .filter(Objects::isNull)
               .collect(Collectors.toList())
       );
    }

    public List<Item> get() {
        return basket.get();
    }
}
