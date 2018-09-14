package top.lemna.order.persistence.entity.base;

import org.springframework.data.annotation.Id;


public abstract class AbstractDocument  extends TimeDocument {

  /** 流水号 */
  @Id
  private Long  id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }

    if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
      return false;
    }

    AbstractDocument  that = (AbstractDocument ) obj;

    return this.id.equals(that.getId());
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return id == null ? 0 : id.hashCode();
  }

}
