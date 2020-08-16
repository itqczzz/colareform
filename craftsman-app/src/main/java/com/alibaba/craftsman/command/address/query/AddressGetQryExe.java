package com.alibaba.craftsman.command.address.query;

import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.craftsman.dto.address.clientobject.AddressCo;
import com.alibaba.craftsman.dto.address.cmd.AddressGetQry;
import com.alibaba.craftsman.gatewayimpl.database.AddressMapper;
import com.alibaba.craftsman.gatewayimpl.database.dataobject.AddressDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author qiuchang
 * @date 2020/8/7 23:44
 */
@Component
public class AddressGetQryExe {
    @Resource
    private AddressMapper addressMapper;

    public SingleResponse<AddressCo> execute(AddressGetQry qry){
        AddressDO addressDO = addressMapper.selectById(qry.getId());
        AddressCo addressCo = new AddressCo();
        BeanUtils.copyProperties(addressDO,addressCo);
        return SingleResponse.of(addressCo);
    }
}
