package feichai.mybatis.entity.mapper;

import feichai.mybatis.entity.TAuthority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
* @author gaomugong
* @description 针对表【t_authority】的数据库操作Mapper
* @createDate 2023-04-08 00:48:04
* @Entity feichai.mybatis.entity.Authority
*/
@Mapper
public interface AuthorityMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TAuthority record);

    int insertSelective(TAuthority record);

    TAuthority selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TAuthority record);

    int updateByPrimaryKey(TAuthority record);

    Set<TAuthority> findByUserId(@Param("userId") Long userId);
}
