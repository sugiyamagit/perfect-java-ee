/**
 *
 */
package org.jboss.as.quickstarts.kitchensink.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.jboss.as.quickstarts.kitchensink.annotation.Config;

/**
 * プロパティ値を返却するプロデューサ
 *
 * @author sinokuma
 *
 */
@ApplicationScoped
public class ConfigProducer {

    private Properties props;

    @PostConstruct
    public void init() {
        try (BufferedInputStream bis = new BufferedInputStream(
                this.getClass().getClassLoader().getResourceAsStream("config.properties"))) {
            this.props = new Properties();
            this.props.load(bis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Produces
    @Config
    public int getIntConfig(InjectionPoint ip) {
        String key = ip.getAnnotated().getAnnotation(Config.class).value();
        return Integer.valueOf(props.getProperty(key));
    }

    @Produces
    @Config
    public String getStringConfig(InjectionPoint ip) {
        String key = ip.getAnnotated().getAnnotation(Config.class).value();
        return props.getProperty(key);
    }

}
