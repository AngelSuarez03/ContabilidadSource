package mx.uv.contabilidad;

import org.springframework.data.repository.CrudRepository;

public interface IContabilidad extends CrudRepository < Contadores,Integer >{
    Contadores findByFolioContabilidad(String folio);
}
