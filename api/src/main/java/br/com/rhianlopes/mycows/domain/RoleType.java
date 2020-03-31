package br.com.rhianlopes.mycows.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum RoleType {

    USER("ROLE_USER");

    private final String role;
}
