# myblog
SpringBoot搭建自己的个人博客源码

``` java
public interface BaseDao
{
// 根据ID加载实体
T get(Class entityClazz, Serializable id);
// 保存实体
Serializable save(T entity);
// 更新实体
void update(T entity);
// 删除实体
void delete(T entity);
// 获取所有实体
List findAll(Class entityClazz);
// 获取实体总数
long findCount(Class entityClazz);
}
```