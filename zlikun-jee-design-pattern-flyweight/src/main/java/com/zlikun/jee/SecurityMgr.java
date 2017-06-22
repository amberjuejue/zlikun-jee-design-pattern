package com.zlikun.jee;

import java.util.*;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/22 10:32
 */
public class SecurityMgr {

    private static SecurityMgr securityMgr = new SecurityMgr() ;

    private SecurityMgr(){}

    public static final SecurityMgr getInstance() {
        return securityMgr ;
    }

    // 运行期间存放用户权限数据，在Web应用中，这些可以存放在session中
    private Map<String ,Collection<Flyweight>> storage = new HashMap<>() ;

    /**
     * 模拟用户登录功能
     * @param user
     */
    public void login(String user) {

        // 登录时，把用户权限取出，放入缓存中
        Collection<Flyweight> colls = queryByUser(user) ;

        // 将用户权限存入缓存(session)
        this.storage.put(user ,colls) ;

    }

    /**
     * 判断用户是否有指定权限
     * @param user
     * @param securityEntity
     * @param permit
     * @return
     */
    public boolean hasPermit(String user ,String securityEntity ,String permit) {
        Collection<Flyweight> colls = this.storage.get(user) ;
        if (colls == null || colls.isEmpty()) return false ;
        for (Flyweight flyweight : colls) {
            if (flyweight.match(securityEntity ,permit)) return true ;
        }
        return false ;
    }

    private Collection<Flyweight> queryByUser(String user) {

        // 模拟数据，假定是从数据库中取得
        Map<String ,Collection<String>> userPerms = this.data() ;
        Collection<String> states = userPerms.get(user) ;
        if (states == null || states.isEmpty()) return null ;
        Collection<Flyweight> colls = new ArrayList<>() ;
        for(String state : states) {
            colls.add(FlyweightFactory.getInstance().getFlyweight(state)) ;
        }
        return colls ;
    }

    private Map<String ,Collection<String>> userPerms = new HashMap<>() ;

    private Map<String ,Collection<String>> data() {
        if (userPerms.isEmpty()) {
            userPerms.put("ashe" , Arrays.asList("用户列表,查看" ,"用户列表,修改")) ;
            userPerms.put("jinx" ,Arrays.asList("用户列表,查看")) ;
        }
        return userPerms ;
    }

}
