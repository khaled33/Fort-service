package com.sid.Fort.config.Securite;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class JWTAuthorrizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {



//
//

//        HttpServletRequest request = (HttpServletRequest) httpServletRequest;
//        HttpServletResponse response = (HttpServletResponse) httpServletResponse;
//    response.setHeader("Access-Control-Allow-Credentials", "true");
//    response.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,PATCH,OPTIONS");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        httpServletResponse.setHeader("Access-Control-Allow-Origin",  "*");
//
//        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept,Origin, X-Requested-With,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
//
////    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, Authorization");
//        httpServletResponse.setHeader("Access-Control-Expose-Headers","Authorization,Access-Control-Allow-Origin,Access-Control-Allow-Credentials");


//        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
//        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept,Origin, X-Requested-With,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
//        httpServletResponse.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin," +
//                "Access-Control-Allow-Credentials,authorization");
//
//        httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
//        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
//        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
//        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
//        httpServletResponse.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");





//        HttpServletResponse response = (HttpServletResponse) httpServletRequest;
//        HttpServletRequest request = (HttpServletRequest) httpServletResponse;
////
//        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
//        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
//        httpServletResponse.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
//        httpServletResponse.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin," +
//                "Access-Control-Allow-Credentials,Authorization");
//        httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with");
//        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
//        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");

//        if (!httpServletRequest.getMethod().equals("OPTIONS")) {
//
//        }
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
        httpServletResponse.addHeader("Access-Control-Expose-Headers", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials","true");

        if(httpServletRequest.getMethod().equals("OPTIONS")) {

            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
            httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
            httpServletResponse.addHeader("Access-Control-Expose-Headers", "*");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        }else {
            try {
                String jwt = httpServletRequest.getHeader(ConstantSecurity.HEADER_STRING);
                if (jwt == null) {
                    filterChain.doFilter(httpServletRequest, httpServletResponse);
                    return;
                }


                Claims clims = Jwts.parser()
                        .setSigningKey(ConstantSecurity.SECRET)

                        .parseClaimsJws(jwt)
                        .getBody();
                String username = clims.getSubject();


                ArrayList<Map<String, String>> roles = (ArrayList<Map<String, String>>) clims.get("roles");
                Collection<GrantedAuthority> authorities = new ArrayList<>();

                roles.forEach(r -> {
                    authorities.add(new SimpleGrantedAuthority(r.get("authority")));
                });


                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(username, null, authorities);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            } catch(ExpiredJwtException e) {
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);            }
        }






//        if (httpServletRequest.getMethod().equals("OPTIONS")) {
//            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
//        } else {
//            String jwt = httpServletRequest.getHeader(ConstantSecurity.HEADER_STRING);
//            if (jwt == null) {
//                filterChain.doFilter(httpServletRequest, httpServletResponse);
//                return;
//            }
//
//
//            Claims clims = Jwts.parser()
//                    .setSigningKey(ConstantSecurity.SECRET)
//                    .parseClaimsJws(jwt)
//                    .getBody();
//            String username = clims.getSubject();
//
//
//            ArrayList<Map<String, String>> roles = (ArrayList<Map<String, String>>) clims.get("roles");
//            Collection<GrantedAuthority> authorities = new ArrayList<>();
//
//            roles.forEach(r -> {
//                authorities.add(new SimpleGrantedAuthority(r.get("authority")));
//            });
//
//
//            UsernamePasswordAuthenticationToken authenticationToken =
//                    new UsernamePasswordAuthenticationToken(username, null, authorities);
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            filterChain.doFilter(httpServletRequest, httpServletResponse);

//        }


    }
}
