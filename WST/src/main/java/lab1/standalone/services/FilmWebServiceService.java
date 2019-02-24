
package lab1.standalone.services;

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
@WebServiceClient(name = "FilmWebServiceService", targetNamespace = "http://services.lab1.standalone.lab1/", wsdlLocation = "http://localhost:8081/FilmService?wsdl")
public class FilmWebServiceService
    extends Service
{

    private final static URL FILMWEBSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException FILMWEBSERVICESERVICE_EXCEPTION;
    private final static QName FILMWEBSERVICESERVICE_QNAME = new QName("http://services.lab1.standalone.lab1/", "FilmWebServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8081/FilmService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FILMWEBSERVICESERVICE_WSDL_LOCATION = url;
        FILMWEBSERVICESERVICE_EXCEPTION = e;
    }

    public FilmWebServiceService() {
        super(__getWsdlLocation(), FILMWEBSERVICESERVICE_QNAME);
    }

    public FilmWebServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FILMWEBSERVICESERVICE_QNAME, features);
    }

    public FilmWebServiceService(URL wsdlLocation) {
        super(wsdlLocation, FILMWEBSERVICESERVICE_QNAME);
    }

    public FilmWebServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FILMWEBSERVICESERVICE_QNAME, features);
    }

    public FilmWebServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FilmWebServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FilmService
     */
    @WebEndpoint(name = "FilmServicePort")
    public FilmService getFilmServicePort() {
        return super.getPort(new QName("http://services.lab1.standalone.lab1/", "FilmServicePort"), FilmService.class);
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
        return super.getPort(new QName("http://services.lab1.standalone.lab1/", "FilmServicePort"), FilmService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FILMWEBSERVICESERVICE_EXCEPTION!= null) {
            throw FILMWEBSERVICESERVICE_EXCEPTION;
        }
        return FILMWEBSERVICESERVICE_WSDL_LOCATION;
    }

}
