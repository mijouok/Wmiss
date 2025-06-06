package com.jinhui.pojo;

import java.util.List;

import org.springframework.util.CollectionUtils;

import lombok.Data;
@Data
public class DeepSeekDto {
    private List<DeepSeekChoiseDto> choices;

    public String getContent() {
        if (CollectionUtils.isEmpty(choices)) {
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
