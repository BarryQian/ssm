package cn.itcast.test;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.junit.Test;

import javax.annotation.Resource;

public class TestSpring extends BaseTest{
    @Resource
    private AccountService accountService;
    @Test
    public void sun1() {
        Account account = new Account();
        account.setName("张敏");
        account.setMoney(10032D);

        accountService.saveAccount(account);
        accountService.findAll();
    }
}
