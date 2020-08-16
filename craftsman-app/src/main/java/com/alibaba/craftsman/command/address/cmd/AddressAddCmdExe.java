package com.alibaba.craftsman.command.address.cmd;

import com.alibaba.cola.dto.Response;
import com.alibaba.craftsman.dto.address.clientobject.AddressCo;
import com.alibaba.craftsman.dto.address.cmd.AddressAddCmd;
import com.alibaba.craftsman.gatewayimpl.database.AddressMapper;
import com.alibaba.craftsman.gatewayimpl.database.dataobject.AddressDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * @author qiuchang
 * @date 2020/8/8 21:00
 */
@Component
public class AddressAddCmdExe {
    @Resource
    private AddressMapper addressMapper;

    public Response execute(AddressAddCmd cmd) {
        AddressCo addressCo = cmd.getAddressCo();
        AddressDO addressDO = new AddressDO();
        BeanUtils.copyProperties(addressCo,addressDO);
        addressMapper.insert(addressDO);
        return Response.buildSuccess();
    }
}
