package com.gupaoedu.vip.netty.rpc.consumer.proxy;

import com.gupaoedu.vip.netty.rpc.protocol.InvokerProtocol;
import com.gupaoedu.vip.netty.rpc.util.RPCUtil;

import java.lang.reflect.Proxy;

public class RpcProxy {  
	
	public static <T> T create(Class<?> clazz){
        //clazz传进来本身就是interface
        Class<?> [] interfaces = clazz.isInterface() ?
                                new Class[]{clazz} :
                                clazz.getInterfaces();


        T result = (T) Proxy.newProxyInstance(clazz.getClassLoader(),interfaces,
				(object,method,args)->{
					InvokerProtocol invokerProtocol=RPCUtil.getProtocol(clazz.getName(),method, args);
					return 	RPCUtil.rpcInvoke(invokerProtocol);
				});
        return result;
    }
}



