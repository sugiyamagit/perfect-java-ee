/**
 *
 */
package org.jboss.as.quickstarts.kitchensink.interceptor;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

/**
 * Sample Implementation for JAX-RS Interceptor
 *
 * @author sinokuma
 *
 */
public class MyReaderInterceptor implements ReaderInterceptor {

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context)
            throws IOException, WebApplicationException {
        MultivaluedMap<String, String> headers = context.getHeaders();
        InputStream in = context.getInputStream();
        // チェイン上の次のインタセプタ呼び出し
        // 最後はMessageBodyReaderオブジェクトのreadFromメソッド呼び出し
        Object entity = context.proceed();
        return entity;
    }

}
