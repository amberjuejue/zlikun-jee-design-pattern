package com.zlikun.jee;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/19 11:03
 */
public class YearDecorator extends Decorator {
    public YearDecorator(Component component) {
        super(component);
    }

    @Override
    public double calc(String user, int seniority) {
        // 计算之前算出的奖金
        double origin = super.calc(user, seniority);

        // 按员工级别发年终将
        double prize = employeYearPrize(user) ;

        return origin + prize ;
    }

    private double employeYearPrize(String user) {
        // 只有老板有10000，其它员工都只有2000
        // 这公司怕是会招不到人的吧 !!!
        if (user.equals("boss"))
            return 10000 ;
        else
            return 2000 ;
    }

}
