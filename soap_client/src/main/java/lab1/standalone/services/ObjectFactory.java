
package lab1.standalone.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the lab1.standalone.services package. 
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

    private final static QName _FindFilmsResponse_QNAME = new QName("http://services.standalone.lab1/", "findFilmsResponse");
    private final static QName _FindFilms_QNAME = new QName("http://services.standalone.lab1/", "findFilms");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: lab1.standalone.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindFilmsResponse }
     * 
     */
    public FindFilmsResponse createFindFilmsResponse() {
        return new FindFilmsResponse();
    }

    /**
     * Create an instance of {@link FindFilms }
     * 
     */
    public FindFilms createFindFilms() {
        return new FindFilms();
    }

    /**
     * Create an instance of {@link Film }
     * 
     */
    public Film createFilm() {
        return new Film();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFilmsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.standalone.lab1/", name = "findFilmsResponse")
    public JAXBElement<FindFilmsResponse> createFindFilmsResponse(FindFilmsResponse value) {
        return new JAXBElement<FindFilmsResponse>(_FindFilmsResponse_QNAME, FindFilmsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFilms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.standalone.lab1/", name = "findFilms")
    public JAXBElement<FindFilms> createFindFilms(FindFilms value) {
        return new JAXBElement<FindFilms>(_FindFilms_QNAME, FindFilms.class, null, value);
    }

}
