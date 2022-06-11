package com.example.common.exception;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.util.ObjectUtils;
import com.example.common.exception.MetaMessage.SEVERITY;



public class ErrorMessageUtil {

    public static void checkBusinessException(MetaMessageUtil metaMessageUtil) throws BusinessException {
        if (!metaMessageUtil.isEmpty()) {
            throw new BusinessException(metaMessageUtil.getMetaMessageList());
        }
    }
    public static void checkObjectResponseException(Object object, MetaMessageUtil metaMessageUtil, String severity) {
        ResponseHeader responseHeader = new ResponseHeader();
        if (!metaMessageUtil.isEmpty()) {
            responseHeader.setMsgList(metaMessageUtil.getMetaMessageList());
            responseHeader.setSeverity(severity);
        }
        throw new ObjectResponseException(object, responseHeader);
    }

    public static void createErrorMessage(String errorCode, String message, SEVERITY severity) {
        MetaMessageUtil metaMessageUtil = new MetaMessageUtil();
        if (ObjectUtils.isEmpty(severity)) {
            severity = SEVERITY.SEVERITY_ERROR;
        }
        metaMessageUtil.addMetaMessage(errorCode, message, severity.getDescription());
        checkBusinessException(metaMessageUtil);
    }

    public static void createErrorMessage(Object object, String errorCode, String message, SEVERITY severity) {
        MetaMessageUtil metaMessageUtil = new MetaMessageUtil();
        if (ObjectUtils.isEmpty(severity)) {
            severity = SEVERITY.SEVERITY_ERROR;
        }
        metaMessageUtil.addMetaMessage(errorCode, message, severity.getDescription());
        ResponseHeader responseHeader = new ResponseHeader();
        if (!metaMessageUtil.isEmpty()) {
            responseHeader.setMsgList(metaMessageUtil.getMetaMessageList());
            responseHeader.setSeverity(severity.getDescription());
        }
        checkObjectResponseException(object, metaMessageUtil, severity.getDescription());
    }

    public static void checkNullOrEmptyList(List<?> e, String listType) {
        MetaMessageUtil metaMessageUtil = new MetaMessageUtil();
        if (CollectionUtils.isEmpty(e)) {
            metaMessageUtil.addMetaMessage("40001", ObjectUtils.isEmpty(listType) ? "İlgili listeye ait kayıt bulunmamaktadır." : (listType + " listesine ait kayıt bulunmamaktadır."), "INFO");
        }
        checkBusinessException(metaMessageUtil);
    }



    public static void createErrorMessages(String errorCode, List<Object> messages, SEVERITY severity) {
        MetaMessageUtil metaMessageUtil = new MetaMessageUtil();
        if (ObjectUtils.isEmpty(severity)) {
            severity = SEVERITY.SEVERITY_ERROR;
        }
        if( CollectionUtils.isNotEmpty(messages) )
            for( Object message : messages )
                metaMessageUtil.addMetaMessage(errorCode, (String)message, severity.getDescription());

        checkBusinessException(metaMessageUtil);
    }

}
