package com.bat.jyzh.business.config;

import com.bat.jyzh.common.entity.resp.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 *
 * @author ZhengYu
 * @version 1.0 2021/3/9 9:23
 **/
@Slf4j
@RestControllerAdvice
public class CustomGlobalExceptionHandler {

    private static final String PARAM_VALID_MSG = "parameter validation failed";

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResult<?> methodArgumentNotValidExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException mavException) {
        String msg = PARAM_VALID_MSG;
        Optional<List<ObjectError>> validExceptionListOptional = Optional.ofNullable(mavException)
                .map(MethodArgumentNotValidException::getBindingResult)
                .map(BindingResult::getAllErrors);
        if (validExceptionListOptional.isPresent()) {
            msg = validExceptionListOptional.get().stream()
                    .map(objectError -> {
                        String unValidField = "";
                        Class<?> clazz = objectError.getClass();
                        try {
                            Field field = ReflectionUtils.findField(clazz, "field");
                            if (field != null) {
                                field.setAccessible(true);
                                unValidField = field.get(objectError).toString();
                            }
                        } catch (Exception e) {
                            log.error("参数校验异常处理 , 获取异常字段失败, 原因: {} {}", e.getMessage(), e);
                        }
                        return String.format("field[%s] validation failed, cause: %s", unValidField, objectError.getDefaultMessage());
                    })
                    .collect(Collectors.joining("\r\n"));
        }

        log.info("请求 {} 参数校验未通过, 原因: {}", request.getRequestURI(), msg);
        CommonResult<?> result = new CommonResult<>();
        result.setCode(-1);
        result.setMsg(msg);
        return result;
    }

    @ExceptionHandler(value = Exception.class)
    public CommonResult<?> unExpectExceptionHandler(HttpServletRequest request, Exception exception) {
        log.info("请求 {} 异常, 原因: {}", request.getRequestURI(), exception.toString());
        CommonResult<?> result = new CommonResult<>();
        result.setCode(-1);
        result.setMsg(exception.getMessage());
        return result;
    }
}