package Security.Basic_Authentication.Service;

import Security.Basic_Authentication.Entity.UserAuthEntity;
import Security.Basic_Authentication.Repo.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    private UserAuthRepository userAuthRepository;

    public UserAuthEntity save(UserAuthEntity user) {
        return userAuthRepository.save(user);
    }

    public List<UserAuthEntity> showAll() {
        return userAuthRepository.findAll();
    }

    @Override
    public UserAuthEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAuthRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}

