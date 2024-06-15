package mx.uv.contabilidad.ContabilidadCliente;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import xx.mx.uv.presupuesto.wsdl.SolicitarPagoPresupuestoRequest;
import xx.mx.uv.presupuesto.wsdl.SolicitarPagoPresupuestoResponse;

public class PresupuestoCliente extends WebServiceGatewaySupport{

    public SolicitarPagoPresupuestoResponse solicitarPresupuesto(SolicitarPagoPresupuestoRequest request) {
        try {
            return (SolicitarPagoPresupuestoResponse) getWebServiceTemplate()
                    .marshalSendAndReceive(request, new SoapActionCallback("https://presupuestoservicio-production.up.railway.app/ws/presupuesto.wsdl"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }

    }
}
