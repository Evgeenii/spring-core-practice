package org.example.beans.importers;

import org.example.beans.goods.Goods;
import org.example.beans.storage.Storage;
import org.springframework.stereotype.Component;

@Component
public class Aist implements Importer {
    @Override
    public void sellGoodsToStorage(Goods goods, Storage storage, Integer count) {
        storage.acceptGoods(goods, count);
    }
}
