package nj.user.client;

import nj.user.client.impl.BaseClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author 牛杰
 * @Date 2019/2/26 9:53
 * @ClassName:BaseClient
 */
@FeignClient(value = "nj-base",fallback = BaseClientImpl.class)
public interface BaseClient {
    /**
     * 调用base服务
     * @return
     */
    @GetMapping(value = "base")
    String getBaseMessage();
}
