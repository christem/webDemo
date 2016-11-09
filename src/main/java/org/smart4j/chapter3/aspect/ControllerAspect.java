package org.smart4j.chapter3.aspect;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.annotation.Aspect;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.proxy.AspectProxy;

/**
 * 拦截 Controller 所有方法
 *
 * @author huangyong
 * @since 1.0.0
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        LOGGER.debug("---------- begin ----------");
        LOGGER.debug(String.format("class: %s", cls.getName()));
        LOGGER.debug(String.format("method: %s", method.getName()));

        System.out.println("---------- begin ----------");
        System.out.println(String.format("class: %s", cls.getName()));
        System.out.println(String.format("method: %s", method.getName()));

        begin = System.currentTimeMillis();

    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        long time = System.currentTimeMillis() - begin;
        LOGGER.debug(String.format("time: %dms", time));
        LOGGER.debug("----------- end -----------");

        System.out.println(String.format("time: %dms", time));
        System.out.println("----------- end -----------");
    }
}
