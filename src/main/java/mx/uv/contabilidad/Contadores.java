package mx.uv.contabilidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity 
public class Contadores {   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer Id;
    String folioInventario;
    String NombreProducto;
    int cantidad;
    double Precio;
    double PresupuestoDependencia;
    boolean pagoPosible;
    String folioContabilidad;

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public String getFolioInventario() {
        return folioInventario;
    }
    public void setFolioInventario(String FolioInventario) {
        folioInventario = FolioInventario;
    }
    public String getNombreProducto() {
        return NombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getPrecio() {
        return Precio;
    }
    public void setPrecio(double precio) {
        Precio = precio;
    }
    public double getPresupuestoDependencia() {
        return PresupuestoDependencia;
    }
    public void setPresupuestoDependencia(double presupuestoDependencia) {
        PresupuestoDependencia = presupuestoDependencia;
    }
    public String getFolioContabilidad() {
        return folioContabilidad;
    }
    public void setFolioContabilidad(String FolioContabilidad) {
        folioContabilidad = FolioContabilidad;
    }
    public boolean isPagoPosible() {
        return pagoPosible;
    }
    public void setPagoPosible(boolean pagoPosible) {
        this.pagoPosible = pagoPosible;
    }
}
