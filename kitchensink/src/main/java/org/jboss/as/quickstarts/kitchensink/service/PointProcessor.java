/**
 *
 */
package org.jboss.as.quickstarts.kitchensink.service;

import org.jboss.as.quickstarts.kitchensink.model.Point;

/**
 * @author sinokuma
 *
 */
public interface PointProcessor {

    /**
     * ポイント計算ロジック
     *
     * @param purchasePrice 購入金額
     * @return ポイントエンティティ
     */
    Point process(int purchasePrice);

}
