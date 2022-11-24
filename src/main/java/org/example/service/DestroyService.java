package org.example.service;

import org.example.beans.employee.Employee;
import org.example.beans.goods.Bicycle;
import org.example.beans.goods.Goods;
import org.example.beans.goods.Vodka;
import org.example.beans.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Component
public class DestroyService {
    private final AnnotationConfigApplicationContext context;

    @Autowired
    public DestroyService(AnnotationConfigApplicationContext context) {
        this.context = context;
    }

    public void destroyGoods() {
        Storage storage = context.getBean(Storage.class);
        Employee employee = context.getBean("mishka", Employee.class);
        Vodka vodka = context.getBean(Vodka.class);
        Bicycle bicycle = context.getBean(Bicycle.class);
        Map<String, List<Goods>> storageMap = storage.getGoodsMap();

        IntStream.range(0, storageMap.get(Vodka.class.getSimpleName()).size()).filter(i -> i % 2 == 0).forEach(i -> {
            employee.breakGoods(vodka, storage);
            employee.breakGoods(bicycle, storage);
        });
        System.out.println("Работники побили водку и велосипеды");
        System.out.println(storage);
    }
}
