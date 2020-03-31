package br.com.rhianlopes.mycows.security;

import br.com.rhianlopes.mycows.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserPrincipal implements UserDetails {

    private Long id;

    private String email;

    private String name;

    @JsonIgnore
    private String password;

    private String phone;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(User user) {

        List<GrantedAuthority> authorities = Arrays.asList(
                new SimpleGrantedAuthority(user.getProfile().getRole())
        );

        return new UserPrincipal(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhone(),
                user.getCreatedAt(),
                user.getCreatedAt(),
                authorities
        );
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return email;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}