package top.lemna.account.persistence.repository;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import top.lemna.account.persistence.entity.Account;
import top.lemna.account.persistence.repository.base.BaseRepository;


@Repository
public interface AccountRepository
    extends BaseRepository<Account, Long>  { 
  @Lock(value = LockModeType.WRITE)
  @Query(value = "select t from Account t where t.id = :id ")  
  Optional<Account> findByIdForUpdate(Long id);
  
  Optional<Account> findByAccountName(String accountName);
}
