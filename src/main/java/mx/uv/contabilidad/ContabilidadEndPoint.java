package mx.uv.contabilidad;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mx.uv.contabilidad.ContabilidadCliente.InventarioCliente;
import mx.uv.contabilidad.ContabilidadCliente.PresupuestoCliente;
import mx.uv.t4is.contabilidad.SolicitarPagoRequest;
import mx.uv.t4is.contabilidad.SolicitarPagoResponse;
import mx.uv.t4is.contabilidad.ValidarPagoRequest;
import mx.uv.t4is.contabilidad.ValidarPagoResponse;
import xx.mx.uv.inventario.wsdl.ValidarFolioRequest;
import xx.mx.uv.inventario.wsdl.ValidarFolioResponse;
import xx.mx.uv.presupuesto.wsdl.SolicitarPagoPresupuestoRequest;
import xx.mx.uv.presupuesto.wsdl.SolicitarPagoPresupuestoResponse;

@Endpoint
public class ContabilidadEndPoint {
    @Autowired
    private IContabilidad icONTABILIDAD;

    @Autowired
    private InventarioCliente inventarioCliente;

    @Autowired
    private PresupuestoCliente presupuestoCliente;

    @PayloadRoot(localPart = "SolicitarPagoRequest", namespace = "t4is.uv.mx/contabilidad")
    @ResponsePayload
    public SolicitarPagoResponse validarPago(@RequestPayload SolicitarPagoRequest contabilidad) {
        SolicitarPagoResponse response = new SolicitarPagoResponse();
        ValidarFolioRequest validarFolioRequest = new ValidarFolioRequest();
        validarFolioRequest.setFolioInventario(contabilidad.getFolioInventario());
        ValidarFolioResponse validarFolioResponse = inventarioCliente.validarFolio(validarFolioRequest);
        if (validarFolioResponse.isEstatus() == true) {
            UUID uuid = UUID.randomUUID();
            Contadores contadores = new Contadores();
            contadores.setCantidad(contabilidad.getCantidad());
            contadores.setFolioInventario(contabilidad.getFolioInventario());
            contadores.setNombreProducto(contabilidad.getNombreProducto());
            contadores.setPrecio(contabilidad.getPrecio());
            contadores.setId(null);
            contadores.setPresupuestoDependencia(contabilidad.getPresupuestoDependencia());
            contadores.setFolioContabilidad(uuid.toString());
            SolicitarPagoPresupuestoRequest solicitarPagoPresupuestoRequest = new SolicitarPagoPresupuestoRequest();
            solicitarPagoPresupuestoRequest.setNombreProducto(contabilidad.getNombreProducto());
            solicitarPagoPresupuestoRequest.setCantidad(contabilidad.getCantidad());
            solicitarPagoPresupuestoRequest.setPrecio(contabilidad.getPrecio());
            solicitarPagoPresupuestoRequest.setPresupuesto(contabilidad.getPresupuestoDependencia());
            SolicitarPagoPresupuestoResponse solicitarPagoPresupuestoResponse = presupuestoCliente
            .solicitarPresupuesto(solicitarPagoPresupuestoRequest);
            contadores.setPagoPosible(solicitarPagoPresupuestoResponse.isStatus());
            icONTABILIDAD.save(contadores);
            response.setRespuesta("Pago Solicitado");
            response.setFolioContabilidad(uuid.toString());
        } else {
            response.setRespuesta("No se ha podido solicitar el pago :(");
            response.setFolioContabilidad("000000000");
        }
        return response;
    }

    @PayloadRoot(localPart = "ValidarPagoRequest", namespace = "t4is.uv.mx/contabilidad")
    @ResponsePayload
    public ValidarPagoResponse validarPago(@RequestPayload ValidarPagoRequest request) {
        Contadores folios = icONTABILIDAD.findByFolioContabilidad(request.getFolioContabilidad());
        ValidarPagoResponse response = new ValidarPagoResponse();
        if (folios.isPagoPosible() == true) {
            response.setPagoStatus("Pago realizado");
            response.setStatus(folios.isPagoPosible());
        }else if (folios.isPagoPosible() == false){
            response.setPagoStatus("Presupuesto excedido");
            response.setStatus(false);
        }
        return response;
    }

}
