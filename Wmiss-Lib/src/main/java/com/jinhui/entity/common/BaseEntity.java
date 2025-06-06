package com.jinhui.entity.common;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

/**
 * DESCRIPTION_OF_YOUR_CLASS
 *
 * @author zhoumi (mizhouok@gmail.com)
 */
@Data
@MappedSuperclass
public class BaseEntity implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private static final String CREATED_BY = "CREATED_BY";
    private static final String UPDATED_BY = "UPDATED_BY";
    private static final String CREATED_TIME = "CREATED_AT";
    private static final String UPDATED_TIME = "UPDATED_AT";
    @Column(name = CREATED_BY)
    private String createdBy;
    @Column(name = UPDATED_BY)
    private String updatedBy;
    @Column(name = CREATED_TIME)
    private Date createdTime;
    @Column(name = UPDATED_TIME)
    private Date updatedTime;
}
