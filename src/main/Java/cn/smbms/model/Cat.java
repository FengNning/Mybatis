package cn.smbms.model;

import cn.smbms.inter.Animal;

import java.sql.SQLOutput;

public class Cat  implements Animal {
    @Override
    public void eat() {
        System.out.println("猫喜欢吃鱼");
    }

    @Override
    public void sport() {
        System.out.println("猫很懒，不喜欢运动");
    }
}
