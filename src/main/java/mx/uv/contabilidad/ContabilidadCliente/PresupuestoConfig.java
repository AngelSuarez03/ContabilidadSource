package mx.uv.contabilidad.ContabilidadCliente;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class PresupuestoConfig {

    @Bean
    @Qualifier("marshallerPresupuesto")
    public Jaxb2Marshaller marshallerPresupuesto(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // revisar en el pom.xml <packageName>
        marshaller.setContextPath("xx.mx.uv.presupuesto.wsdl");
        return marshaller;
    }

    @Bean
    public PresupuestoCliente clientePresupuesto(@Qualifier("marshallerPresupuesto") Jaxb2Marshaller marshallerCompra){
        PresupuestoCliente c = new PresupuestoCliente();
        // URI donde está el servicio
        c.setDefaultUri("https://presupuestoservicio-production.up.railway.app/ws/presupuesto.wsdl");
        c.setMarshaller(marshallerCompra);
        c.setUnmarshaller(marshallerCompra);
        return c;
    }
}
