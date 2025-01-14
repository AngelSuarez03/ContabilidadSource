
package xx.mx.uv.presupuesto.wsdl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "presupuestoPortService", targetNamespace = "t4is.uv.mx/presupuesto", wsdlLocation = "https://presupuestoservicio-production.up.railway.app/ws/presupuesto.wsdl")
public class PresupuestoPortService
    extends Service
{

    private final static URL PRESUPUESTOPORTSERVICE_WSDL_LOCATION;
    private final static WebServiceException PRESUPUESTOPORTSERVICE_EXCEPTION;
    private final static QName PRESUPUESTOPORTSERVICE_QNAME = new QName("t4is.uv.mx/presupuesto", "presupuestoPortService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://presupuestoservicio-production.up.railway.app/ws/presupuesto.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PRESUPUESTOPORTSERVICE_WSDL_LOCATION = url;
        PRESUPUESTOPORTSERVICE_EXCEPTION = e;
    }

    public PresupuestoPortService() {
        super(__getWsdlLocation(), PRESUPUESTOPORTSERVICE_QNAME);
    }

    public PresupuestoPortService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PRESUPUESTOPORTSERVICE_QNAME, features);
    }

    public PresupuestoPortService(URL wsdlLocation) {
        super(wsdlLocation, PRESUPUESTOPORTSERVICE_QNAME);
    }

    public PresupuestoPortService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PRESUPUESTOPORTSERVICE_QNAME, features);
    }

    public PresupuestoPortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PresupuestoPortService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PresupuestoPort
     */
    @WebEndpoint(name = "presupuestoPortSoap11")
    public PresupuestoPort getPresupuestoPortSoap11() {
        return super.getPort(new QName("t4is.uv.mx/presupuesto", "presupuestoPortSoap11"), PresupuestoPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PresupuestoPort
     */
    @WebEndpoint(name = "presupuestoPortSoap11")
    public PresupuestoPort getPresupuestoPortSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("t4is.uv.mx/presupuesto", "presupuestoPortSoap11"), PresupuestoPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PRESUPUESTOPORTSERVICE_EXCEPTION!= null) {
            throw PRESUPUESTOPORTSERVICE_EXCEPTION;
        }
        return PRESUPUESTOPORTSERVICE_WSDL_LOCATION;
    }

}
