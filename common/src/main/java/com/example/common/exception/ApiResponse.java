package com.example.common.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ApiResponse  {

    /*
     * severity?: 'success' | 'info' | 'warn' | 'error',
     * summary?: any;
     * detail?:	 any;
     * content?: any;
     * closable?: boolean;
     * sticky?: boolean;
     * life?: number;
     * exceptionId?: any;
     */
    @JsonProperty("severity")
    private String severity;

    @JsonProperty("summary")
    private String summary;

    @JsonProperty("detail")
    private String detail;

    @JsonProperty("content")
    private String content;

    @JsonProperty("closable")
    private boolean closable;

    @JsonProperty("sticky")
    private boolean sticky;

    @JsonProperty("life")
    private int life;

    @JsonProperty("status")
    private HttpStatus status;

    @JsonProperty("data")
    private Object data;

}
