/**
 *
 */
package org.jboss.as.quickstarts.kitchensink.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import org.jboss.as.quickstarts.kitchensink.annotation.MyFilterMark;

/**
 * JAX-RSリクエストフィルタ<br>
 *
 *
 * @author sinokuma
 *
 */
@Provider
@MyFilterMark
public class MyRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        UriInfo uriInfo = requestContext.getUriInfo();	// リクエストURL情報
        MultivaluedMap<String, String> headers = requestContext.getHeaders();	// リクエストヘッダ情報
        Map<String, Cookie> cookies = requestContext.getCookies();	// クッキー情報
        if (requestContext.hasEntity()) {	// リクエストボディ情報
            InputStream bodyStream = requestContext.getEntityStream();
        }
        // 汎用的な状態管理
        requestContext.setProperty("foo", "bar");
    }

}
