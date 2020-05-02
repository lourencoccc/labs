package org.f1.exception;

public class F1Exception extends Exception {

    private static final long serialVersionUID = 2824331895952700739L;

    private int status = 500;

    public F1Exception() {
        super();
    }

    public F1Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public F1Exception(String message, int status, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public F1Exception(String message) {
        super(message);
    }

    public F1Exception(int satatus) {
        super("");
        this.status = satatus;
    }

    public F1Exception(String message, int status) {
        super(message);
        this.status = status;
    }

    public F1Exception(Throwable cause) {
        super(cause);
    }

    public F1Exception(Throwable cause, int status) {
        super(cause);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}
