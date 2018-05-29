package com.kiwilss.dagger.utils;

import com.kiwilss.dagger.test.Cloth;
import com.kiwilss.dagger.test2.Clothes;

/**
 * FileName: ClothHandler
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/5/29
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class ClothHandler {
    public Clothes handle(Cloth cloth){
        return new Clothes(cloth);
    }



}
