package com.epam.core.lecture_3.lookupExample;

import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public abstract class SingletonBean {

  private final SingletonBean singletonBean;

  protected SingletonBean(SingletonBean singletonBean) {
    this.singletonBean = singletonBean;
  }

  @Transactional
  public void save(){
    update();
  }

  @Transactional
  public void update(){

  }


}
