package com.qyx.apple.service;

import java.util.Map;
/**
 * @Description : 苹果登录service接口类
 * @Author : huzhiting
 * @Date: 2020-08-21 11:01
 */
public interface IAppleService {
    Map<String, Object> getAppleUserInfo(String identityToken) throws Exception;
}
