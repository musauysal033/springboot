package com.example.common.exception;

import com.example.common.exception.MetaMessage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResponseHeader {
    private String returnCode="";
    private String returnMessage="";
    private String returnTitle;
    private String severity;

    private List<MetaMessage> msgList;
}