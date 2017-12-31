package org.jboss.as.quickstarts.kitchensink.model;

import java.time.LocalDate;

/**
 * Entity implementation class for Entity: Point
 *
 */
public class Point {
    private final int point;
    private final LocalDate expire;

    public Point(int point, LocalDate expire) {
        this.point = point;
        this.expire = expire;
    }

    /**
     * @return point
     */
    public int getPoint() {
        return point;
    }

    /**
     * @return expire
     */
    public LocalDate getExpire() {
        return expire;
    }
}
