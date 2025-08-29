package org.example.gestiondeempleados.repository;

import org.example.gestiondeempleados.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    Optional<Departamento> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
