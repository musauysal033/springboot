package com.example.common.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MetaMessageUtil {


    private List<MetaMessage> metaMessageList;

    public void addMetaMessage(String code, String message, String severity) {
        MetaMessage metaMessage = new MetaMessage(code, message, severity);
        if (metaMessageList == null) {
            metaMessageList = new ArrayList<>();
        }
        metaMessageList.add(metaMessage);
    }


    public void addMetaMessageError(String message) {
        MetaMessage metaMessage = new MetaMessage("400", message, SeverityConstant.ERROR);
        if (metaMessageList == null) {
            metaMessageList = new ArrayList<>();
        }
        metaMessageList.add(metaMessage);
    }

    public void addMetaMessageWarning( String message) {
        MetaMessage metaMessage = new MetaMessage("400", message, SeverityConstant.WARNING);
        if (metaMessageList == null) {
            metaMessageList = new ArrayList<>();
        }
        metaMessageList.add(metaMessage);
    }

    public void addMetaMessageInfo(String message) {
        MetaMessage metaMessage = new MetaMessage("200", message, SeverityConstant.INFO);
        if (metaMessageList == null) {
            metaMessageList = new ArrayList<>();
        }
        metaMessageList.add(metaMessage);
    }

    public void addMetaMessage(String code, String message, MetaMessage.SEVERITY severity) {
        MetaMessage metaMessage = new MetaMessage(code, message, severity.getDescription());
        if (metaMessageList == null) {
            metaMessageList = new ArrayList<>();
        }
        metaMessageList.add(metaMessage);
    }

    public void addMetaMessage(MetaMessage metaMessage) {
        if (metaMessageList == null) {
            metaMessageList = new ArrayList<>();
        }
        metaMessageList.add(metaMessage);
    }

    public Boolean isEmpty() {
        return metaMessageList == null || metaMessageList.isEmpty();
    }

    public List<MetaMessage> getMetaMessageList() {
        return metaMessageList;
    }

    public void setMetaMessageList(List<MetaMessage> metaMessageList) {
        this.metaMessageList = metaMessageList;
    }

    public static MetaMessage createMetaMessage(String code, String message, String severity) {
        MetaMessage metaMessage = new MetaMessage(code, message, severity);
        return metaMessage;
    }
}
