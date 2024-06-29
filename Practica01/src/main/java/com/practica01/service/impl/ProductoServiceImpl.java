package com.practica01.service.impl;

import com.practica01.dao.ProductoDao;
import com.practica01.domain.Producto;
import com.practica01.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl
        implements ProductoService {

    // El autowired es para que se cree automaticamente un objeto
    // y solo uno va a existir
    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activo) {
        var lista = productoDao.findAll();

        if (activo) { // Solo activos 
            // La c representa a cada dato del arraylist
            // para cada elemento de producto diga si esta activo o no
            lista.removeIf(c -> !c.isActivo());
        }

        return lista;

    }

    @Override
    @Transactional(readOnly = true)
    public Producto getproducto(Producto producto) {
        // Esta logica encuentra el producto pero si no lo hace devuelve nulo en el .orElse
        return productoDao.findById(producto.getIdProducto()).orElse(null);

    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

}
