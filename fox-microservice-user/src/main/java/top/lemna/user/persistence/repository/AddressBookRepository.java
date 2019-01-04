package top.lemna.user.persistence.repository;


import org.springframework.stereotype.Repository;
import top.lemna.user.persistence.entity.AddressBook;
import top.lemna.user.persistence.entity.User;
import top.lemna.user.persistence.repository.base.BaseRepository;

@Repository
public interface AddressBookRepository extends BaseRepository<AddressBook, Long> {

  AddressBook findByUser(User user);

  AddressBook findByUserId(Long userId);

}
