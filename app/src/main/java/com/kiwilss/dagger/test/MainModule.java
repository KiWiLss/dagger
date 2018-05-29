package com.kiwilss.dagger.test;

import dagger.Module;
import dagger.Provides;

/**
 * FileName: MainModule
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/5/29
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
@Module
public class MainModule {

    @Provides
    public Cloth getCloth(){
        Cloth cloth = new Cloth();
        cloth.setColor("红色");
        return cloth;
    }

}
