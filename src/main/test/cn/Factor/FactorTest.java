package cn.Factor;

import cn.smbms.inter.Animal;
import cn.smbms.model.Factory;
import org.junit.Test;

public class FactorTest {

    @Test
    public void test(){
        Factory factory=new Factory();
        Animal animal=null;
        animal=factory.getAnimal("dog");
        animal.eat();
        animal.sport();
    }
}
