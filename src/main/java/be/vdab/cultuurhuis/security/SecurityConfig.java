package be.vdab.cultuurhuis.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
private final DataSource dataSource;

    SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override public void configure(WebSecurity web) {
        web.ignoring()
                .mvcMatchers("/images/**")
.mvcMatchers("/css/**")
                .mvcMatchers("/js/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select gebruikersnaam as username, " +
                                "paswoord as password from klanten" +
                                " where gebruikersnaam= ?")
        .authoritiesByUsernameQuery("select" )
              ;
    }



@Override
   protected void configure(HttpSecurity http)throws Exception{
http.formLogin(login-> login.loginPage("/login"));
http.authorizeRequests(requests-> requests
        .mvcMatchers("/**").permitAll()
        .mvcMatchers("/bevestigd").authenticated());
// http.logout(logout->logout.logoutSuccessUrl())
    }


}
