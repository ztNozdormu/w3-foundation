## 三种配置方式

1. JCacheManagerCustomizer集成

* 应用配置文件

> #ehcache3缓存 注意使用JCacheManagerCustomizer是没办法选择磁盘储存的因为没办法设置磁盘路径
> spring.cache.type=jcache

* 配置类代码
  ```java
    @Configuration //配置类
    @EnableCaching //开启缓存
    public class CacheConfig {
    @Bean
    public JCacheManagerCustomizer jCacheManagerCustomizer() {
    return cm -> {
    //缓存名称，用于登录token的管理
    cm.createCache("userTokenCache", Eh107Configuration.fromEhcacheCacheConfiguration(
    CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, userTokenCacheInfo.class,
    ResourcePoolsBuilder.newResourcePoolsBuilder()
    .heap(100, EntryUnit.ENTRIES)  // 堆缓存大小为 100 个条目
    .offheap(10, MemoryUnit.MB) // 堆外缓存大小为 10 MB
    )
    .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(10))) // 设置缓存的生存时间为 10 秒
    .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(5))) // 设置缓存的空闲时间为 5 秒
    .build()));
    //其他的缓存就用这个
    cm.createCache("otherCache", Eh107Configuration.fromEhcacheCacheConfiguration(
    CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, userTokenCacheInfo.class,
    ResourcePoolsBuilder.newResourcePoolsBuilder()
    .heap(100, EntryUnit.ENTRIES)  // 堆缓存大小为 100 个条目
    .offheap(10, MemoryUnit.MB) // 堆外缓存大小为 10 MB
    )
    .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(10))) // 设置缓存的生存时间为 10 秒
    .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(5))) // 设置缓存的空闲时间为 5 秒
    .build()));
    }
  ;
    }
    }
   ```  

2. org.ehcache.CacheManage配置

  * 注意事项
   > 使用ehcache自己的API配置是不需要配置application.properties！
   使用ehcache自己的API配置 不能使用springboot自带的缓存注解和API的
  * 配置类
   ``` java
      import com.stc.login.model.userTokenCacheInfo;
      
      import org.ehcache.CacheManager;
      import org.ehcache.config.CacheConfiguration;
      import org.ehcache.config.ResourcePools;
      import org.ehcache.config.builders.CacheConfigurationBuilder;
      import org.ehcache.config.builders.CacheManagerBuilder;
      import org.ehcache.config.builders.ExpiryPolicyBuilder;
      import org.ehcache.config.builders.ResourcePoolsBuilder;
      import org.ehcache.config.units.EntryUnit;
      import org.ehcache.config.units.MemoryUnit;
      
      import org.springframework.cache.annotation.EnableCaching;
      import org.springframework.context.annotation.Bean;
      import org.springframework.context.annotation.Configuration;
      
      import java.time.Duration;
      
      import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManagerBuilder;
      
      
      @Configuration //配置类
      @EnableCaching //开启缓存
      public class CacheConfig {
      
          @Bean
          public CacheManager ehCacheManager() {
              //userTokenCache配置
              CacheConfiguration userTokenCache_cacheConfiguration = CacheConfigurationBuilder
                      .newCacheConfigurationBuilder(String.class, userTokenCacheInfo.class, ResourcePoolsBuilder.newResourcePoolsBuilder()
                              .heap(100, EntryUnit.ENTRIES) // 堆缓存大小为 100 个条目
                              .offheap(10, MemoryUnit.MB) // 堆外缓存大小为 10 MB
                      )
                      .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(10))) // 设置缓存的生存时间为 10 秒
                      .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(5))) // 设置缓存的空闲时间为 5 秒
                      .build();
      
              //otherCache配置
              CacheConfiguration otherCache_cacheConfiguration = CacheConfigurationBuilder
                      .newCacheConfigurationBuilder(String.class, userTokenCacheInfo.class, ResourcePoolsBuilder.newResourcePoolsBuilder()
                              .heap(100, EntryUnit.ENTRIES) // 堆缓存大小为 100 个条目
                              .offheap(10, MemoryUnit.MB) // 堆外缓存大小为 10 MB
                              .disk(100, MemoryUnit.MB,true) //磁盘储存,永久储存
                      )
                      .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(10))) // 设置缓存的生存时间为 10 秒
                      .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(5))) // 设置缓存的空闲时间为 5 秒
                      .build();
      
      
              //7\. 构建
              return newCacheManagerBuilder()
                      .with(CacheManagerBuilder.persistence("D:/ehcacheData"))//磁盘储存路径
                      .withCache("userTokenCache", userTokenCache_cacheConfiguration)
                      .withCache("otherCache",otherCache_cacheConfiguration)
                      .build(true);
          }
   ```

3. XML配置
  * 注意
   > 只有xml配置所有要把xml配置文件的路径设置好，直接把ehcache.xml跟application放在同一个目录下就好了
  * XML配置文件模板
 ```xml
`  <config xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns="http://www.ehcache.org/v3"
          xmlns:jsr107="http://www.ehcache.org/v3/jsr107"
          xsi:schemaLocation="
              http://www.ehcache.org/v3 http://www.ehcache.org/schema/ehcache-core-3.0.xsd
              http://www.ehcache.org/v3/jsr107 http://www.ehcache.org/schema/ehcache-107-ext-3.0.xsd">
    <!--磁盘储存路径-->
      <persistence directory="D:/ehcacheData"/> 
      <!--用于用户登录token的管理-->
      <cache alias="userTokenCache">
          <key-type>java.lang.String</key-type>
          <value-type>com.stc.login.model.userTokenCacheInfo</value-type>
          <!-- 省略 <expiry> 标签 就不过期了 -->
          <expiry>
              <!--缓存的生存时间（TTL）为28800秒-->
              <ttl unit="seconds">28800</ttl>
              <!--缓存的空闲时间（TTI）为20秒 无法同时配置条目的生存时间（TTL）和空闲时间（TTI）-->
              <!--<tti unit="seconds"> 20</tti>-->
          </expiry>
          <resources>
              <!--堆外内存的大小限制为1024MB。-->
              <offheap unit="MB">200</offheap>
          </resources>
      </cache>
      <!--用于otherCache的管理-->
      <cache alias="otherCache">
          <key-type>java.lang.String</key-type>
          <value-type>com.stc.login.model.userTokenCacheInfo</value-type>
          <!-- 省略 <expiry> 标签 就不过期了 -->
          <expiry>
              <!--缓存的生存时间（TTL）为30秒-->
              <ttl unit="seconds">30</ttl>
              <!--缓存的空闲时间（TTI）为20秒 无法同时配置条目的生存时间（TTL）和空闲时间（TTI）-->
              <!--<tti unit="seconds"> 20</tti>-->
          </expiry>
          <resources>
              <!--堆内存的大小限制为2个条目-->
              <heap unit="entries">2</heap>
              <!--堆外内存的大小限制为10MB。-->
              <offheap unit="MB">10</offheap>
              <!--磁盘缓存 persistent属性用于指定磁盘缓存是否持久化-->
              <disk unit="MB" persistent="false">20</disk>
          </resources>
      </cache>
  </config>
```
4. 启动生效注解
> 启动类上加上@EnableCaching开启缓存，