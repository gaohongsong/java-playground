package feichai.mybatis.entity.mapper;

import feichai.mybatis.entity.TMyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author gaomugong
* @description 针对表【t_my_user】的数据库操作Mapper
* @createDate 2023-04-08 00:48:04
* @Entity feichai.mybatis.entity.MyUser
*/
@Mapper
public interface MyUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TMyUser record);

    int insertSelective(TMyUser record);

    TMyUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TMyUser record);

    int updateByPrimaryKey(TMyUser record);

    TMyUser findByUsername(@Param("username") String username);
}
