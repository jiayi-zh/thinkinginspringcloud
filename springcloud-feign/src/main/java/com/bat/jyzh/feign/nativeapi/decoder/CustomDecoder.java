package com.bat.jyzh.feign.nativeapi.decoder;

import com.alibaba.fastjson.JSONObject;
import feign.FeignException;
import feign.Response;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * 自定义解码器实现, 仅支持 application/json
 *
 * @author ZhengYu
 * @version 1.0 2021/3/5 10:37
 **/
public class CustomDecoder implements Decoder {

    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {
        return JSONObject.parseObject(response.body().asInputStream(), type);
    }
}
