package cn.smbms.model;

import cn.smbms.inter.Animal;

public class Dog  implements Animal {
    @Override
    public void eat() {
        System.out.println("狗喜欢吃肉");
    }

    @Override
    public void sport() {
        System.out.println("狗喜欢奔跑");
    }
}
