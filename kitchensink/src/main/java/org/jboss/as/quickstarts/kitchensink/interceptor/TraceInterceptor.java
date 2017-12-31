/**
 *
 */
package org.jboss.as.quickstarts.kitchensink.interceptor;

import javax.annotation.Priority;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.jboss.as.quickstarts.kitchensink.annotation.EnableTraceLog;
import org.jboss.logging.Logger;

/**
 * トレースログ出力インターセプタ
 *
 * @author sinokuma
 *
 */
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)	// beans.xmlなしで順序制御可能
@EnableTraceLog
public class TraceInterceptor {

    private static final Logger LOGGER = Logger.getLogger(TraceInterceptor.class);

    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception {
        String methodName = ic.getMethod().getName();
        String className = ic.getTarget().getClass().getSimpleName();

        LOGGER.trace("Start " + className + "." + methodName + " method");

        try {
            Object result = ic.proceed();
            return result;
        } catch (Exception e) {
            LOGGER.error("Error!", e);
            throw e;
        } finally {
            LOGGER.trace("End " + className + "." + methodName + " method");
        }
    }

    @AroundConstruct
    public Object logConstructor(InvocationContext ic) throws Exception {
        String constructorName = ic.getConstructor().getName();
        LOGGER.trace("Start " + constructorName);
        Object result = ic.proceed();
        LOGGER.trace("End " + constructorName);
        return result;
    }
}
