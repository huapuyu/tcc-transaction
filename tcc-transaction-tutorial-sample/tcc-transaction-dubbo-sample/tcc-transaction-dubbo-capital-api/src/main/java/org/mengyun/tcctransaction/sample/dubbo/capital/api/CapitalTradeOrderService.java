package org.mengyun.tcctransaction.sample.dubbo.capital.api;

import org.mengyun.tcctransaction.api.TransactionContext;
import org.mengyun.tcctransaction.api.base.BaseResponse;
import org.mengyun.tcctransaction.sample.dubbo.capital.api.dto.CapitalTradeOrderDto;

/**
 * Created by changming.xie on 4/1/16.
 */
public interface CapitalTradeOrderService {

    public BaseResponse record(TransactionContext transactionContext,CapitalTradeOrderDto tradeOrderDto);
}
