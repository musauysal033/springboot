package com.example.common.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class MetaMessage {

    private String code;
    private String explanation;
    private String severity;

    public enum TYPE {
        TYPE_ERROR,
        TYPE_MESSAGE,
        TYPE_RAW
    };

    public enum SEVERITY {

        SEVERITY_ERROR((short) 1, "SEVERITY_ERROR"),
        SEVERITY_FATAL((short) 2, "SEVERITY_FATAL"),
        SEVERITY_INFO((short) 3, "SEVERITY_INFO"),
        SEVERITY_WARN((short) 4, "SEVERITY_WARN"),
        SEVERITY_UNDEFINED((short) 5, ""),
        SEVERITY_CONFIRM((short) 6, "SEVERITY_CONFIRM");

        private final short id;
        private final String description;

        private SEVERITY(short id, String description) {
            this.id = id;
            this.description = description;
        }

        public short getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }
    };

    public MetaMessage() {

    }

    public MetaMessage(String code, String message, String severity) {
        this.code = code;
        this.explanation = message;
        this.severity = severity;
    }

    public MetaMessage(String code, String severity) {
        this.code = code;
        this.severity = severity;
    }

    public static MetaMessage asMesageFromBundle(String code, String severity) {
        return new MetaMessage(code, severity);
    }

    public static MetaMessage asMesageFromBundle(String code, String message, String severity) {
        return new MetaMessage(code, message, severity);
    }



}
