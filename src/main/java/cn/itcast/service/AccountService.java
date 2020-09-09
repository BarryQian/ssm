package cn.itcast.service;

import cn.itcast.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {
    /**
     * 查询所有账户信息
     * @return
     */
    public List<Account> findAll();

    /**
     * 保存账户信息
     * @param account
     */
    public void saveAccount(Account account);
}
