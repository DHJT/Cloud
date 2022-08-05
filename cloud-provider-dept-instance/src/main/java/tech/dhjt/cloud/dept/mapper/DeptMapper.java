package tech.dhjt.cloud.dept.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import tech.dhjt.cloud.entity.Dept;

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

	public boolean addDept(Dept dept);

	public Dept findById(Long deptNo);

	public List<Dept> findAll();

}
