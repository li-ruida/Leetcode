# 刷题仓库
> 看看能不能做到一天一题 :first_quarter_moon:

设置了自定义注解,终端可根据注解查找方法

```java
public @interface Leetcode {
    String value() default "暴力";//多个可以指定为数组
}
```

```java
grep -r "@Leetcode"
```

