package com.dagon.microservice2017.restonspringwebmvc.http.message;

import com.dagon.microservice2017.restonspringwebmvc.pojo.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * Created by Dagon on 2019/9/6 - 22:50
 */
public class PersonPropertiesAbstractGenericHttpMessageConverter extends AbstractHttpMessageConverter<Person> {

    public PersonPropertiesAbstractGenericHttpMessageConverter(){
        super(MediaType.valueOf("application/properties+person"));
        setDefaultCharset(Charset.forName("UTF-8"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Person.class);
    }

    /**
     * 将properties-->Person对象
     * @param clazz
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected Person readInternal(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream inputStream = inputMessage.getBody();

        Properties properties = new Properties();
        properties.load(inputStream);

        long id =Long.valueOf(properties.getProperty("person.id"));
        String name = properties.getProperty("person.name");


        return new Person(id, name);
    }

    /**
     * 将Person对象-->properties
     * @param person
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(Person person, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream outputStream = outputMessage.getBody();

        Properties properties = new Properties();
        properties.setProperty("person.id", "" + person.getId());
        properties.setProperty("person.name", person.getName());

        properties.store(new OutputStreamWriter(outputStream,getDefaultCharset()),"define by nevermore.");

    }
}
