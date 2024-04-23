package com.abreu.blog.service;

import com.abreu.blog.model.Pessoa;
import java.util.List;
import java.util.Optional;

public interface PessoaService {

    Optional<Pessoa> getPessoa(int id);
    List<Pessoa> getAllPessoas();
    Pessoa save (Pessoa pessoa);
    Pessoa update (int id, Pessoa pessoa);
    void delete (int id);
}
