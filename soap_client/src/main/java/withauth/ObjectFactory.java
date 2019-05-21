
package withauth;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the withauth package. 
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

    private final static QName _UpdateFilmResponse_QNAME = new QName("http://withAuth/", "updateFilmResponse");
    private final static QName _InsertFilmResponse_QNAME = new QName("http://withAuth/", "insertFilmResponse");
    private final static QName _DeleteFilmResponse_QNAME = new QName("http://withAuth/", "deleteFilmResponse");
    private final static QName _InsertFilm_QNAME = new QName("http://withAuth/", "insertFilm");
    private final static QName _FindFilmsResponse_QNAME = new QName("http://withAuth/", "findFilmsResponse");
    private final static QName _FindFilms_QNAME = new QName("http://withAuth/", "findFilms");
    private final static QName _UpdateFilm_QNAME = new QName("http://withAuth/", "updateFilm");
    private final static QName _DeleteFilm_QNAME = new QName("http://withAuth/", "deleteFilm");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: withauth
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertFilmResponse }
     * 
     */
    public InsertFilmResponse createInsertFilmResponse() {
        return new InsertFilmResponse();
    }

    /**
     * Create an instance of {@link UpdateFilmResponse }
     * 
     */
    public UpdateFilmResponse createUpdateFilmResponse() {
        return new UpdateFilmResponse();
    }

    /**
     * Create an instance of {@link DeleteFilm }
     * 
     */
    public DeleteFilm createDeleteFilm() {
        return new DeleteFilm();
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
     * Create an instance of {@link UpdateFilm }
     * 
     */
    public UpdateFilm createUpdateFilm() {
        return new UpdateFilm();
    }

    /**
     * Create an instance of {@link DeleteFilmResponse }
     * 
     */
    public DeleteFilmResponse createDeleteFilmResponse() {
        return new DeleteFilmResponse();
    }

    /**
     * Create an instance of {@link InsertFilm }
     * 
     */
    public InsertFilm createInsertFilm() {
        return new InsertFilm();
    }

    /**
     * Create an instance of {@link Film }
     * 
     */
    public Film createFilm() {
        return new Film();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFilmResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://withAuth/", name = "updateFilmResponse")
    public JAXBElement<UpdateFilmResponse> createUpdateFilmResponse(UpdateFilmResponse value) {
        return new JAXBElement<UpdateFilmResponse>(_UpdateFilmResponse_QNAME, UpdateFilmResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertFilmResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://withAuth/", name = "insertFilmResponse")
    public JAXBElement<InsertFilmResponse> createInsertFilmResponse(InsertFilmResponse value) {
        return new JAXBElement<InsertFilmResponse>(_InsertFilmResponse_QNAME, InsertFilmResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFilmResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://withAuth/", name = "deleteFilmResponse")
    public JAXBElement<DeleteFilmResponse> createDeleteFilmResponse(DeleteFilmResponse value) {
        return new JAXBElement<DeleteFilmResponse>(_DeleteFilmResponse_QNAME, DeleteFilmResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertFilm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://withAuth/", name = "insertFilm")
    public JAXBElement<InsertFilm> createInsertFilm(InsertFilm value) {
        return new JAXBElement<InsertFilm>(_InsertFilm_QNAME, InsertFilm.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFilmsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://withAuth/", name = "findFilmsResponse")
    public JAXBElement<FindFilmsResponse> createFindFilmsResponse(FindFilmsResponse value) {
        return new JAXBElement<FindFilmsResponse>(_FindFilmsResponse_QNAME, FindFilmsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFilms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://withAuth/", name = "findFilms")
    public JAXBElement<FindFilms> createFindFilms(FindFilms value) {
        return new JAXBElement<FindFilms>(_FindFilms_QNAME, FindFilms.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFilm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://withAuth/", name = "updateFilm")
    public JAXBElement<UpdateFilm> createUpdateFilm(UpdateFilm value) {
        return new JAXBElement<UpdateFilm>(_UpdateFilm_QNAME, UpdateFilm.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFilm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://withAuth/", name = "deleteFilm")
    public JAXBElement<DeleteFilm> createDeleteFilm(DeleteFilm value) {
        return new JAXBElement<DeleteFilm>(_DeleteFilm_QNAME, DeleteFilm.class, null, value);
    }

}
