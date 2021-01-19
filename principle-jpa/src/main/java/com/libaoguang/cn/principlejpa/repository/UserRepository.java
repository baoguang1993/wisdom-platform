package com.libaoguang.cn.principlejpa.repository;

import com.libaoguang.cn.principlejpa.entity.BasisDto;
import com.libaoguang.cn.principlejpa.entity.BasisUser;
import com.libaoguang.cn.principlejpa.entity.UserQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<BasisUser, Integer> {

    List<BasisUser> getBasisUserByAge(Integer age);

   // String sql="select buser.user_name userName,dept.name deptName from basis_user buser left join basis_dept dept ON buser.dept_guid=dept.id WHERE buser.user_age=:age";
    @Query(value="${sql}", nativeQuery = true)
    Page<List<Map<String,Object>> > findall(String sql,Integer age, Pageable pageable);

}
