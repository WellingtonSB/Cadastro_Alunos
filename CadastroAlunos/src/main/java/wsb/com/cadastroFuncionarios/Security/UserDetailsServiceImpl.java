package wsb.com.cadastroFuncionarios.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import wsb.com.cadastroFuncionarios.Model.Diretor;
import wsb.com.cadastroFuncionarios.Repository.DiretorRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private DiretorRepository repository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Diretor> user = repository.findByUsuario(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

		return user.map(UserDetailsImpl::new).get();
	}

}
