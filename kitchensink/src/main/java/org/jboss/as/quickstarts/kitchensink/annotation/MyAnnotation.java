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
 * 限定子サンプル
 *
 * @author sinokuma
 *
 */
@Qualifier
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
public @interface MyAnnotation {
    /** 値を差替可能にする */
    MyAnnotationStrategy value();

    /** 依存性解決に使用されない。コメント欄をアノテーションに作ることができる */
    @Nonbinding
    String comment();

    // 組込み限定子:@Any, @Default, @New(@NewはCDI1.1より非推奨)
}
