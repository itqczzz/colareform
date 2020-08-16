package com.alibaba.craftsman.api;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.craftsman.dto.address.clientobject.AddressCo;
import com.alibaba.craftsman.dto.address.cmd.AddressAddCmd;
import com.alibaba.craftsman.dto.address.cmd.AddressGetQry;

/**
 * ProvinceCityInfoServiceI
 *
 * @author qiuchang
 * @date 2020-08-07 00:06 PM
 */
public interface AddressServiceI {

    public SingleResponse<AddressCo> getAddressBy(AddressGetQry qry);

    public Response addAddress(AddressAddCmd cmd);
}
