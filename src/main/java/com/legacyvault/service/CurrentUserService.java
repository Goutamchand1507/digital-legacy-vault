package com.legacyvault.service;
import com.legacyvault.entity.UserAccount; import com.legacyvault.repository.UserAccountRepository; import org.springframework.security.core.Authentication; import org.springframework.stereotype.Service;
@Service public class CurrentUserService {
 private final UserAccountRepository users; public CurrentUserService(UserAccountRepository u){users=u;}
 public UserAccount require(Authentication a){return users.findByEmail(a.getName().toLowerCase()).orElseThrow(()->new IllegalStateException("Account not found"));}
}
