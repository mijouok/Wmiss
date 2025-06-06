package com.jinhui.pojo;

import lombok.*;

//@Data
@Data
public class Message {
    private String role;
    private String content;
    // @JsonProperty("reasoning_content")
    String reasoning_content;
    // @JsonProperty("finish_reason")
    String finish_reason;


}
