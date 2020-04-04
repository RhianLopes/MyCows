package br.com.rhianlopes.mycows.service.security;

import br.com.rhianlopes.mycows.config.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author rhian.costa
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private static final String HEADER_PREFIX = "Bearer ";

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    public String authenticate(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                username,
                password
            )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return HEADER_PREFIX + jwtTokenProvider.generateToken(authentication);
    }
}
