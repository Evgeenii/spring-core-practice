package org.example.beans.goods;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")

public class Vodka extends Goods {
    public Vodka(@Value("false") Boolean isBroken) {
        super(isBroken);
    }
}
