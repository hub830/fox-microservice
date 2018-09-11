package top.lemna.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
//@RefreshScope
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);


    @Value("${spring.datasource.password:123456789}")
    private  String db;


    @RequestMapping(value = "/test1")
    @ResponseBody
    public String test2() {
        log.info("--------------------------------------------------------------------------------");
        log.info(db);
        log.info("--------------------------------------------------------------------------------");
        return db;
    }
}