package com.example.common.exception;

import com.example.common.exception.ApiResponse;
import com.example.common.exception.SeverityConstant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class ApiSuccess extends ApiResponse {

    public ApiSuccess(String summary, Object responseObject) {
        super();
        setSummary(summary);
        setData(responseObject);
        setStatus(HttpStatus.OK);
        setSeverity(SeverityConstant.SUCCESS);
        setClosable(true);
        setLife(5000);
    }

    public ApiSuccess() {
        setSeverity(SeverityConstant.SUCCESS);
        setClosable(true);
        setLife(5000);
    }

}
