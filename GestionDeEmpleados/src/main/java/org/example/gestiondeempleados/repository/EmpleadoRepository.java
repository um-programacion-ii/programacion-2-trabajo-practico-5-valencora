package org.example.gestiondeempleados.repository;

import org.example.gestiondeempleados.model.Departamento;
import org.example.gestiondeempleados.model.Empleado;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    Optional<Empleado> findByEmail(String email);

    List<Empleado> findByDepartamento(Departamento departamento);

    List<Empleado> findBySalarioBetween(BigDecimal salarioMin, BigDecimal salarioMax);

    List<Empleado> findByFechaContratacionAfter(LocalDate fecha);

    @Query("SELECT e FROM Empleado e WHERE e.departamento.nombre = :nombreDepartamento")
    List<Empleado> findByNombreDepartamento(@Param("nombreDepartamento") String nombreDepartamento);

    @Query("SELECT AVG(e.salario) FROM Empleado e WHERE e.departamento.id = :departamentoId")
    Optional<BigDecimal> findAverageSalarioByDepartamento(@Param("departamentoId") Long departamentoId);
}
