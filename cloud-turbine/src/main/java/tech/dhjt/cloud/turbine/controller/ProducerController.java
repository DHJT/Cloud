package tech.dhjt.cloud.turbine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.dhjt.cloud.turbine.service.SendService;


@RestController
public class ProducerController {

	@Autowired
    private SendService sendService;

    @RequestMapping("/send/{msg}")
    public boolean send(@PathVariable("msg") String msg){
        sendService.sendMsg(msg);
        return true;
    }

}
