package com.kiwilss.dagger.test2;

import com.kiwilss.dagger.test.Cloth;

/**
 * FileName: Clothes
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/5/29
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class Clothes {
    private Cloth cloth;

    public Clothes(Cloth cloth) {
        this.cloth = cloth;
    }

    public Cloth getCloth() {
        return cloth;
    }

    @Override
    public String toString() {
        return cloth.getColor() + "衣服";
    }

}
