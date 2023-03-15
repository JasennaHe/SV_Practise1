

# SpringBoot+Vue后台管理系统



## 1，教程说明

​	bilibili视频教程地址：[5. SpringBoot框架搭建_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1U44y1W77D?p=5&vd_source=6968514c7d683f5a25ce6bf14d3cd33f)



## 2，笔记

### 1，在pom中配置阿里云maven地址

```xml
<repositories>
	<repository>
		<id>nexus-aliyun</id>
		<name>nexus-aliyun</name>
		<url>http://maven.aliyun.com/nexus/content/groups/public</url>
		<releases>
			<enabled>true</enabled>
		</releases>
		<snapshots>
			<enabled>false</enabled>
		</snapshots>
	</repository>
</repositories>

<pluginRepositories>
	<pluginRepository>
		<id>public</id>
		<name>aliyun nexus</name>
		<url>http://maven.aliyun.com/nexus/content/groups/public</url>
		<releases>
			<enabled>true</enabled>
		</releases>
		<snapshots>
			<enabled>false</enabled>
		</snapshots>
	</pluginRepository>
</pluginRepositories>
```

### 2，vue引入ElementUI时加参数

这里要先打{size:""}，然后会自动加上options

```javascript
Vue.use(ElementUI,{size:"mini"});
```

### 3，IDEA  构造函数

方式一：alt+ins键快捷

方式二：**lombok插件**

```java
package com.jianbo.springboot.entity;

import lombok.Data;
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;
}

```

### 4，IDEA快捷键

```
alt+enter	自动导入需要的包
ctrl+alt+o	去除无用的包
```



## 3，计划

#### 2023-01-09

- [x] SpringBoot框架搭建

- [x] Vue2集成ElementUI

#### 2023-01-10

- [x] Vue后台主体框架搭建
- [x] Vue后台整体布局完善
- [x] Vue页面主体布局完善

#### 2023-01-11

- [x] SpringBoot集成Mybatis实现数据查询
- [x] SpringBoot实现增删改查
- [ ] SpringBoot实现分页查询

#### 2023-01-12

- [ ] SpringBoot集成Mybatis-Plus和SwaggerUI

​	

# Getting Started

## Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.7/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.7/maven-plugin/reference/html/#build-image)
* [MyBatis Framework](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.7/reference/htmlsingle/#web)

## Guides
The following guides illustrate how to use some features concretely:

* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [MyBatis Quick Start](https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)







