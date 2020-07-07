package com.cjw.services.client;

import com.cjw.auth.api.AuthApi;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Classname AuthClient
 * @Description
 * @Date 2020/7/7 22:19
 * @Created by cjw
 */
@FeignClient("scp-auth")
public interface AuthClient extends AuthApi {
}
