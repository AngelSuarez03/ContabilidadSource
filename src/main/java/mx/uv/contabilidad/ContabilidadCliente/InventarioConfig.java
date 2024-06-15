package mx.uv.contabilidad.ContabilidadCliente;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class InventarioConfig {

    @Bean
    @Qualifier("marshallerInventario")
    public Jaxb2Marshaller marshallerInventario(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // revisar en el pom.xml <packageName>
        marshaller.setContextPath("xx.mx.uv.inventario.wsdl");
        return marshaller;
    }

    @Bean
    public InventarioCliente clienteInventario(@Qualifier("marshallerInventario") Jaxb2Marshaller marshallerInventario){
        InventarioCliente c = new InventarioCliente();
        // URI donde está el servicio
        c.setDefaultUri("https://inventariows-production.up.railway.app/ws/inventario.wsdl");
        c.setMarshaller(marshallerInventario);
        c.setUnmarshaller(marshallerInventario);
        return c;
    }

}
