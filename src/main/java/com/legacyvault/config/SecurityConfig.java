package com.legacyvault.config;
import com.legacyvault.service.CustomUserDetailsService; import org.springframework.context.annotation.*; import org.springframework.security.authentication.dao.DaoAuthenticationProvider; import org.springframework.security.config.annotation.web.builders.HttpSecurity; import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.security.web.SecurityFilterChain;
@Configuration public class SecurityConfig {
 @Bean PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
 @Bean DaoAuthenticationProvider authenticationProvider(CustomUserDetailsService s,PasswordEncoder e){DaoAuthenticationProvider p=new DaoAuthenticationProvider();p.setUserDetailsService(s);p.setPasswordEncoder(e);return p;}
 @Bean SecurityFilterChain securityFilterChain(HttpSecurity h,DaoAuthenticationProvider p)throws Exception{h.authenticationProvider(p).authorizeHttpRequests(a->a.requestMatchers("/","/register","/css/**","/js/**","/error").permitAll().anyRequest().authenticated()).formLogin(f->f.loginPage("/login").defaultSuccessUrl("/dashboard",true).permitAll()).logout(l->l.logoutSuccessUrl("/login?logout").permitAll());return h.build();}
}
