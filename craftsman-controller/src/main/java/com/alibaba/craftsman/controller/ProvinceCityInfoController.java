package com.alibaba.craftsman.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiuchang
 * @date 2020/7/25 20:56
 */
@RestController("/api/addressinfo")
public class ProvinceCityInfoController {

    @GetMapping("/allInfo")
    public @ResponseBody Object getAddressInfo(){
        return null;
    }
}
