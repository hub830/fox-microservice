package top.lemna.user.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import top.lemna.user.persistence.entity.AddressBook;
import top.lemna.user.persistence.entity.User;
import top.lemna.user.persistence.repository.AddressBookRepository;
import top.lemna.user.persistence.service.base.BaseService;

/**
 * 地址簿管理.
 * 
 * @author hu
 * 
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddressBookService extends BaseService<AddressBook> {

  private final AddressBookRepository repository;


  public AddressBook findByUser(User user) {
    return repository.findByUser(user);
  }

  public AddressBook findByUser(Long userId) {
    return repository.findByUserId(userId);
  }

}
