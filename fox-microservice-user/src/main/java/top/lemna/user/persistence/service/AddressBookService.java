package top.lemna.user.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class AddressBookService extends BaseService<AddressBook>{

	@Autowired
	private AddressBookRepository repository;

	public AddressBookService() {
		super();
	}

}
