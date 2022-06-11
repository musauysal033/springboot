package com.example.common.exception;



public class ObjectResponseException extends RuntimeException{
    private static final long serialVersionUID = -5374908280684912503L;

    private Object response;
    private ResponseHeader responseHeader;

    public ObjectResponseException() {
        super();
    }

    public ObjectResponseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectResponseException(String message) {
        super(message);
    }

    public ObjectResponseException(Throwable cause) {
        super(cause);
    }

    public ObjectResponseException(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public ObjectResponseException(Object reponse, ResponseHeader responseHeader) {
        this.response = reponse;
        this.responseHeader = responseHeader;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }


}
