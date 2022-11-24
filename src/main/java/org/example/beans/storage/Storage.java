package org.example.beans.storage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.beans.employee.Employee;
import org.example.beans.goods.Bicycle;
import org.example.beans.goods.Goods;
import org.example.beans.goods.Vodka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Component
@Getter
@ToString
public class Storage {
    private final Employee employee1;
    private final Employee employee2;
    private final Map<String, List<Goods>> goodsMap;

    @Autowired
    public Storage(@Qualifier("mishka") Employee employee1,
                   @Qualifier("zelya") Employee employee2) {
        this.employee1 = employee1;
        this.employee2 = employee2;
        this.goodsMap = new HashMap<>();
        this.goodsMap.put(Vodka.class.getSimpleName(), new ArrayList<>());
        this.goodsMap.put(Bicycle.class.getSimpleName(), new ArrayList<>());
    }

    public void acceptGoods(Goods goods, Integer count) {
        List<Goods> goodsList = goodsMap.get(goods.getClass().getSimpleName());
        IntStream.range(0, count).forEach(i -> {
            if (goods instanceof Vodka) {
                goodsList.add(new Vodka(false));
            } else if (goods instanceof Bicycle) {
                goodsList.add(new Bicycle(false));
            }
        });
    }
}
