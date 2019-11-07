package com.epam.core.lecutre_10_lifecycle;

/*
import com.epam.core.lecutre_10_lifecycle.BeanLifeCycleExample;
*/
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class InjectValueBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
    System.out.println("*********InjectValueBeanFactoryPostProcessor*********");

    AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder
        .genericBeanDefinition(ExampleBeanLifecycle.class)
        .addPropertyValue("someValue", "my bean")
        .getBeanDefinition();

    ((DefaultListableBeanFactory) beanFactory)
        .registerBeanDefinition("exampleBeanLifecycle", beanDefinition);

    System.out.println("*********InjectValueBeanFactoryPostProcessor*********");
  }
}
