package org.mengyun.tcctransaction.sample.dubbo.level3.service;

import org.mengyun.tcctransaction.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;
import org.mengyun.tcctransaction.api.base.BaseResponse;
import org.mengyun.tcctransaction.sample.dubbo.level3.api.Level3Service;
import org.mengyun.tcctransaction.sample.dubbo.level3.api.dto.Level3Dto;
import org.mengyun.tcctransaction.sample.dubbo.level3.domain.entity.Level3Account;
import org.mengyun.tcctransaction.sample.dubbo.level3.domain.repository.Level3AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by changming.xie on 4/2/16.
 */
@Service("level3Service")
public class Level3ServiceImpl implements Level3Service {

    @Autowired
    Level3AccountRepository level3AccountRepository;

    @Override
    @Compensable(confirmMethod = "confirmRecord", cancelMethod = "cancelRecord")
    public BaseResponse record(TransactionContext transactionContext, Level3Dto level3Dto) {
        System.out.println("level3 try record called");
        
//        throw new RuntimeException();

        Level3Account transferFromAccount = level3AccountRepository.findByUserId(level3Dto.getSelfUserId());

        transferFromAccount.transferFrom(level3Dto.getAmount());

        level3AccountRepository.save(transferFromAccount);
        
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setErrorCode("1111");
        return baseResponse;
    }

    public void confirmRecord(TransactionContext transactionContext, Level3Dto level3Dto) {
        System.out.println("level3 confirm record called");

        Level3Account transferToAccount = level3AccountRepository.findByUserId(level3Dto.getOppositeUserId());

        transferToAccount.transferTo(level3Dto.getAmount());

        level3AccountRepository.save(transferToAccount);
    }

    public void cancelRecord(TransactionContext transactionContext, Level3Dto level3Dto) {
        System.out.println("level3 cancel record called");

        Level3Account level3Account = level3AccountRepository.findByUserId(level3Dto.getSelfUserId());

        level3Account.cancelTransfer(level3Dto.getAmount());

        level3AccountRepository.save(level3Account);
    }
}
