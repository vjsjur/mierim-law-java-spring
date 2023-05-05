package mierim.service;

import mierim.rest.exception.UsuarioCadastradoException;
import mierim.model.entity.sistema.Sis_Usuario;
import mierim.model.repository.sistema.Sis_UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Sis_UsuarioService implements UserDetailsService {

    @Autowired
    private Sis_UsuarioRepository repository;

    public Sis_Usuario salvar(Sis_Usuario usuario){
        boolean exists = repository.existsByUsuario(usuario.getUsuario());
        if(exists){
            throw new UsuarioCadastradoException(usuario.getUsuario());
        }
        return repository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        Sis_Usuario usuario = repository
                .findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Login não encontrado.") );

        return User
                .builder()
                .username(usuario.getUsuario())
                .password(usuario.getSenha())
                .roles("USER")
                .build()
                ;
    }
}
