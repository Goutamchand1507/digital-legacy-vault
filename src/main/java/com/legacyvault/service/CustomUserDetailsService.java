package com.legacyvault.service;
import com.legacyvault.repository.UserAccountRepository; import org.springframework.security.core.userdetails.*; import org.springframework.stereotype.Service;
@Service public class CustomUserDetailsService implements UserDetailsService {
 private final UserAccountRepository users; public CustomUserDetailsService(UserAccountRepository u){users=u;}
 public UserDetails loadUserByUsername(String email){var u=users.findByEmail(email.toLowerCase()).orElseThrow(()->new UsernameNotFoundException("Account not found"));return User.withUsername(u.getEmail()).password(u.getPassword()).roles("USER").build();}
}
