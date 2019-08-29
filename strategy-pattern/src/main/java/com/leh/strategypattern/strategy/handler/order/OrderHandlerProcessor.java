package com.leh.strategypattern.strategy.handler.order;

import com.google.common.collect.Maps;
import org.reflections.Reflections;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

/**
 * @Auther: leh
 * @Date: 2019/5/22 10:50
 * @Description:
 * HandlerProcessor需要实现BeanFactoryPostProcessor，
 * 在spring处理bean前，将自定义的bean注册到容器中。
 */
@Component
public class OrderHandlerProcessor implements BeanFactoryPostProcessor {

    private static final String SCANNER_PACKAGE = "com.leh.strategypattern.strategy.handler.order.concrete";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        Map<String, Class> map = Maps.newHashMapWithExpectedSize(3);

        Reflections reflections = new Reflections(SCANNER_PACKAGE);
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(OrderHandlerType.class);

        classSet.forEach(clazz -> {
            //获取注解中的类型值
            String type = clazz.getAnnotation(OrderHandlerType.class).value();
            //将注解中的类型值作为key，对应的类作为value，保存在Map中
            map.put(type, clazz);
        });

        //初始化HandlerContext,将其注册到spring容器中
        OrderHandlerContext context = new OrderHandlerContext(map);
        configurableListableBeanFactory.registerSingleton(OrderHandlerContext.class.getName(), context);

    }
}
