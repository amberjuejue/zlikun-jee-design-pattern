package com.zlikun.jee;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/9 10:39
 */
public class TrainFactory {

    private TrainBuilder builder ;

    public TrainFactory(TrainBuilder builder) {
        this.builder = builder;
    }

    public String process() {
        StringBuilder sb = new StringBuilder() ;
        sb.append(builder.buildHeader()).append("-") ;
        sb.append(builder.buildBody()).append("-") ;
        sb.append(builder.buildFooter()) ;
        return sb.toString() ;
    }

}
