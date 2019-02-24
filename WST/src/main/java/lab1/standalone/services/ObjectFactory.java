
package lab1.standalone.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the lab1.lab1.standalone.services package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetFilmsByFields_QNAME = new QName("http://services.lab1.standalone.lab1/", "getFilmsByFields");
    private final static QName _GetFilmsByFieldsResponse_QNAME = new QName("http://services.lab1.standalone.lab1/", "getFilmsByFieldsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: lab1.lab1.standalone.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFilmsByFields }
     * 
     */
    public GetFilmsByFields createGetFilmsByFields() {
        return new GetFilmsByFields();
    }

    /**
     * Create an instance of {@link GetFilmsByFieldsResponse }
     * 
     */
    public GetFilmsByFieldsResponse createGetFilmsByFieldsResponse() {
        return new GetFilmsByFieldsResponse();
    }

    /**
     * Create an instance of {@link Film }
     * 
     */
    public Film createFilm() {
        return new Film();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilmsByFields }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.lab1.standalone.lab1/", name = "getFilmsByFields")
    public JAXBElement<GetFilmsByFields> createGetFilmsByFields(GetFilmsByFields value) {
        return new JAXBElement<GetFilmsByFields>(_GetFilmsByFields_QNAME, GetFilmsByFields.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilmsByFieldsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.lab1.standalone.lab1/", name = "getFilmsByFieldsResponse")
    public JAXBElement<GetFilmsByFieldsResponse> createGetFilmsByFieldsResponse(GetFilmsByFieldsResponse value) {
        return new JAXBElement<GetFilmsByFieldsResponse>(_GetFilmsByFieldsResponse_QNAME, GetFilmsByFieldsResponse.class, null, value);
    }

}
