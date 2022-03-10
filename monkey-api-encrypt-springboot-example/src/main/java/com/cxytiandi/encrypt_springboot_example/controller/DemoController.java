package com.cxytiandi.encrypt_springboot_example.controller;

import com.cxytiandi.encrypt.springboot.annotation.Encrypt;
import com.cxytiandi.encrypt_springboot_example.entity.SensitiveInformation;
import com.cxytiandi.encrypt_springboot_example.entity.User;
import com.cxytiandi.encrypt_springboot_example.util.JsonResult;
import com.cxytiandi.encrypt_springboot_example.util.ResultTool;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class DemoController {

    @GetMapping("test")
    public JsonResult<List<SensitiveInformation>> test() {
        List<SensitiveInformation> list = new ArrayList<>();
        SensitiveInformation sensitiveInformation = new SensitiveInformation();
        sensitiveInformation
                .setUserid("n10001")
                .setChineseName("   ")
                .setAddress("北京市九宫")
                .setIdNumber("13023928819028321X")
                .setEmail("baidu@163.com")
                .setBankCard("131231321312314567")
                .setLandlineNumber("0310-68123987")
                .setPhoneNumber("13042928312")
                .setPassword("meTooYu")
                .setLicensePlate("京A888888");
        SensitiveInformation sensitiveInformationTwo = new SensitiveInformation();
        sensitiveInformationTwo
                .setUserid("n10002")
                .setChineseName("张志伟")
                .setAddress("北京市超标")
                .setIdNumber("23023928819028321X")
                .setEmail("360@163.com");
        list.add(sensitiveInformation);
        list.add(sensitiveInformationTwo);
        list.add(new SensitiveInformation().setUserid("n10003")
                .setChineseName("李家村"));
        return ResultTool.success(list);
    }
    @GetMapping("user")
    public JsonResult<List<User>> user() {
        List<User> list=new ArrayList<>();
        list.add(new User().setAge(10).setName("张三").setSex(1));
        return ResultTool.success(list);
    }
    @PostMapping("decrypt")
    public JsonResult<List<User>> decrypt(@RequestBody User user) {
        List<User> list=new ArrayList<>();
        list.add(user);
        return ResultTool.success(list);
    }
    @GetMapping("decrypts")
    public JsonResult<List<User>> decrypts(User user) {
        List<User> list=new ArrayList<>();
        list.add(user);
        return ResultTool.success(list);
    }
}
