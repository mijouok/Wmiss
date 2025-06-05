package com.jinhui.wmiss.controller;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jinhui.pojo.R;
import com.jinhui.wmiss.controller.base.BaseController;
import com.jinhui.wmiss.root.BabyService;

// UserController.java
@RestController
@RequestMapping("/api/v1/main/baby")
public class BabyController implements BaseController {

    @Autowired
    private BabyService babyService;
//    private List<User> users = new ArrayList<>();

//    @GetMapping
//    public List<User> getUsers() {// first let's use dummy data
//        User user = new User(); user.setEmail("abc@jinhui");user.setName("jinhui");
//        users.add(user);
//        return users;
//    }
//
//    @PostMapping
//    public User addUser(@RequestBody User user) {
//        users.add(user);
//        return user;
//    }

    @RequestMapping(path="/uploadThumbnail", produces = "application/json", consumes = "multipart/form-data", method= RequestMethod.POST)
    @Override
    public R uploadThumbnail(@RequestBody MultipartFile file) {
        String oriFilename = file.getOriginalFilename();
        if (StringUtils.isBlank(oriFilename) || !oriFilename.contains(".")) {
            return R.error("非法的文件名！");
        }
        String filename = oriFilename.substring(0, oriFilename.lastIndexOf("."));
        int index = oriFilename.lastIndexOf(".");
        String suffix = oriFilename.substring(oriFilename.lastIndexOf("."));
        byte[] data = null;
        try {
            data = file.getBytes(); // file data
        } catch (IOException e) {
            throw new RuntimeException(e); // 自定义异常处理类
        }
        if (data == null || data.length == 0) {
            return R.error("上传图片大小：0KB。请重新上传。");
        }
        R r = babyService.upload(filename, suffix, data);
        if (r.getCode() != 200) return r;
        return R.ok();
    }

    @Override
    public R download() {
        return null;
    }
}

