package top.lemna.user.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import lombok.extern.slf4j.Slf4j;
import top.lemna.user.TestUserApplication;

/**
 * Oauth 密码登录模式
 * 
 * @author mux
 *
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = TestUserApplication.class)
public class ValidateCodeLoginTest {

  @Autowired
  TestRestTemplate restTemplate;

  @Before
  public void setup() {

  }

  @Test
  public void testSendValidateCode() {
    //
    HttpHeaders headers = new HttpHeaders();

    headers.add("deviceId", "007");
    MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();// 参数放入一个map中，restTemplate不能用hashMap
    // 将请求参数放入map中
    HttpEntity<MultiValueMap<String, String>> request =
        new HttpEntity<MultiValueMap<String, String>>(param, headers);



    ResponseEntity<String> response =
        restTemplate.exchange("/code/image", HttpMethod.GET, request, String.class);
    log.info("--------------------- status:{}", response.getStatusCodeValue());
  }

  @Test
  public void testValidateCodeLogin() {

    HttpHeaders headers = new HttpHeaders();
    headers.add("deviceId", "007");
    headers.add("Authorization", "Basic Zm94OmZveHNlY3JldA=="); // clientId:clientSecret Base64编码
    MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
    param.add("username", "13800138000");
    param.add("password", "123456");
    param.add("imageCode", "1111");

    HttpEntity<MultiValueMap<String, String>> request =
        new HttpEntity<MultiValueMap<String, String>>(param, headers);


    ResponseEntity<String> response = restTemplate.withBasicAuth("fox", "foxsecret")
        .postForEntity("/authentication/form", request, String.class);

    log.info("--------------------- responseEntity:{}", response.getBody());
  }

  @Test
  public void testLogin() {
    testSendValidateCode();
    testValidateCodeLogin();
  }

}
