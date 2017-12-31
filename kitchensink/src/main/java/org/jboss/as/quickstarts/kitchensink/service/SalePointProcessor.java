/**
 *
 */
package org.jboss.as.quickstarts.kitchensink.service;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

import org.jboss.as.quickstarts.kitchensink.model.Point;

/**
 * decorator実装サンプル
 *
 * @author sinokuma
 *
 */
@Decorator
@Priority(Interceptor.Priority.APPLICATION)
public class SalePointProcessor implements PointProcessor {

    /** ポイントボーナス */
    private static final int BONUS_RATE = 5;

    @Inject
    @Delegate
    private PointProcessor processor;

    @Override
    public Point process(int purchasePrice) {
        Point p = processor.process(purchasePrice);
        return new Point(p.getPoint() * BONUS_RATE, p.getExpire());
    }
}