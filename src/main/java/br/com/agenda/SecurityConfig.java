package br.com.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private ImplementsUserDetailsService userDetailsService;
 
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.csrf().disable().authorizeRequests()
		.anyRequest().authenticated()
		.antMatchers("/cadatroAdmin").permitAll()
	    .antMatchers("/cadastro").permitAll()
	    .antMatchers("/").permitAll()
	    .antMatchers("/home").permitAll()
	    .antMatchers("/{nomeCliente}").permitAll()
	    .anyRequest().authenticated()
	    .and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/", true).failureUrl("/login")
	    .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Override
    public void configure(WebSecurity builder) throws Exception {
        builder.ignoring().antMatchers("/bootstrap/**",
        		"/images/**", "/style/**", "/dist/**", "/js/**");
    }
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
