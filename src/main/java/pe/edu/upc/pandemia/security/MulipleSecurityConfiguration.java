package pe.edu.upc.pandemia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity

public class MulipleSecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Configuration
	@Order(1)
	public class PacienteSecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Autowired
		private MyUserDetailsService myUserDetailsService;
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			    .antMatchers("/","/auth/**").permitAll()
			.and()
			.formLogin()
			.loginProcessingUrl("/signin")
			.loginPage("/login" ).permitAll()
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
			.logout()
			 .logoutRequestMatcher(AntPathRequestMatcher("/signin"))
             .logoutSuccessUrl("/")	
             
			;
	}

	
	

	private RequestMatcher AntPathRequestMatcher(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Bean 
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	// Aqui se crea el vinculo entre el Spring security y el PasswordEncoder y UserDetailsService
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.myUserDetailsService);
		return daoAuthenticationProvider;
	}
}

	
	
	
	}