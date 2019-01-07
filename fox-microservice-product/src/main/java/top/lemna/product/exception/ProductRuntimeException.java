package top.lemna.product.exception;

import top.lemna.core.utils.StringFormatUtil;

public class ProductRuntimeException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  
  public ProductRuntimeException() {
    super("产品模块异常");
  }
  
  public ProductRuntimeException(String message) {
    super(message);
  }

  protected static String messageFormat(String message, Object... args) {
    return StringFormatUtil.format(message, args);
  }
}
