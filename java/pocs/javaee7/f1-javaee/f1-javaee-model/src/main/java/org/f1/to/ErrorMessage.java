/**
 * Copyright (c) 2014, Cloudec.
 * All rights reserved.
 */
package org.f1.to;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
@XmlRootElement
public class ErrorMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codeError;
    private String message;
    private Map<String, String> messages;

    public ErrorMessage() {
        super();
    }

    public ErrorMessage(String codeError, String message) {
        super();
        this.codeError = codeError;
        this.message = message;
    }

    public ErrorMessage(String codeError, Map<String, String> messages) {
        super();
        this.codeError = codeError;
        this.messages = messages;
    }

    public String getCodeError() {
        return codeError;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, String> getMessages() {
        return messages;
    }

    public void setCodeError(String codeError) {
        this.codeError = codeError;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessages(Map<String, String> messages) {
        this.messages = messages;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (codeError == null ? 0 : codeError.hashCode());
        result = prime * result + (message == null ? 0 : message.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ErrorMessage other = (ErrorMessage) obj;
        if (codeError == null) {
            if (other.codeError != null) {
                return false;
            }
        } else if (!codeError.equals(other.codeError)) {
            return false;
        }
        if (message == null) {
            if (other.message != null) {
                return false;
            }
        } else if (!message.equals(other.message)) {
            return false;
        }
        return true;
    }

}
