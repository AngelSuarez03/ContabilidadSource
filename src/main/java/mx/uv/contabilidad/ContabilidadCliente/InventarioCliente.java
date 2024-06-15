package mx.uv.contabilidad.ContabilidadCliente;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import xx.mx.uv.inventario.wsdl.ValidarFolioRequest;
import xx.mx.uv.inventario.wsdl.ValidarFolioResponse;

public class InventarioCliente extends WebServiceGatewaySupport{

    public ValidarFolioResponse validarFolio(ValidarFolioRequest request) {
        try {
            return (ValidarFolioResponse) getWebServiceTemplate()
                    .marshalSendAndReceive(request, new SoapActionCallback("https://inventariows-production.up.railway.app/ws/inventario.wsdl"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }

    }
}
