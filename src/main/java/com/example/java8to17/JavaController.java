package com.example.java8to17;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@RestController
public class JavaController {


    @GetMapping("/jaxb")
    public String testJaxb(){

        try {
            Book book = new Book("Lord of the Rings");

            JAXBContext context = JAXBContext.newInstance(Book.class);
            Marshaller mar= null;
            mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            mar.marshal(book, writer);
            return writer.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }


}
