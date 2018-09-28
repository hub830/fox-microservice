package top.lemna.user.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import top.lemna.user.persistence.entity.Privilege;
import top.lemna.user.persistence.entity.Role;
import top.lemna.user.persistence.service.UserService;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomUserDetailsService implements UserDetailsService {

  private UserService userService;


  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    Optional<top.lemna.user.persistence.entity.User> optional =
        userService.findByUsername(username);
    top.lemna.user.persistence.entity.User user = optional
        .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found."));

    return new User(user.getUsername(), user.getPassword(), true, true, true, user.isLocked(),
        getAuthorities(user.getRoles()));
  }



  private Collection<? extends GrantedAuthority> getAuthorities(final Collection<Role> roles) {
    return getGrantedAuthorities(getPrivileges(roles));
  }

  private List<String> getPrivileges(final Collection<Role> roles) {
    final List<String> privileges = new ArrayList<String>();
    final List<Privilege> collection = new ArrayList<Privilege>();
    for (final Role role : roles) {
      collection.addAll(role.getPrivileges());
    }
    for (final Privilege item : collection) {
      privileges.add(item.getOperation());
    }
    return privileges;
  }

  private List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
    final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    for (final String privilege : privileges) {
      authorities.add(new SimpleGrantedAuthority(privilege));
    }
    return authorities;
  }



}
