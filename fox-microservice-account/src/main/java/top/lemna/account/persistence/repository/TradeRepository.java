package top.lemna.account.persistence.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import top.lemna.account.persistence.entity.Trade;
import top.lemna.account.persistence.repository.base.BaseRepository;
import top.lemna.core.enums.account.BillStatus;
import top.lemna.core.enums.account.BillType;


@Repository
public interface TradeRepository extends BaseRepository<Trade, Long> {

  Optional<Trade> findByIdAndTypeAndStatus(Long id, BillType type, BillStatus status);

  // Optional<Trade> findByAccountIdAndOrderIdAndType(Long accountId, Long orderId, BillType type);
}
