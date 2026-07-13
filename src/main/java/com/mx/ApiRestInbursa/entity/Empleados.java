package com.mx.ApiRestInbursa.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="EMPLEADOS_06")
@Data

public class Empleados {
	
    @Id
    @Column(name="ID_EMPLEADO")
    private Integer idEmpleado;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="APP")
    private String app;

    @Column(name="FECHA_NACIMIENTO")
    private LocalDate fechaNacimiento;

    @ManyToOne
    @JoinColumn(name="ID_DEPARTAMENTO")
    private Departamentos departamento;

}
