package com.gestao_habitos_saudaveis.service;

import com.gestao_habitos_saudaveis.exception.BadRequestException;
import com.gestao_habitos_saudaveis.exception.ResourceNotFoundException;
import com.gestao_habitos_saudaveis.model.Habito;
import com.gestao_habitos_saudaveis.repository.HabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HabitoService {

    private final HabitoRepository repository;

    @Autowired
    public HabitoService(HabitoRepository repository) {
        this.repository = repository;
    }

    public List<Habito> listarTodos() {
        return repository.findAll();
    }

    public Habito buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hábito não encontrado com ID: " + id));
    }

    public Habito criar(Habito habito) {
        try {
            if (habito == null) {
                throw new BadRequestException("O hábito não pode ser nulo.");
            }

            habito.calcularStatus();

            repository.save(habito);
            return habito;

        } catch (BadRequestException e) {
            throw e;
        } catch (Exception e) {
            throw new BadRequestException("Erro ao criar hábito: " + e.getMessage());
        }
    }

    public Habito atualizar(String id, Habito novoHabito) {
        Habito existente = buscarPorId(id);

        try {
            if (novoHabito == null) {
                throw new BadRequestException("Os dados do hábito não podem ser nulos.");
            }

            existente.setNome(novoHabito.getNome());
            existente.setDescricao(novoHabito.getDescricao());
            existente.setDataRegistro(novoHabito.getDataRegistro());

            existente.calcularStatus();

            repository.save(existente);
            return existente;

        } catch (BadRequestException e) {
            throw e;
        } catch (Exception e) {
            throw new BadRequestException("Erro ao atualizar hábito: " + e.getMessage());
        }
    }

    public void deletar(String id) {
        Habito existente = buscarPorId(id);
        repository.deleteById(existente.getId());
    }
}
