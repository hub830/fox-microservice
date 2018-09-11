package top.lemna.account.persistence.repository;


import org.springframework.stereotype.Repository;

import top.lemna.account.persistence.entity.Order;
import top.lemna.account.persistence.repository.base.BaseRepository;

@Repository
public interface OrderRepository extends BaseRepository<Order, Long> 
{

    public Order findByAccountIdAndMerchantOrderNo(Long accountId, String merchantOrderNo);
}