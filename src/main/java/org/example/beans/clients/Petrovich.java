package org.example.beans.clients;

import lombok.ToString;
import org.example.beans.goods.Goods;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ToString
public class Petrovich implements Client {
    private final List<Goods> homeStorage;

    public Petrovich() {
        this.homeStorage = new ArrayList<>();
    }

    @Override
    public void buyGoods(Goods goods) {
        homeStorage.add(goods);
    }
}
