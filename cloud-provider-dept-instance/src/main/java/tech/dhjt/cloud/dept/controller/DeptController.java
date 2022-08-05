package tech.dhjt.cloud.dept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import tech.dhjt.cloud.dept.service.DeptService;
import tech.dhjt.cloud.entity.Dept;

@RestController
public class DeptController {

	@Autowired
	private DeptService service;

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return service.add(dept);
	}

	@GetMapping(value = "/dept/get/{id}")
	@HystrixCommand(fallbackMethod = "findByIdFallback")
	public Dept get(@PathVariable("id") Long id) {
		if (id == null || id <= 0) {
			throw new RuntimeException("Parameter id is invalid.");
		}
		Dept dept = service.get(id);
		return dept;
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list() {
		List<Dept> list = service.list();
		return list;
	}

	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery() {
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("CLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}

	public Dept findByIdFallback(@PathVariable("id") Long id) {
//        return "error" + LocalDateTime.now().toString();
        return new Dept(id, "error", "---");
    }
}
