package mierim.model.repository.autocontidas;

import mierim.model.entity.autocontida.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {

    @Query(" select s from cad_municipio s where upper( s.sigla_uf ) like upper( :siglauf ) " )
    List<Municipio> findBySiglaUfMunicipio(@Param("siglauf") String siglauf);

    @Query(" select distinct new mierim.rest.dto.EstadoDTO(s.cod_uf, s.sigla_uf, s.nome_uf) from cad_municipio s where upper( s.sigla_pais ) like upper( :siglapais ) order by 1" )
    List<Object[]> findByUf(@Param("siglapais") String siglapais);

    @Query(" select distinct new mierim.rest.dto.MunicipioDTO(s.id, s.cod_mun, s.cod_mun_comp, s.nome_mun) from cad_municipio s where upper( s.sigla_uf ) like upper( :siglmun ) order by 1" )
    List<Object[]> findByMunicipio(@Param("siglmun") String siglmun);

    @Query(" select distinct new mierim.rest.dto.PaisDTO(s.cod_pais, s.sigla_pais, s.nome_pais) from cad_municipio s  order by 1" )
    List<Object[]> findByPais();
}
