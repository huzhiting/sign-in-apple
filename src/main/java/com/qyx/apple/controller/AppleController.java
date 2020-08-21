package com.qyx.apple.controller;

import com.qyx.apple.service.IAppleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description : 苹果登录api
 * @Author : huzhiting
 * @Date: 2020-08-21 11:00
 */
@Slf4j
@RestController
@RequestMapping("/apple")
public class AppleController {
    @Resource
    private IAppleService appleService;

    @RequestMapping(value = "/login/verify", method = RequestMethod.POST)
    public Map loginVerify(@RequestParam("identityToken") String identityToken) {
        try {
            log.info("[AppleController.loginVerify] [start] [identityToken is {}]", identityToken);
            Map<String, Object> appleUser = appleService.getAppleUserInfo(identityToken);
            if (appleUser == null) {
                return null;
            }
            log.info("[AppleController.loginVerify] [end] [appleUser is {}]", appleUser);
            return appleUser;
        } catch (Exception e) {
            log.error("[AppleController.loginVerify] [error] [identityToken is {}]", identityToken, e);
            return null;
        }
    }
}
