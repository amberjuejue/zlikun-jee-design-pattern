package com.zlikun.jee;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/22 10:23
 */
public class AuthorizationFlyweight implements Flyweight {

    private String securityEntity ;
    private String permit ;

    /**
     * 构造方法，传入状态数据，状态数据包含安全实体和权限，用`,`分隔
     * @param state
     */
    public AuthorizationFlyweight(String state) {
        String [] array = state.split(",") ;
        securityEntity = array[0] ;
        permit = array[1] ;
    }

    @Override
    public boolean match(String securityEntity, String permit) {
        return this.securityEntity.equals(securityEntity) && this.permit.equals(permit) ;
    }

    public String getSecurityEntity() {
        return securityEntity;
    }

    public String getPermit() {
        return permit;
    }
}
