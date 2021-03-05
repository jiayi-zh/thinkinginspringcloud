package com.bat.jyzh.feign.nativeapi.encoder;

import com.alibaba.fastjson.JSONObject;
import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import org.springframework.util.StringUtils;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;

/**
 * 自定义编码器实现, 仅支持 application/json
 *
 * @author ZhengYu
 * @version 1.0 2021/3/5 10:31
 **/
public class CustomEncoder implements Encoder {

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        if (!StringUtils.hasText(template.method())) {
            throw new EncodeException("request method is blank!");
        }
        if ("GET".equals(template.method())) {
            if (object.getClass().isAssignableFrom(LinkedHashMap.class)) {
                LinkedHashMap<?, ?> queryMap = (LinkedHashMap<?, ?>) object;
                queryMap.forEach((k, v) -> template.query(k.toString(), v.toString()));
            }
        } else {
            template.body(JSONObject.toJSONBytes(object), StandardCharsets.UTF_8);
        }
    }
}
