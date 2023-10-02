package pres.atbabie.boot3.ssm.mapper;

import org.apache.ibatis.annotations.Param;
import pres.atbabie.boot3.ssm.bean.UserDetail;

public interface UserMapper {

    /**
     * 推荐：
     *   1.每个方法都在Mapper文件中有一个sql标签对应
     *   2.所有参数都应该用@Param进行签名，以后使用指定名字在SQL中取值
     * @param id
     * @return
     */
    public UserDetail getUserById(@Param("id") Long id);
}
