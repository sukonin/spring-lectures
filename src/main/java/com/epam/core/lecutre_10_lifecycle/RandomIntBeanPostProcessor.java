package com.epam.core.lecutre_10_lifecycle;

import com.epam.core.lecutre_10_lifecycle.InjectRandomInt;
import java.lang.reflect.Field;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Component;

@Component
public class RandomIntBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    System.out.println("*********postProcessBeforeInitialization*********");

    Field[] fields = bean.getClass().getDeclaredFields();

    for (Field field : fields) {
      if (field.isAnnotationPresent(InjectRandomInt.class)) {
        field.setAccessible(true);
        InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
        ReflectionUtils
            .setField(field, bean, getRandomIntInRange(annotation.min(), annotation.max()));
      }
    }

    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("*********postProcessAfterInitialization*********");

    return bean;
  }

  private int getRandomIntInRange(int min, int max) {
    return min + (int) (Math.random() * ((max - min) + 1));
  }
}
