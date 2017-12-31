/**
 *
 */
package org.jboss.as.quickstarts.kitchensink.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

/**
 * プロパティ用の限定子
 *
 * @author sinokuma
 *
 */
@Qualifier
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
public @interface Config {

    @Nonbinding
    String value() default "";
}
