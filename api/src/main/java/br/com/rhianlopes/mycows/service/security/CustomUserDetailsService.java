package br.com.rhianlopes.mycows.service.security;

import br.com.rhianlopes.mycows.domain.User;
import br.com.rhianlopes.mycows.repository.UserRepository;
import br.com.rhianlopes.mycows.domain.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author rhian.costa
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
            new UsernameNotFoundException("User not registered")
        );
    }
}
