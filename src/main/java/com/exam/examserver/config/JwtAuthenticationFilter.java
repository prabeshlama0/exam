package com.exam.examserver.config;

import com.exam.examserver.Service.Impl.UserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");
        System.out.println(" Token Validation check point");
        String userName = null;
        String jwtToken = null;
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            //yes
            jwtToken = requestTokenHeader.substring(7);
            try {
                userName = jwtUtil.extractUsername(jwtToken);

            } catch (ExpiredJwtException e) {
                e.printStackTrace();
                System.out.println("jwt token has expired");
            }


            //validate
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // token is valid
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
                System.out.println("Token is not Valid");


        }
        filterChain.doFilter(request, response);
    }
}
