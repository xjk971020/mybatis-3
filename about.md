Mybatis源码解析关联的知识点:

1、Method类中getDeclaringClass()方法的作用:

`java.lang.reflect.Method.getDeclaringClass()`方法返回表示声明由此`Method`对象表示的方法的类的`Class`对象。

2、Map中的computeIfAbsent()方法:

HashMap computeIfAbsent(Key, Function) 的这个方法，是被用来计算给定key，给定映射函数的的值。
如果，key之前并没有映射到一个值，或者映射到null，那么，就用计算出来的值放到这个hashmap中。

**如果这个映射函数返回null，那么不添加任何k-v对。**
如果在计算过程中，抛出异常，那么不添加任何k-v对。
在计算过程中，无法修改此map，不然方法会抛出ConcurrentModificationException。	