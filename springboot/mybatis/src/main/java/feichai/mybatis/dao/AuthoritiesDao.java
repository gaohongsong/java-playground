package feichai.mybatis.dao;

import feichai.mybatis.model.Authority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface AuthoritiesDao {
    @Select("select a.* from t_authority a left join my_user_authority mua on a.id = mua.ref_authority_id " +
            "where mua.ref_my_user_id=#{userId}")
    @ResultType(Set.class)
    Set<Authority> findByUserId(@Param("userId") Integer userId);
}
