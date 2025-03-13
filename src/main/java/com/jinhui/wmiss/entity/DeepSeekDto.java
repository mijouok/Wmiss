package com.jinhui.wmiss.entity;

import lombok.Data;
//import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
@Data
public class DeepSeekDto {
    private List<DeepSeekChoiseDto> choices;

    public String getContent() {
        if (org.springframework.util.CollectionUtils.isEmpty(choices)) {
            return "";
        }
        if (this.choices.get(0).getMessage() ==null) {return "";}
//        String content = this.choices.get(0).getMessage().getContent();
        return this.choices.get(0).getMessage().getContent();
    }

    public String getReasonContent() {
        if (CollectionUtils.isEmpty(choices)) {return "";}
        if (this.choices.get(0).getMessage() ==null) {return "";}
        return this.choices.get(0).getMessage().getReasoning_content();
    }
}
