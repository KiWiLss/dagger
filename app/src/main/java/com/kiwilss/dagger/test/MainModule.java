package com.kiwilss.dagger.test;

import com.kiwilss.dagger.interface_all.PerActivity;
import com.kiwilss.dagger.utils.ClothHandler;

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

    @PerActivity
    @Provides
    public Cloth getRedCloth(){
        Cloth cloth = new Cloth();
        cloth.setColor("红色");
        return cloth;
    }

    @PerActivity
    @Provides
    public ClothHandler getClothHandler(){
        return new ClothHandler();
    }


//    @Provides
//    public Cloth getCloth(){
//        Cloth cloth = new Cloth();
//        cloth.setColor("红色");
//        return cloth;
//    }
//
//    @Singleton
//    @Provides
//    //@Named("red")
//    //@RedCloth
//    public Cloth getRedCloth(){
//        Cloth cloth = new Cloth();
//        cloth.setColor("红色");
//        return cloth;
//    }
////    @Provides
////    @Named("blue")
////    public Cloth getBlueCloth(){
////        Cloth cloth = new Cloth();
////        cloth.setColor("蓝色");
////        return cloth;
////    }
//
//    @Provides
//    public Clothes getClothes(Cloth cloth){
//        return new Clothes(cloth);
//    }
//    @Provides
//    public Clothes getClothes(@RedCloth Cloth cloth){
//        return new Clothes(cloth);
//    }
//    @Provides
//    public Clothes getClothes(){
//        Cloth cloth = new Cloth();
//        cloth.setColor("红色");
//        return new Clothes(cloth);
//    }
}
