package com.jinhui.wmissimage.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jinhui.pojo.R;
import com.jinhui.pojo.image.ImageDto;

/**
 * DESCRIPTION_OF_YOUR_CLASS
 *
 * @author zhoumi (mizhouok@gmail.com)
 */
@RestController
@RequestMapping("/api/v1/image")
public class ImageController {

    @RequestMapping(path = "/getImgUrl", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
    public R getImageUrl(@RequestBody ImageDto imageDto){
    return null;
    }

    @RequestMapping(path = "/download", produces = "application/json", consumes = "application/json", method = RequestMethod.GET)
    public R download(@RequestParam(name = "url") String url) {
        return R.ok();
    }
}
