package com.abreu.blog.service;

import com.abreu.blog.exceptions.ResourceNotFoundException;
import com.abreu.blog.model.Pessoa;
import com.abreu.blog.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PessoaServiceImpl implements PessoaService{

    private final PessoaRepository repository;

    @Override
    public Optional<Pessoa> getPessoa(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Pessoa> getAllPessoas() {
        return repository.findAll();
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    @Override
    public Pessoa update(int id,Pessoa pessoa) {
        Pessoa newPessoa = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("pessoa","id",id));
        newPessoa.setBio(pessoa.getBio());
        newPessoa.setGender(pessoa.getGender());
        newPessoa.setFullName(pessoa.getFullName());
        return repository.save(newPessoa);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
