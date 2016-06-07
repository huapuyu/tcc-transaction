package org.mengyun.tcctransaction.sample.dubbo.level3.domain.repository;

import org.mengyun.tcctransaction.sample.dubbo.level3.domain.entity.Level3Account;
import org.mengyun.tcctransaction.sample.dubbo.level3.infrastructure.dao.Level3AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by changming.xie on 4/2/16.
 */
@Repository
public class Level3AccountRepository {

    @Autowired
    Level3AccountDao level3AccountDao;

    public Level3Account findByUserId(long userId) {

        return level3AccountDao.findByUserId(userId);
    }

    public void save(Level3Account level3Account) {
        level3AccountDao.update(level3Account);
    }
}
