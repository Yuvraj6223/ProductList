package com.bitsbytes.Product.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitsbytes.Product.Dto.UserDTO;
import com.bitsbytes.Product.Service.MyUserDetailsService;
import com.bitsbytes.Product.entity.User;
import com.bitsbytes.Product.security.JwtUtil;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
        @Autowired
        private AuthenticationManager authenticationManager;
        
        @Autowired
        private MyUserDetailsService userDetailsService;

        @PostMapping("/register")
        public User register(@RequestBody User user){
                return userDetailsService.createUser(user);
        }

        @PostMapping("/login")
        public String login(@RequestBody UserDTO user){
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            
            List<String>roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
            return jwtUtil.generateToken(userDetails.getUsername(), roles);
        }
    }