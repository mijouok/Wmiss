package com.jinhui.wmiss.root;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinhui.entity.Document;
import com.jinhui.pojo.R;
import com.jinhui.wmiss.dao.BabyDao;


/**
 * DESCRIPTION_OF_YOUR_CLASS
 *
 * @author zhoumi (mizhouok@gmail.com)
 */
@Service
public class BabyService extends BaseService<Document>{

    @Autowired
    private BabyDao babyDao;

    /**
     * save file to local disk
     * @param filename
     * @param data
     * @return
     */
    public R upload(String filename, String type, byte[] data) {
        if (filename == null || data == null) {
            return R.error("上传文件文件名不正确或者为空。");
        }
        // save file to dao 层
        Document document = new Document();
        document.setName(filename);
        String dataEncoded = Base64.getEncoder().encodeToString(data);
        document.setContent(dataEncoded); // Base
        document.setType(type);
        auditEntity(document, false);
        babyDao.save(document);
        return R.ok();
    }
}
