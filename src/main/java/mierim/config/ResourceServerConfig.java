package mierim.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .antMatchers(
                        "/api/atividadetimesheet/**",
                        "/api/AtividadeTimesheetIdioma/**",
                        "/api/caso/**",
                        "/api/casoexcecaocategoria/**",
                        "/api/casoexcecaoprofissional/**",
                        "/api/casohistorico/**",
                        "/api/casoparticipacao/**",
                        "/api/categoria/**",
                        "/api/cliente/**",
                        "/api/jur_objeto/",
                        "/api/jur_tipocompromisso/",
                        "/api/jur_tipoenvolvimento/",
                        "/api/jur_tipopedido/",
                        "/api/jur_tiporesponsabilidade/",
                        "/api/jur_tipovalor/",
                        "/api/jur_motivo_encerramento/",
                        "/api/jur_area_juridica/",
                        "/api/profissional/",
                        "/api/municipio/",
                        "/api/company_empresa/",
                        "/api/company_group/"
                        ).authenticated()
                .anyRequest().denyAll();

        ;
    }
}
