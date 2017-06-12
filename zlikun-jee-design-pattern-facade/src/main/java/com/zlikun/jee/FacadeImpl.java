package com.zlikun.jee;

/**
 * 电源开关实现
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/12 11:01
 */
public class FacadeImpl implements Facade {

    private CPU cpu ;
    private Memory memory ;
    private Disk disk ;

    public FacadeImpl() {
        this.cpu = new CPU() ;
        this.memory = new Memory() ;
        this.disk = new Disk() ;
    }

    @Override
    public void turnOn() {
        this.disk.turnOn();
        this.memory.turnOn();
        this.cpu.turnOn();
    }

    @Override
    public void turnOff() {
        this.cpu.turnOff();
        this.memory.turnOff();
        this.disk.turnOff();
    }
}
