package org.example;

import org.example.config.Config;
import org.example.service.ClientService;
import org.example.service.DestroyService;
import org.example.service.ImportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        ImportService importerService = context.getBean(ImportService.class);
        DestroyService destroyService = context.getBean(DestroyService.class);
        ClientService clientService = context.getBean(ClientService.class);

        importerService.sellGoodsToStorage();
        destroyService.destroyGoods();
        clientService.buyGoods();

    }
}