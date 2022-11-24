package org.example.beans.goods;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bicycle extends Goods {
    public Bicycle(@Value("false") Boolean isBroken) {
        super(isBroken);
    }
}
