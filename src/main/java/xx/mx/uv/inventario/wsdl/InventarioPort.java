
package xx.mx.uv.inventario.wsdl;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "inventarioPort", targetNamespace = "t4is.uv.mx/inventario")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface InventarioPort {


    /**
     * 
     * @param validarFolioRequest
     * @return
     *     returns xx.mx.uv.inventario.wsdl.ValidarFolioResponse
     */
    @WebMethod(operationName = "ValidarFolio")
    @WebResult(name = "ValidarFolioResponse", targetNamespace = "t4is.uv.mx/inventario", partName = "ValidarFolioResponse")
    public ValidarFolioResponse validarFolio(
        @WebParam(name = "ValidarFolioRequest", targetNamespace = "t4is.uv.mx/inventario", partName = "ValidarFolioRequest")
        ValidarFolioRequest validarFolioRequest);

}