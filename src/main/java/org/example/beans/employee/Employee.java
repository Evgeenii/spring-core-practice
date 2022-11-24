package org.example.beans.employee;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.beans.goods.Goods;
import org.example.beans.importers.Importer;
import org.example.beans.storage.Storage;

import java.util.List;
import java.util.stream.IntStream;

@Setter
@Getter
@ToString
public class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    public void acceptGoods(Goods goods, Importer importer, Storage storage, Integer count) {
        importer.sellGoodsToStorage(goods, storage, count);
    }

    public void breakGoods(Goods goods, Storage storage) {
        List<Goods> goodsList = storage.getGoodsMap().get(goods.getClass().getSimpleName());
        IntStream.range(0, goodsList.size())
                .filter(i -> i % 2 == 0)
                .forEach(i -> goodsList.get(i).setIsBroken(true));
    }
}
