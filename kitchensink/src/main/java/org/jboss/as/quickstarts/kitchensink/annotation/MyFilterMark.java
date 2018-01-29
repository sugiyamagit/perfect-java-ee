/**
 *
 */
package org.jboss.as.quickstarts.kitchensink.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.ws.rs.NameBinding;

/**
 * フィルタバインディング
 *
 * @author sinokuma
 *
 */
@NameBinding
@Retention(value = RUNTIME)
@Target({METHOD, TYPE})
public @interface MyFilterMark {

}
