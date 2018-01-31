/**
 *
 */
package org.jboss.as.quickstarts.kitchensink.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * JavaBeans for XML
 *
 * @author sinokuma
 *
 */
@XmlRootElement(name = "base")
public class JaxRsSampleXmlDto {

    @SuppressWarnings("unused")
    private JaxRsSampleXmlDto() {
    }

    public JaxRsSampleXmlDto(String title, String name) {
        this.title = title;
        this.name = name;
    }

    private String title;
    private String name;

    /**
     * name属性で異なるXMLの要素名にできる
     *
     * @return title
     */
    @XmlElement(name = "subject")
    public String getTitle() {
        return title;
    }

    /**
     * XMLの要素名はJavaBeansのプロパティ名になる
     *
     * @return name
     */
    @XmlElement
    public String getName() {
        return name;
    }

}
