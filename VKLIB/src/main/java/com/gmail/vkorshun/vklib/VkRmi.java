package com.gmail.vkorshun.vklib;

import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * Created by vkorshun on 07.06.2016.
 */
public class VkRmi {

  public static <T> T createRmiObject(Class<?> cl,  String remoteName) {
    return createRmiObject(cl,System.getProperty("rmi.host"),System.getProperty("rmi.port"),remoteName);
  }

  public static <T> T createRmiObject(Class<?> cl,String rmiHost,String rmiPort,  String remoteName) {
    RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
    rmiProxyFactoryBean.setServiceUrl(String.format("rmi://%s:%s/%s",rmiHost, rmiPort, remoteName));
    rmiProxyFactoryBean.setServiceInterface(cl);
    rmiProxyFactoryBean.afterPropertiesSet();
    return (T) rmiProxyFactoryBean.getObject();
  }

}
