/**
 *
 */
package org.jboss.as.quickstarts.kitchensink.dto;

/**
 * JAX-RS サンプル用のDTO
 *
 * @author sinokuma
 *
 */
public class JaxRsSampleDto {

    public JaxRsSampleDto() {
        // do nothing
    }

    public JaxRsSampleDto(String title, String name) {
        this.title = title;
        this.name = name;
    }

    private String title;
    private String name;

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title セットする title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name セットする name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JaxRsSampleDto [title=" + title + ", name=" + name + "]";
    }

}
