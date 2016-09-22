
package learningjava.client.impl;

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
@WebServiceClient(name = "EchoServiceService", targetNamespace = "http://webservices/", wsdlLocation = "http://localhost:8080/echo?wsdl")
public class EchoServiceService
    extends Service
{

    private final static URL ECHOSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException ECHOSERVICESERVICE_EXCEPTION;
    private final static QName ECHOSERVICESERVICE_QNAME = new QName("http://webservices/", "EchoServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/echo?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ECHOSERVICESERVICE_WSDL_LOCATION = url;
        ECHOSERVICESERVICE_EXCEPTION = e;
    }

    public EchoServiceService() {
        super(__getWsdlLocation(), ECHOSERVICESERVICE_QNAME);
    }

    public EchoServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ECHOSERVICESERVICE_QNAME, features);
    }

    public EchoServiceService(URL wsdlLocation) {
        super(wsdlLocation, ECHOSERVICESERVICE_QNAME);
    }

    public EchoServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ECHOSERVICESERVICE_QNAME, features);
    }

    public EchoServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EchoServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns EchoService
     */
    @WebEndpoint(name = "EchoServicePort")
    public EchoService getEchoServicePort() {
        return super.getPort(new QName("http://webservices/", "EchoServicePort"), EchoService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EchoService
     */
    @WebEndpoint(name = "EchoServicePort")
    public EchoService getEchoServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices/", "EchoServicePort"), EchoService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ECHOSERVICESERVICE_EXCEPTION!= null) {
            throw ECHOSERVICESERVICE_EXCEPTION;
        }
        return ECHOSERVICESERVICE_WSDL_LOCATION;
    }

}
