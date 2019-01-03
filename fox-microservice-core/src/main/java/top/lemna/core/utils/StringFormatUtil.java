package top.lemna.core.utils;

/**
 * 字符串格式化
 * 
 * @author wull
 */
public class StringFormatUtil {


  public static String format(String str, Object... args) {
    for (int i = 0; i < args.length; i++) {
      str = str.replaceFirst("\\{\\}", String.valueOf(args[i]));
    }
    return str;
  }

}
