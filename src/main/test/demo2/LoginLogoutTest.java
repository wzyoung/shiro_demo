package demo2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhiyaowang on 2/27/16.
 */
public class LoginLogoutTest {
    @Test
    public void testHelloWorld() {
        //1、获取 SecurityManager 工厂,此处使用 Ini 配置文件初始化
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro.ini");

        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            subject.login(token);

        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(true, subject.isAuthenticated());

        subject.logout();

    }

}
