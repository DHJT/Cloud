package tech.dhjt.cloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean {

	/**
     * @description: 实例化ribbon使用的RestTemplate
     * Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端 负载均衡的工具。
     * @return
     */
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	@LoadBalanced
	public WebClient webClient() {
	    return WebClient.create();
	}

	@Bean
	public IRule myRule() {
		// Ribbon有7中可选的负载均衡策略：RomdomRule：随机策略，RoundRobbinRule（默认）：轮询策略，RetryRule：重试策略，
		// BestAvailableRule：最低并发策略，AvailabilityFilteringRule：可用过滤策略，ResponseTimeWeightedRule：响应时间加权策略，
		// ZoneAvoidanceRule：区域权衡策略。
		return new RetryRule();
	}
}