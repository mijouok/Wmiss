package com.jinhui.wmiss.controller.base;

import org.springframework.web.multipart.MultipartFile;

import com.jinhui.pojo.R;


/**
 * DESCRIPTION_OF_YOUR_CLASS
 *
 * @author zhoumi (mizhouok@gmail.com)
 */
public interface BaseController {
    R uploadThumbnail(MultipartFile file);

    R download();
}
