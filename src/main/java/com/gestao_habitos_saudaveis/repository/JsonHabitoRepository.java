package com.gestao_habitos_saudaveis.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestao_habitos_saudaveis.model.Habito;
import org.springframework.stereotype.Repository;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JsonHabitoRepository implements HabitoRepository {
    private final List<Habito> habitos = new ArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File arquivoJson = new File("data/habitos.json");
    public JsonHabitoRepository() {
        carregar();
    }

    @Override
    public List<Habito> findAll() {
        return new ArrayList<>(habitos);
    }

    @Override
    public Optional<Habito> findById(String id) {
        return habitos.stream()
                .filter(h -> h.getId().equals(id))
                .findFirst();
    }

    @Override
    public void save(Habito habito) {
        findById(habito.getId()).ifPresentOrElse(
                existente -> {
                    int index = habitos.indexOf(existente);
                    habitos.set(index, habito);
                },
                () -> habitos.add(habito)
        );
        salvar();
    }

    @Override
    public void deleteById(String id) {
        habitos.removeIf(h -> h.getId().equals(id));
        salvar();
    }

    private void carregar() {
        try {
            if (arquivoJson.exists()) {
                List<Habito> lista = objectMapper.readValue(
                        arquivoJson,
                        new TypeReference<>() {}
                );
                habitos.clear();
                habitos.addAll(lista);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar hábitos: " + e.getMessage());
        }
    }

    private void salvar() {
        try {
            if (!arquivoJson.getParentFile().exists()) {
                arquivoJson.getParentFile().mkdirs();
            }
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(arquivoJson, habitos);
        } catch (IOException e) {
            System.err.println("Erro ao salvar hábitos: " + e.getMessage());
        }
    }
}
