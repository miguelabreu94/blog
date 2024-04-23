package com.abreu.blog.controller;
import com.abreu.blog.model.Pessoa;
import com.abreu.blog.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PessoaController {

    private PessoaService service;

    @GetMapping("/pessoa/{id}")
    public Optional<Pessoa> getPessoa(@PathVariable int id) {
        return service.getPessoa(id);
    }

    @GetMapping("/pessoa")
    public List<Pessoa> getAll() {
        return service.getAllPessoas();
    }

    @PostMapping("/pessoa")
    public Pessoa save(@RequestBody Pessoa pessoa) {
        return service.save(pessoa);
    }

    @PutMapping("/pessoa/{id}")
    public Pessoa update(@PathVariable int id, @RequestBody Pessoa pessoa) {
        return service.update(id,pessoa);
    }

    @DeleteMapping("/pessoa/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
