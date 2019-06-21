package com.cloud.operator.remote;

import com.cloud.common.bean.Authorization;
import com.cloud.common.bean.ResultsBean;
import com.cloud.common.constant.FeignClientConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户登录客户端
 */
@FeignClient(value = FeignClientConstants.AUTH_EUREKA_SERVER_INSTANCE_CORE)
public interface LoginClient {
    /**
     * 登录
     *
     * @param username     用户名
     * @param password     密码
     * @param securityCode 验证码
     */
    @PostMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/operatorLogin/login")
    ResultsBean<Authorization> login(@RequestParam(value = "username") String username,
                                     @RequestParam(value = "password") String password,
                                     @RequestParam(value = "securityCode") String securityCode);
}