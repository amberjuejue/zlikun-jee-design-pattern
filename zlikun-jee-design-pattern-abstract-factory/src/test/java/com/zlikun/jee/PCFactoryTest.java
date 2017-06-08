package com.zlikun.jee;

import com.zlikun.jee.product.CPU;
import com.zlikun.jee.product.MainBoard;
import com.zlikun.jee.product.factory.AMDPCFactory;
import com.zlikun.jee.product.factory.IntelPCFactory;
import com.zlikun.jee.product.factory.PCFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/8 12:07
 */
public class PCFactoryTest {

    @Test
    public void test() {

        // 创建 Intel PC 工厂，该工厂封装了CPU和主板生成逻辑
        // 实现工厂通过指定针脚数，来控制CPU和主板之间相互匹配(产品之间依赖)，避免出现针脚与CPU插槽针孔不匹配的问题
        PCFactory factory = new IntelPCFactory() ;
        CPU cpu = factory.createCPU() ;
        MainBoard mb = factory.createMainBoard() ;

        Assert.assertEquals(cpu.pins() ,mb.holes());
        Assert.assertEquals("Intel" ,cpu.model());
        Assert.assertEquals("技嘉主板" ,mb.model());

        // 创建 AMD PC 工厂
        factory = new AMDPCFactory() ;
        cpu = factory.createCPU() ;
        mb = factory.createMainBoard() ;

        Assert.assertEquals(cpu.pins() ,mb.holes());
        Assert.assertEquals("AMD" ,cpu.model());
        Assert.assertEquals("微星主板" ,mb.model());

    }

}
