package top.lemna.account.persistence.repository;

import org.springframework.stereotype.Repository;

import top.lemna.account.persistence.entity.WithDraw;
import top.lemna.account.persistence.repository.base.BaseRepository;


@Repository
public interface  WithDrawRepository extends BaseRepository<WithDraw, Long>{


}