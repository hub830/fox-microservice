package top.lemna.product.exception;

/**
 * 产品订单创建异常
 * 
 * @author mux
 *
 */
public class ProductOrderCreateEnoughException extends ProductRuntimeException {

  private static final long serialVersionUID = 1L;

  public ProductOrderCreateEnoughException(String message) {
    super(message);
  }
}
