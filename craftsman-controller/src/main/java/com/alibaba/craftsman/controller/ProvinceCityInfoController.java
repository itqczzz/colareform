package com.alibaba.craftsman.controller;

import com.alibaba.craftsman.api.MetricsServiceI;
import com.alibaba.craftsman.api.ProvinceCityInfoServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiuchang
 * @date 2020/7/25 20:56
 */
@RestController("/api/addressinfo")
public class ProvinceCityInfoController {


    @Autowired
    private ProvinceCityInfoServiceI provinceCityInfoServiceI;


    @GetMapping("/allInfo")
    public @ResponseBody Object getAddressInfo(){
        return null;
    }
}
