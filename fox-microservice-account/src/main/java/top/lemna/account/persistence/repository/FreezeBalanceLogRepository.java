package top.lemna.account.persistence.repository;

import org.springframework.stereotype.Repository;

import top.lemna.account.persistence.entity.FreezeBalanceLog;
import top.lemna.account.persistence.repository.base.BaseRepository;

@Repository
public interface FreezeBalanceLogRepository extends BaseRepository<FreezeBalanceLog, Long> 
{
}