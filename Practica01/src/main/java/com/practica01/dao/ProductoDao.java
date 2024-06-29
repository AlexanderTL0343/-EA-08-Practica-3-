package com.practica01.dao;

import com.practica01.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
// Nos va a permitir hacer los select, delete, insert y create de manera automatica
public interface ProductoDao 
        extends JpaRepository<Producto, Long>
{

}
