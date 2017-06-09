package com.zlikun.jee;

import com.zlikun.jee.factory.BusFactory;
import com.zlikun.jee.factory.CarFactory;
import com.zlikun.jee.factory.ProductFactory;
import com.zlikun.jee.product.Brand;
import com.zlikun.jee.product.Bus;
import com.zlikun.jee.product.Car;
import org.junit.Assert;
import org.junit.Test;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 9:01
 */
public class ProductTest {

    /**
     * 工厂方法模式：工厂接口并不负责具体产品生产，交由产品对应的实现工厂(工厂接口实例)进行生产
     * 工厂接口定义了上层工厂行为，而具体生产动作由实现工厂类完成，该模式仍然隐藏了具体产品实现，但需要暴露实现工厂
     * 优点是：同一产品族扩展产品类型时，不需要修改工厂类，只需要扩展实现工厂类即可，符合开闭原则
     * 缺点是：容易造成类爆炸，而不能解决不同产品族的工厂抽象
     */
    @Test
    public void test() {

        // 小汽车产品线工厂
        ProductFactory<Car> carFactory = new CarFactory(Brand.FERRARI) ;

        Car car = carFactory.create() ;
        Assert.assertEquals(Brand.FERRARI.getChineseName() ,car.brand()) ;
        Assert.assertEquals(120 ,car.price());

        // 巴士产品线工厂
        ProductFactory<Bus> busFactory = new BusFactory(Brand.BENZ) ;

        Bus bus = busFactory.create() ;
        Assert.assertEquals(Brand.BENZ.getChineseName() ,bus.brand()) ;
        Assert.assertEquals(60 ,bus.capacity()) ;

    }

}
