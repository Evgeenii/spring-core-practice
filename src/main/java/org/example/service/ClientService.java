package org.example.service;

import org.example.beans.clients.Petrovich;
import org.example.beans.clients.Reushar;
import org.example.beans.goods.Bicycle;
import org.example.beans.goods.Goods;
import org.example.beans.goods.Vodka;
import org.example.beans.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ClientService {
    private final AnnotationConfigApplicationContext context;

    @Autowired
    public ClientService(AnnotationConfigApplicationContext context) {
        this.context = context;
    }

    public void buyGoods() {
        Storage storage = context.getBean(Storage.class);
        Map<String, List<Goods>> storageMap = storage.getGoodsMap();

        Petrovich petrovich = context.getBean(Petrovich.class);
        storageMap.get(Vodka.class.getSimpleName()).stream().
                filter(Goods::getIsBroken).
                forEach(petrovich::buyGoods);
        storageMap.get(Vodka.class.getSimpleName())
                .removeIf(Goods::getIsBroken);

        Reushar reushar = context.getBean(Reushar.class);
        storageMap.get(Bicycle.class.getSimpleName()).stream()
                .filter(bicycle -> !bicycle.getIsBroken())
                .forEach(reushar::buyGoods);
        storageMap.get(Bicycle.class.getSimpleName())
                .removeIf(Goods::getIsBroken);

        System.out.println("Клиенты купили товары");
        System.out.println(petrovich);
        System.out.println(reushar);
        System.out.println(storage);
    }
}
