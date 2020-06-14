package org.dev.application.service;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService(
        targetNamespace = "http://localhost:8080/services/GreetingService/",
        name = "GreetingService",
        serviceName = "GreetingService",
        portName = "SOAPOverHTTP"
)
public interface GreetingService {

    String greet(
            @XmlElement(required = true) @WebParam(name = "name") String name
    );

}
