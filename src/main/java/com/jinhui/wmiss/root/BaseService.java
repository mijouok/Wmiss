package com.jinhui.wmiss.root;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;


import com.jinhui.entity.common.BaseEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * DESCRIPTION_OF_YOUR_CLASS
 *
 * @author zhoumi (mizhouok@gmail.com)
 */
@Service
@Slf4j
public class BaseService<X extends BaseEntity> {
    public void auditEntity(X obj) {
        obj.setCreatedBy("admin");
        obj.setUpdatedBy("admin");
        obj.setCreatedTime(new Date());
        obj.setUpdatedTime(new Date());
    }

    public void auditEntity(X obj, boolean update) {
        if (update) {
            obj.setUpdatedBy("admin");
            obj.setUpdatedTime(new Date());
            return;
        }
        auditEntity(obj);
    }
}
