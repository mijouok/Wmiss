package com.jinhui.entity;



import com.jinhui.entity.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DESCRIPTION_OF_YOUR_CLASS
 *
 * @author zhoumi (mizhouok@gmail.com)
 */


@Entity
@Table(name = "document")
@Data
@EqualsAndHashCode(callSuper = false)
public class Document extends BaseEntity {

    private static final String DOCUMENT_ID = "ID";
    private static final String DOCUMENT_NAME = "NAME";
    private static final String DOCUMENT_CONTENT = "CONTENT";
    private static final String DOCUMENT_TYPE = "TYPE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DOCUMENT_ID)
    private Long id;
    @Column(name = DOCUMENT_NAME)
    private String name;
    @Column(name = DOCUMENT_CONTENT)
    private String content;
    @Column(name = DOCUMENT_TYPE)
    private String type;
}
