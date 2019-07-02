package com.gupaoedu.vip.netty.rpc.consumer;

import com.gupaoedu.vip.netty.rpc.api.IRpcHelloService;
import com.gupaoedu.vip.netty.rpc.consumer.proxy.RpcProxy;

public class RpcConsumer {
	
    public static void main(String [] args){  
        IRpcHelloService rpcHello = RpcProxy.create(IRpcHelloService.class);
        
        System.out.println(rpcHello.hello("Tom老师"));

    }
    
}
