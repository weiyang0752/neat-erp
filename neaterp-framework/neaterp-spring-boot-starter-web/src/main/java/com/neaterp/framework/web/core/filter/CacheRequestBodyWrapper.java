package com.neaterp.framework.web.core.filter;

import com.neaterp.framework.common.util.servlet.ServletUtils;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  Request Body 缓存 Wrapper
 *
 * @author 芋道源码
 */
public class CacheRequestBodyWrapper extends HttpServletRequestWrapper {

    /**
     * 缓存的内容
     */
    private final byte[] body;

    public CacheRequestBodyWrapper(HttpServletRequest request) {
        super(request);
        byte[] bytes = ServletUtils.getBodyBytes(request);
        this.body = bytes != null ? bytes : new byte[0];
    }

    @Override
    public ServletInputStream getInputStream() {
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(body);
        return new ServletInputStream() {

            @Override
            public int read() {
                return inputStream.read();
            }

            @Override
            public boolean isFinished() {
                return inputStream.available() == 0;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
                // 可根据需要扩展异步读取
            }

            @Override
            public int available() {
                return inputStream.available();
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(
                new InputStreamReader(this.getInputStream(), getCharacterEncoding()));
    }


}
