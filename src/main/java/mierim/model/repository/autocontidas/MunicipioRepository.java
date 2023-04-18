package mierim.model.repository.autocontidas;

import mierim.model.entity.autocontida.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

    @Query(" select s from cad_municipio s where upper( s.sigla_uf ) like upper( :siglauf ) " )
    List<Municipio> findBySiglaUfMunicipio(@Param("siglauf") String siglauf);

    @Query(" select distinct s.sigla_uf from cad_municipio s where upper( s.sigla_pais ) like upper( :siglapais ) order by 1" )
    List<Object[]> findByUf(@Param("siglapais") String siglapais);

    @Query(" select s.nome_mun from cad_municipio s where upper( s.sigla_uf ) like upper( :siglmun ) order by 1" )
        List<Object[]> findByMunicipio(@Param("siglmun") String siglmun);

    @Query(" select distinct s.sigla_pais from cad_municipio s  order by 1" )
    List<Object[]> findByPais();
}
