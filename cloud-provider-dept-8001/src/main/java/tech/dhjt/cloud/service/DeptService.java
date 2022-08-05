package tech.dhjt.cloud.service;

import java.util.List;

import tech.dhjt.cloud.entity.Dept;

public interface DeptService {

	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
