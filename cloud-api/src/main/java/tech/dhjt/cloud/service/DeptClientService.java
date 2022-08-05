package tech.dhjt.cloud.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tech.dhjt.cloud.entity.Dept;

/**
 *
 * @Description: 修改cloud-api工程，根据已经有的DeptClientService接口
 * 新建一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory
 * @author DHJT 2021-04-14 21:48:28.
 */
//@FeignClient(value = "CLOUD-DEPT")
@FeignClient(value = "CLOUD-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") long id);

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list();

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(Dept dept);
}
