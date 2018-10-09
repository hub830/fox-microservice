package top.lemna.user.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.baidu.fsg.uid.UidGenerator;
import lombok.RequiredArgsConstructor;
import top.lemna.user.persistence.entity.AddressBook;
import top.lemna.user.persistence.repository.AddressBookRepository;
import top.lemna.user.persistence.repository.UserRepository;
import top.lemna.user.persistence.service.base.BaseService;

/**
 * 订单管理.
 * 
 * @author hu
 * 
 */
@Service
@SuppressWarnings("unused")
@RequiredArgsConstructor(onConstructor = @__(@Autowired)) 
public class AddressBookService extends BaseService<AddressBook>{

  private final AddressBookRepository repository;


}
