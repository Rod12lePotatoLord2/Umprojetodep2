package com.gestao_habitos_saudaveis.repository;

import com.gestao_habitos_saudaveis.model.Habito;
import java.util.List;
import java.util.Optional;

public interface HabitoRepository {

    List<Habito> findAll();

    Optional<Habito> findById(String id);

    void save(Habito habito);

    void deleteById(String id);
}
