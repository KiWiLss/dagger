package com.kiwilss.dagger.test;

import com.kiwilss.dagger.MainActivity;

import dagger.Component;

/**
 * FileName: MainComponent
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/5/29
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
@Component(modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
