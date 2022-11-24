package org.example.service;

import org.example.beans.employee.Employee;
import org.example.beans.goods.Bicycle;
import org.example.beans.goods.Vodka;
import org.example.beans.importers.Absolute;
import org.example.beans.importers.Aist;
import org.example.beans.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ImportService {
    private final AnnotationConfigApplicationContext context;

    @Autowired
    public ImportService(AnnotationConfigApplicationContext context) {
        this.context = context;
    }

    public void sellGoodsToStorage() {
        Storage storage = context.getBean(Storage.class);
        Employee employee = context.getBean("mishka", Employee.class);
        Vodka vodka = context.getBean(Vodka.class);
        Absolute importerAbsolute = context.getBean(Absolute.class);
        Bicycle bicycle = context.getBean(Bicycle.class);
        Aist importerAist = context.getBean(Aist.class);

        employee.acceptGoods(vodka, importerAbsolute, storage, 3);
        employee.acceptGoods(bicycle, importerAist, storage, 3);

        System.out.println("Импортеры поставили товар");
        System.out.println(storage);
    }
}
