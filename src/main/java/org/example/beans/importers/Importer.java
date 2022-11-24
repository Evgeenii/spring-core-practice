package org.example.beans.importers;

import org.example.beans.goods.Goods;
import org.example.beans.storage.Storage;

public interface Importer {
    void sellGoodsToStorage(Goods goods, Storage storage, Integer count);
}
