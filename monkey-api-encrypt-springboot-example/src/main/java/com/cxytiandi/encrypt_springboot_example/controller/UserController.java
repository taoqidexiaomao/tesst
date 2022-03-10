package com.cxytiandi.encrypt_springboot_example.controller;

import com.cxytiandi.encrypt.springboot.annotation.Decrypt;
import com.cxytiandi.encrypt.springboot.annotation.Encrypt;
import com.cxytiandi.encrypt_springboot_example.dto.UserDto;
import com.cxytiandi.encrypt_springboot_example.dto.UserXmlDto;
import com.cxytiandi.encrypt_springboot_example.entity.SensitiveInformation;
import com.cxytiandi.encrypt_springboot_example.util.JsonResult;
import com.cxytiandi.encrypt_springboot_example.util.ResultTool;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

	@GetMapping("tests")
	@Encrypt
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
	//@Encrypt
	@Decrypt(decyptParam = "age,name")
	@GetMapping("/encryptStr")
	public String encryptStr(String name) {
		System.out.println(name);
		return "加密字符串";
	}


	@PostMapping("/encryptStr")
	public String encryptStr2(String name) {
		System.out.println(name);
		return "加密字符串";
	}
	
	@Encrypt
	@GetMapping("/encryptEntity")
	public UserDto encryptEntity() {
		UserDto dto = new UserDto();
		dto.setId(1);
		dto.setName("加密实体对象");
		return dto;
	}

	@Encrypt
	@GetMapping("/encryptEntity2/{id}")
	public UserDto encryptEntity2(@PathVariable int id) {
		UserDto dto = new UserDto();
		dto.setId(id);
		dto.setName("加密实体对象");
		return dto;
	}
	
	@Encrypt
	@Decrypt
	//@DecryptIgnore
	//@EncryptIgnore
	@PostMapping("/save")
	public UserDto save(@RequestBody UserDto dto) {
		System.err.println(dto.getId() + "\t" + dto.getName());
		return dto;
	}

	@Decrypt
	@PostMapping("/save/{id}")
	public UserDto save(@RequestBody UserDto dto, @PathVariable int id) {
		System.err.println(dto.getId() + "\t" + dto.getName());
		return dto;
	}

	@Encrypt
	@GetMapping("/save/{id}")
	public UserDto getUser(@PathVariable int id) {
		UserDto dto = new UserDto();
		dto.setId(id);
		dto.setName("加密实体对象");
		return dto;
	}

	
	@RequestMapping(value="encryptEntityXml",produces= {MediaType.APPLICATION_XML_VALUE})
	public UserXmlDto encryptEntityXml() {
		UserXmlDto dto = new UserXmlDto();
		dto.setId(1);
		dto.setName("加密实体对象XML");
		return dto;
	}
	
	@RequestMapping(value="decryptEntityXml",consumes = {MediaType.APPLICATION_XML_VALUE})
	public String decryptEntityXml(@RequestBody UserXmlDto dto) {
		System.err.println(dto.getId() + "\t" + dto.getName());
		return dto.getName();
	}
	
}
