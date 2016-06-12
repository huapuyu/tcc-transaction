package org.mengyun.tcctransaction.sample.dubbo.level3.api;

import org.mengyun.tcctransaction.api.TransactionContext;
import org.mengyun.tcctransaction.api.base.BaseResponse;
import org.mengyun.tcctransaction.sample.dubbo.level3.api.dto.Level3Dto;

/**
 * Created by changming.xie on 4/1/16.
 */
public interface Level3Service {

    public BaseResponse record(TransactionContext transactionContext,Level3Dto level3Dto);
}
