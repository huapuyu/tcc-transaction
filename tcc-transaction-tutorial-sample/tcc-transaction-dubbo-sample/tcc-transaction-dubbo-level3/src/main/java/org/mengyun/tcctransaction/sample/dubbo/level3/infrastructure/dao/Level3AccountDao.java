package org.mengyun.tcctransaction.sample.dubbo.level3.infrastructure.dao;

import org.mengyun.tcctransaction.sample.dubbo.level3.domain.entity.Level3Account;

/**
 * Created by changming.xie on 4/2/16.
 */
public interface Level3AccountDao {

    Level3Account findByUserId(long userId);

    void update(Level3Account level3Account);
}
