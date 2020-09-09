package cn.itcast.test;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis extends BaseTest{
    @Test
    public void run1() throws IOException {
        // DAO 没有实现类，要使用代理
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SQLSession对象
        SqlSession session = factory.openSession();
        // 获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        // 执行dao方法
        Account account = new Account();
        account.setName("刘亦菲");
        account.setMoney(1000.2D);
        dao.saveAccount(account);
        // 提交事务
        session.commit();
        // 查询
        List<Account> list = dao.findAll();
        for (Account lt : list) {
            System.out.println(lt);
        }
        // 关闭释放资源
        session.close();;
        in.close();
    }
}
