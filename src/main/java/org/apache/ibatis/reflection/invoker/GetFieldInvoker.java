/**
 *    Copyright 2009-2018 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.reflection.invoker;

import java.lang.reflect.Field;

import org.apache.ibatis.reflection.Reflector;

/**
 * @author Clinton Begin
 */

/**
 * 针对某个对象的成员变量的get执行器，通过反射的方法获取某个类中某个成员变量的值
 */
public class GetFieldInvoker implements Invoker {
  private final Field field;

  public GetFieldInvoker(Field field) {
    this.field = field;
  }

  /**
   * 获取某个对象的某个Field的值
   * @param target 目标对象
   * @param args   此方法中没有用到
   * @return       获取到的值
   * @throws IllegalAccessException
   */
  @Override
  public Object invoke(Object target, Object[] args) throws IllegalAccessException {
    try {
      return field.get(target);
    } catch (IllegalAccessException e) {
      //判断是否有权限访问变量
      if (Reflector.canControlMemberAccessible()) {
        //修改访问权限
        field.setAccessible(true);
        return field.get(target);
      } else {
        throw e;
      }
    }
  }

  /**
   * 返回Field类型的属性
   * @return
   */
  @Override
  public Class<?> getType() {
    return field.getType();
  }
}
