/**
 *
 */
package org.jboss.as.quickstarts.kitchensink.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.as.quickstarts.kitchensink.dto.JaxRsSampleDto;
import org.jboss.as.quickstarts.kitchensink.dto.JaxRsSampleXmlDto;

/**
 * JAX-RSリソースクラス
 *
 * @author sinokuma
 *
 */
@ApplicationScoped	// リソースクラスは状態を持たないのでシングルトンでOK
@Path("my")
public class JaxRsResourceSample {

    @POST
    @Path("hello")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@BeanParam JaxRsSampleDto dto) {
        String title = dto.getName();
        String name = dto.getName();
        return "title: " + title + " name: " + name;
    }

    @GET
    @Path("hello")
    @Produces(MediaType.APPLICATION_JSON)
    public JaxRsSampleDto helloJson() {
        return new JaxRsSampleDto("foo", "bar");
    }

    @GET
    @Path("hello")
    @Produces(MediaType.APPLICATION_XML)
    public JaxRsSampleXmlDto helloXml() {
        return new JaxRsSampleXmlDto("foo", "bar");
    }

}
