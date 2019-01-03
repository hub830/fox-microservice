package top.lemna.product.exception;

import top.lemna.core.utils.StringFormatUtil;

public class ProductCarrierNotExistException extends RuntimeException {
  
  public String getCarrierName() {
    return carrierName;
  }

  public void setCarrierName(String carrierName) {
    this.carrierName = carrierName;
  }

  private static final long serialVersionUID = 6695056254073034007L;
  
  private String carrierName;

  public ProductCarrierNotExistException(String carrierName) {
    super(StringFormatUtil.format("数据库中不存在对应的运营商 carrierName:{}",  carrierName));
    this.carrierName = carrierName;
  }

}
