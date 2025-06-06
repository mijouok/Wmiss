package com.jinhui.wmiss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jinhui.entity.Document;


/**
 * DESCRIPTION_OF_YOUR_CLASS
 *
 * @author zhoumi (mizhouok@gmail.com)
 */
public interface BabyDao extends JpaRepository<Document, Long> {
}
