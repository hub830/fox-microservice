package top.lemna.account.persistence.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import top.lemna.account.persistence.entity.Recharg;
import top.lemna.account.persistence.repository.base.BaseRepository;

@Repository
public interface RechargRepository extends BaseRepository<Recharg, Long> {
  Optional<Recharg> findByIdAndAccountId(Long id, Long accountId);
}
