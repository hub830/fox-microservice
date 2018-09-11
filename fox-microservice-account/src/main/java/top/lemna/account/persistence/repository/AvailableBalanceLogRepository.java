package top.lemna.account.persistence.repository;

import org.springframework.stereotype.Repository;

import top.lemna.account.persistence.entity.AvailableBalanceLog;
import top.lemna.account.persistence.repository.base.BaseRepository;

@Repository
public interface AvailableBalanceLogRepository extends BaseRepository<AvailableBalanceLog, Long> 
{
}