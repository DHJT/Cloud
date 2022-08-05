package tech.dhjt.cloud.dept.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.dhjt.cloud.dept.mapper.DeptMapper;
import tech.dhjt.cloud.dept.service.DeptService;
import tech.dhjt.cloud.entity.Dept;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper deptMapper;

	@Override
	public boolean add(Dept dept) {
		return deptMapper.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
	    try {

	        Dept dept = deptMapper.findById(id);
	        return dept;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
	    return null;
	}

	@Override
	public List<Dept> list() {
		return deptMapper.findAll();
	}

}
