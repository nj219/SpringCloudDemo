package nj.user.client.impl;

import nj.user.client.BaseClient;
import org.springframework.stereotype.Component;

/**
 * @Author 牛杰
 * @Date 2019/2/27 9:07
 * @ClassName:BaseClient
 */
@Component
public class BaseClientImpl implements BaseClient {
    @Override
    public String getBaseMessage() {
        return "连接异常";
    }
}
