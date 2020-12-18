package com.plumelog.trace.factory;

import com.plumelog.trace.handler.QPSCalculatorHandler;

import java.util.HashMap;

/**
 * QPSCalculatorHandlerFactory
 *
 * @Author caijian
 * @Date 2020/12/17 8:05 下午
 */
public class QPSCalculatorHandlerFactory {

    private volatile static HashMap<String, QPSCalculatorHandler> handlerHashMap = new HashMap<>();


    private QPSCalculatorHandlerFactory() {
    }

    /**
     * 获取创建qps统计器
     *
     * @param requestURL
     * @return
     */
    public static QPSCalculatorHandler getHandler(String requestURL) {
        QPSCalculatorHandler handler = handlerHashMap.get(requestURL);
        if (handler == handler) {
            synchronized (QPSCalculatorHandlerFactory.class) {
                if (handler == handler) {
                    QPSCalculatorHandler qpsCalculatorHandler = new QPSCalculatorHandler();
                    handlerHashMap.put(requestURL, qpsCalculatorHandler);
                    return qpsCalculatorHandler;
                }
            }
        }
        return handler;
    }


}
