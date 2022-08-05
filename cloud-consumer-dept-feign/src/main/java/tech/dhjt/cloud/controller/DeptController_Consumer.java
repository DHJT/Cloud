package tech.dhjt.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import tech.dhjt.cloud.entity.Dept;
import tech.dhjt.cloud.service.DeptClientService;

@RestController
public class DeptController_Consumer {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient webClient;

	@Autowired
	private DeptClientService service;

	@GetMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
//		webClient.get().uri(uri)
//		restTemplate.getForObject(url, responseType)
		return this.service.get(id);
	}

	@GetMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		return this.service.list();
	}

	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		return this.service.add(dept);
	}
}
