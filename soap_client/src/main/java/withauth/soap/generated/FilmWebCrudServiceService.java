
package withauth.soap.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "FilmWebCrudServiceService", targetNamespace = "http://withAuth/", wsdlLocation = "http://localhost:8081/FilmService?wsdl")
public class FilmWebCrudServiceService
    extends Service
{

    private final static URL FILMWEBCRUDSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException FILMWEBCRUDSERVICESERVICE_EXCEPTION;
    private final static QName FILMWEBCRUDSERVICESERVICE_QNAME = new QName("http://withAuth/", "FilmWebCrudServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8081/FilmService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FILMWEBCRUDSERVICESERVICE_WSDL_LOCATION = url;
        FILMWEBCRUDSERVICESERVICE_EXCEPTION = e;
    }

    public FilmWebCrudServiceService() {
        super(__getWsdlLocation(), FILMWEBCRUDSERVICESERVICE_QNAME);
    }

    public FilmWebCrudServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FILMWEBCRUDSERVICESERVICE_QNAME, features);
    }

    public FilmWebCrudServiceService(URL wsdlLocation) {
        super(wsdlLocation, FILMWEBCRUDSERVICESERVICE_QNAME);
    }

    public FilmWebCrudServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FILMWEBCRUDSERVICESERVICE_QNAME, features);
    }

    public FilmWebCrudServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FilmWebCrudServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FilmService
     */
    @WebEndpoint(name = "FilmServicePort")
    public FilmService getFilmServicePort() {
        return super.getPort(new QName("http://withAuth/", "FilmServicePort"), FilmService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FilmService
     */
    @WebEndpoint(name = "FilmServicePort")
    public FilmService getFilmServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://withAuth/", "FilmServicePort"), FilmService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FILMWEBCRUDSERVICESERVICE_EXCEPTION!= null) {
            throw FILMWEBCRUDSERVICESERVICE_EXCEPTION;
        }
        return FILMWEBCRUDSERVICESERVICE_WSDL_LOCATION;
    }

}
