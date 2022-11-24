package org.example.beans.goods;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
public abstract class Goods {
    private Boolean isBroken;

    public Goods(@Value("false") Boolean isBroken) {
        this.isBroken = isBroken;
    }
}
