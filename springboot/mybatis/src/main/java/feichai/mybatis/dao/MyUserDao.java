package feichai.mybatis.dao;

import feichai.mybatis.model.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyUserDao {
    @Select("select * from t_my_user where username=#{username}")
    MyUser findByUsername(@Param("username") String username);
    void save(MyUser user);
}
