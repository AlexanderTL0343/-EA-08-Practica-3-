package com.practica01.service.impl;

import com.practica01.dao.CategoriaDao;
import com.practica01.domain.Categoria;
import com.practica01.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl
        implements CategoriaService {

    // El autowired es para que se cree automaticamente un objeto
    // y solo uno va a existir
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activo) {
        var lista = categoriaDao.findAll();

        if (activo) { // Solo activos 
            // La c representa a cada dato del arraylist
            // para cada elemento de categoria diga si esta activo o no
            lista.removeIf(c -> !c.isActivo());
        }

        return lista;

    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getcategoria(Categoria categoria) {
        // Esta logica encuentra el producto pero si no lo hace devuelve nulo en el .orElse
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);

    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

}
