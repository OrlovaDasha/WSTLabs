
package lab3.services;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "WrongIdException", targetNamespace = "http://lab3/")
public class WrongIdException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private FilmServiceFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public WrongIdException(String message, FilmServiceFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public WrongIdException(String message, FilmServiceFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: lab3.services.FilmServiceFault
     */
    public FilmServiceFault getFaultInfo() {
        return faultInfo;
    }

}