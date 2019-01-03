package top.lemna.core.exception;

import java.util.Map;

public class RecordAlreadyExistException extends RuntimeException {
  private static final long serialVersionUID = 5770390658812498742L;

  Map<String, String> params;
  
  public RecordAlreadyExistException(Map<String, String> params) {
    super(format(params));
    this.params = params;
  }

  static String format(Map<String, String> params) {
    StringBuffer sb = new StringBuffer("属性 ");
    params.forEach((k, v) -> sb.append("key:value = " + k + ":" + v));
    sb.append(" 对应的记录已经存在，请校验后重试");
    return sb.toString();
  }
}
