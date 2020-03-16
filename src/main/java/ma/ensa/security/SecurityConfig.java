package ma.ensa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private void globalConfig(AuthenticationManagerBuilder auth) throws Exception{
		auth
		.authenticationProvider(authenticationProvider());
	}
	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		  
		  http
		  .httpBasic()
		  .and()
		     .authorizeRequests()
		        .antMatchers("/")
		           .permitAll()
		  .and()
		    .authorizeRequests()
		      .antMatchers("/conferences").authenticated()
                  .antMatchers("/conferences/**").hasRole("ADMIN")
                  	;
		  		  
	                
}
	
	
	  @Bean
	  DaoAuthenticationProvider authenticationProvider(){
	        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
	        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
	        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
	        return daoAuthenticationProvider;
	    }
	
	

}
