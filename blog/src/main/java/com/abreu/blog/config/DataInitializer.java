package com.abreu.blog.config;
import com.abreu.blog.model.Category;
import com.abreu.blog.model.Pessoa;
import com.abreu.blog.model.User;
import com.abreu.blog.repository.CategoryRepository;
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
    private CategoryRepository categoryRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public void run(String... args) {

        Pessoa p1 = new Pessoa();
        p1.setFullName("Miguel");
        p1.setBio("Miguel é o admin do blog");

        pessoaRepository.save(p1);

        Pessoa p2 = new Pessoa();
        p2.setFullName("Luis");
        p2.setBio("Luis é o user do blog");

        pessoaRepository.save(p2);

        Category c1 = new Category();
        c1.setCategoryTitle("DESPORTO");
        c1.setCategoryDescription("Desporto do blog");

        categoryRepository.save(c1);

        Category c2 = new Category();
        c2.setCategoryTitle("BELEZA");
        c2.setCategoryDescription("Beleza do blog");

        categoryRepository.save(c2);

        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword(passwordEncoder.encode("password"));
        user1.setPessoa(p1);
        user1.setRole(ADMIN);
        userRepository.save(user1);

        User user2 = new User();
        user2.setUsername("user");
        user2.setPassword(passwordEncoder.encode("password"));
        user2.setPessoa(p2);
        user2.setRole(USER);
        userRepository.save(user2);

    }
}
