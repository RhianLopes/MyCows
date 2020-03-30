package br.com.rhianlopes.mycows.security;

import br.com.rhianlopes.mycows.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

/*
* Service para obter dados do usuário no contexto de autenticação
*/
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = getUser(() -> userRepository.findByEmail(username));
        return UserPrincipal.create(user);
    }

    public UserDetails loadUserById(Long id) {
        User user = getUser(() -> userRepository.findById(id));
        return UserPrincipal.create(user);
    }

    private User getUser(Supplier<Optional<User>> supplier) {
        return supplier.get().orElseThrow(() ->
            new UsernameNotFoundException("Usuário não cadastrado")
        );
    }
}
