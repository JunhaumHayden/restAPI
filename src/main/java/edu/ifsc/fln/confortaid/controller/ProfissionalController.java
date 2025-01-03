package edu.ifsc.fln.confortaid.controller;

import edu.ifsc.fln.confortaid.model.Profissional;
import edu.ifsc.fln.confortaid.repository.ProfissionalRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @GetMapping
    public List<Profissional> listarTodos() {
        return profissionalRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profissional> buscarPorId(@PathVariable Integer id) {
        return profissionalRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Profissional criar(@RequestBody Profissional profissional) {
        return profissionalRepository.save(profissional);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profissional> atualizar(@PathVariable Integer id, @RequestBody Profissional profissionalAtualizado) {
        System.out.println(profissionalAtualizado);

        return profissionalRepository.findById(id)
                .map(profissional -> {
                    profissional.setNome(profissionalAtualizado.getNome());
                    profissional.setEmail(profissionalAtualizado.getEmail());
                    profissional.setEspecialidade(profissionalAtualizado.getEspecialidade());
                    profissional.setRegistroProfissional(profissionalAtualizado.getRegistroProfissional());
                    return ResponseEntity.ok(profissionalRepository.save(profissional));
                })
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable Integer id) {
        return profissionalRepository.findById(id)
                .map(profissional -> {
                    profissionalRepository.delete(profissional);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

