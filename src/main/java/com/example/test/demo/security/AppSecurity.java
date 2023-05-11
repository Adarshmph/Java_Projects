//package com.example.test.demo.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//@ComponentScan
//public class AppSecurity extends WebSecurityConfiguration {
//	
//	@Autowired
//	private UserDetailsService userDetailsService;
//
////    @Bean
////    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
////         http
////        .cors().and()
////        .csrf().disable().authorizeHttpRequests()
////        .requestMatchers("/user").hasRole("user")
////        .anyRequest().authenticated()
////        .and()
////        .formLogin();
////         return http.build();
////    }
//    
//    @Bean
//    public AuthenticationProvider authProvider(){
//    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//    	provider.setUserDetailsService(userDetailsService);
//    	provider.setPasswordEncoder(new BCryptPasswordEncoder());
//    	return provider;
//    }
//	
//}
