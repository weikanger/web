package com.cloud.operator.remote;

import com.cloud.auth.common.bean.AuthUserBean;
import com.cloud.common.bean.ResultsBean;
import com.cloud.common.constant.FeignClientConstants;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 用户客户端
 */
@FeignClient(value = FeignClientConstants.AUTH_EUREKA_SERVER_INSTANCE_CORE)
public interface AuthUserClient {

    /**
     * 分页查询用户信息
     *
     * @param params 查询参数
     * @return PageInfo<Map < String, Object>>
     */
    @RequestMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/authUser/findByPageAll", method = RequestMethod.GET)
    ResultsBean<PageInfo<Map<String, Object>>> findByPageAll(@RequestParam Map<String, Object> params);

    /**
     * 根据id查询用户信息
     *
     * @param id 用户id
     * @return ResultsBean<AuthUserBean>
     */
    @RequestMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/authUser/findById/{id}", method = RequestMethod.GET)
    ResultsBean<AuthUserBean> findById(@PathVariable("id") Long id);

    /**
     * 根据姓名查询用户信息
     *
     * @param username 用户名
     * @return ResultsBean<AuthUserBean>
     */
    @RequestMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/authUser/findByUserName", method = RequestMethod.GET)
    ResultsBean<AuthUserBean> findByUserName(@RequestParam("username") String username);

    /**
     * 删除用户信息
     *
     * @param id 用户id
     * @return ResultsBean<String>
     */
    @RequestMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/authUser/deleteById/{id}", method = RequestMethod.DELETE)
    public ResultsBean<String> deleteById(@PathVariable("id") Long id);

    /**
     * 创建或更新用户信息
     *
     * @param authUser 用户信息
     * @return ResultsBean<String>
     */
    @RequestMapping(path = FeignClientConstants.AUTH_APPLICATION_NAME_CODE + "/authUser/merge", method = RequestMethod.POST)
    public ResultsBean<String> createOrUpdate(@RequestBody AuthUserBean authUser);

}
