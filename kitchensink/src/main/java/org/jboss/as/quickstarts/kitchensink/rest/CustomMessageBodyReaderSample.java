/**
 *
 */
package org.jboss.as.quickstarts.kitchensink.rest;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import org.jboss.as.quickstarts.kitchensink.dto.JaxRsSampleDto;

/**
 * 独自MessageBodyReaderサンプル
 *
 * @author sinokuma
 *
 */
@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class CustomMessageBodyReaderSample implements MessageBodyReader<JaxRsSampleDto> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type == JaxRsSampleDto.class;
    }

    @Override
    public JaxRsSampleDto readFrom(Class<JaxRsSampleDto> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
                    throws IOException, WebApplicationException {
        JaxRsSampleDto dto = new  JaxRsSampleDto();
        try (JsonParser parser = Json.createParser(entityStream)) {
            while (parser.hasNext()) {
                JsonParser.Event event = parser.next();
                if (event == JsonParser.Event.KEY_NAME) {
                    String key = parser.getString();
                    parser.next();
                    String value = parser.getString();
                    switch(key) {
                    case "title":
                        dto.setTitle(value);
                        break;
                    case "name":
                        dto.setName(value);
                        break;
                    }
                }
            }
        }
        return dto;
    }

}
