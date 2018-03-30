package ar.com.imango.examen;

import ar.com.imango.examen.model.Loans;
import ar.com.imango.examen.model.Users;
import ar.com.imango.examen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@EnableJpaAuditing
@SpringBootApplication
public class ExamenApplication implements CommandLineRunner{

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Set<Users> usuarios = new HashSet();
		usuarios.add(new Users("test1@app.com.ar", "PEPE", "ARGENTO"));
		usuarios.add(new Users("test2@app.com.ar", "MONICA", "ARGENTO"));
		usuarios.add(new Users("test3@app.com.ar", "PAOLA", "ARGENTO"));
		usuarios.add(new Users("test4@app.com.ar", "COQUI", "ARGENTO"));

		for(Users usuario: usuarios) {
			usuario.setLoans(this.setLoans(usuario));
			repository.save(usuario);
		}

	}

	private Set<Loans> setLoans(Users usuario) {
		Set<Loans> loans = new HashSet<>();
		loans.add(new Loans(2500.0, usuario));
		loans.add(new Loans(2400.0, usuario));
		loans.add(new Loans(2200.0, usuario));
		loans.add(new Loans(2300.0, usuario));
		return loans;
	}
}
