// package com.bitsbytes.Product.security;

// import java.util.Collection;
// import java.util.List;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import com.bitsbytes.Product.entity.User;

// public class UserPrincipal implements UserDetails{

//     private User user;

//     public UserPrincipal(User user){
//         this.user = user;
//     }
//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         return List.of(new SimpleGrantedAuthority( "ROLE_ADMIN"));
//     }

//     @Override
//     public String getPassword() {
//         return user.getPassword();
//     }

//     @Override
//     public String getUsername() {
//         return user.getUsername();
//     }


// }
