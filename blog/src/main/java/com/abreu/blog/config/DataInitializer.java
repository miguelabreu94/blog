package com.abreu.blog.config;
import com.abreu.blog.model.Pessoa;
import com.abreu.blog.model.User;
import com.abreu.blog.repository.PessoaRepository;
import com.abreu.blog.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import static com.abreu.blog.model.Role.ADMIN;
import static com.abreu.blog.model.Role.USER;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public void run(String... args) {

        Pessoa p1 = new Pessoa();
        p1.setFullName("Luís Miguel Alves de Abreu");
        p1.setBio("Sou o criador deste blog");

        pessoaRepository.save(p1);

        Pessoa p2 = new Pessoa();
        p2.setFullName("Joao Alves de Abreu");
        p2.setBio("Joao é o utilizador do blog");

        pessoaRepository.save(p2);


        User user1 = new User();
        user1.setUsername("labreu");
        user1.setPassword(passwordEncoder.encode("password"));
        user1.setPessoa(p1);
        user1.setRole(ADMIN);
        userRepository.save(user1);

        User user2 = new User();
        user2.setUsername("jabreu");
        user2.setPassword(passwordEncoder.encode("password"));
        user2.setPessoa(p2);
        user2.setRole(USER);
        userRepository.save(user2);

    }
}
