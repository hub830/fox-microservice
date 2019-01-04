package top.lemna.user.persistence.repository;


import org.springframework.stereotype.Repository;
import top.lemna.user.persistence.entity.Address;
import top.lemna.user.persistence.repository.base.BaseRepository;

@Repository
public interface AddressRepository extends BaseRepository<Address, Long> {

}
