package mierim.model.entity.autocontida;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="cad_evento")
public class Evento implements Serializable{
    
    
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     @Column(name="id_evento")
     private Long id;
     
     @Column(name="titulo_evento")
     private String titulo;
     
     @Column(name="incio_evento")
     private Date incio;
     
     @Column(name="fim_evento")
     private Date fim;
     
     @Column(name="desc_evento")
     private String descricao;
     
     @Column(name="status_evento")
     private boolean status;
     

}
