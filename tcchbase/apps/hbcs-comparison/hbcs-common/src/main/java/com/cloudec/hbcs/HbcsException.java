package com.cloudec.hbcs;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-03-01
 */
public class HbcsException extends RuntimeException {

  private static final long serialVersionUID = -3561812142874429954L;

  public HbcsException() {
    super();
  }

  public HbcsException(String message) {
    super(message);
  }

  public HbcsException(String message, Throwable cause) {
    super(message, cause);
  }
}
