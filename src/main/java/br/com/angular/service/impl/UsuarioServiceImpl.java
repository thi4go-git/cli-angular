package br.com.angular.service.impl;

import br.com.angular.model.entity.Usuario;
import br.com.angular.model.repository.UsuarioRepository;
import br.com.angular.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UserDetailsService, UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Login Não encontrado!"));


        System.out.println("banco: " + usuario.getPassword());
        return User
                .builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(usuario.getPermissao())
                .build();

    }

    @Override
    public Usuario salvar(Usuario usuario) {
        String senhaCript = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(senhaCript);
        return usuarioRepository.save(usuario);
    }
}
