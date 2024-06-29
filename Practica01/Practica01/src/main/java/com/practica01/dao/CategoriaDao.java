package com.practica01.dao;

import com.practica01.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
// Nos va a permitir hacer los select, delete, insert y create de manera automatica
public interface CategoriaDao 
        extends JpaRepository<Categoria, Long>
{

}
