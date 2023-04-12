package mierim.model.repository.autocontidas;

import mierim.model.entity.autocontida.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

    @Query(" select s from cad_municipio s where upper( s.sigla_uf ) like upper( :siglauf ) " )
    List<Municipio> findBySiglaUfMunicipio(@Param("siglauf") String siglauf);

}
