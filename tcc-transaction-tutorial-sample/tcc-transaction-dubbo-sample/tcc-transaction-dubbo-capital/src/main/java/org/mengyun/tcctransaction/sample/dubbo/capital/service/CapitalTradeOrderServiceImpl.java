package org.mengyun.tcctransaction.sample.dubbo.capital.service;

import org.mengyun.tcctransaction.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;
import org.mengyun.tcctransaction.sample.dubbo.capital.api.CapitalTradeOrderService;
import org.mengyun.tcctransaction.sample.dubbo.capital.api.dto.CapitalTradeOrderDto;
import org.mengyun.tcctransaction.sample.dubbo.capital.domain.entity.CapitalAccount;
import org.mengyun.tcctransaction.sample.dubbo.capital.domain.repository.CapitalAccountRepository;
import org.mengyun.tcctransaction.sample.dubbo.level3.api.Level3Service;
import org.mengyun.tcctransaction.sample.dubbo.level3.api.dto.Level3Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by changming.xie on 4/2/16.
 */
@Service("capitalTradeOrderService")
public class CapitalTradeOrderServiceImpl implements CapitalTradeOrderService {

    @Autowired
    CapitalAccountRepository capitalAccountRepository;
    @Autowired
    Level3Service level3Service;

    @Override
    @Compensable(confirmMethod = "confirmRecord", cancelMethod = "cancelRecord")
    public void record(TransactionContext transactionContext, CapitalTradeOrderDto tradeOrderDto) {
        System.out.println("capital try record called");

        CapitalAccount transferFromAccount = capitalAccountRepository.findByUserId(tradeOrderDto.getSelfUserId());

        transferFromAccount.transferFrom(tradeOrderDto.getAmount());

        capitalAccountRepository.save(transferFromAccount);
        
        level3Service.record(transactionContext, buildRedPacketTradeOrderDto(tradeOrderDto));
    }

    public void confirmRecord(TransactionContext transactionContext, CapitalTradeOrderDto tradeOrderDto) {
        System.out.println("capital confirm record called");

        CapitalAccount transferToAccount = capitalAccountRepository.findByUserId(tradeOrderDto.getOppositeUserId());

        transferToAccount.transferTo(tradeOrderDto.getAmount());

        capitalAccountRepository.save(transferToAccount);
    }

    public void cancelRecord(TransactionContext transactionContext, CapitalTradeOrderDto tradeOrderDto) {
        System.out.println("capital cancel record called");

        CapitalAccount capitalAccount = capitalAccountRepository.findByUserId(tradeOrderDto.getSelfUserId());

        capitalAccount.cancelTransfer(tradeOrderDto.getAmount());

        capitalAccountRepository.save(capitalAccount);
    }
    
    private Level3Dto buildRedPacketTradeOrderDto(CapitalTradeOrderDto order) {
        Level3Dto level3Dto = new Level3Dto();
        level3Dto.setAmount(order.getAmount());
        level3Dto.setMerchantOrderNo(order.getMerchantOrderNo());
        level3Dto.setSelfUserId(order.getSelfUserId());
        level3Dto.setOppositeUserId(order.getOppositeUserId());
        level3Dto.setOrderTitle(String.format("order no:%s", order.getMerchantOrderNo()));

        return level3Dto;
    }
}
