package top.lemna.account.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("pay/withdrawbill")
public class WithDrawBILLController {

    @RequestMapping(value = "/test1")
    public String test2() {
        log.info("test");
        return "test";
    }
}