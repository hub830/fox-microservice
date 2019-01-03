package top.lemna.user.persistence.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import top.lemna.user.persistence.entity.Address;
import top.lemna.user.persistence.entity.AddressBook;
import top.lemna.user.persistence.repository.AddressBookRepository;
import top.lemna.user.persistence.service.base.BaseService;

/**
 * 订单管理.
 * 
 * @author hu
 * 
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddressBookService extends BaseService<AddressBook> {

  private final AddressBookRepository repository;


  public AddressBook findByUserNo(Long userNo) {
    return repository.findByUserNo(userNo);
  }

  public Address findByUserNoAndAddressNo(Long userNo, Long addressNo) {
    AddressBook book = findByUserNo(userNo);
    List<Address> list = book.getAddress();
    Address address = null;
    for (Address a : list) {
      if (a.getAddressNo() == addressNo) {
        address = a;
      }
    }
    return address;
  }
}
