package com.mx.ApiRestInbursa.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="DEPARTAMENTOS_06")
@Data
public class Departamentos {
	
    @Id
    @Column(name="ID_DEPARTAMENTO")
    private Integer idDepartamento;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="SUELDO")
    private Double sueldo;

    @JsonIgnore
    @OneToMany(mappedBy="departamento",
            cascade=CascadeType.ALL,
            fetch=FetchType.LAZY)

    private List<Empleados> empleados;
}
