package com.practica01.service.impl;

import com.practica01.dao.ArbolDao;
import com.practica01.domain.Arbol;
import com.practica01.service.ArbolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArbolServiceImpl
        implements ArbolService {

    // El autowired es para que se cree automaticamente un objeto
    // y solo uno va a existir
    @Autowired
    private ArbolDao arbolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Arbol> getArbols(boolean activo) {
        var lista = arbolDao.findAll();

        if (activo) { // Solo activos 
            // La c representa a cada dato del arraylist
            // para cada elemento de arbol diga si esta activo o no
            lista.removeIf(c -> !c.isDurezaMadera());
        }

        return lista;

    }

    @Override
    @Transactional(readOnly = true)
    public Arbol getarbol(Arbol arbol) {
        // Esta logica encuentra el producto pero si no lo hace devuelve nulo en el .orElse
        return arbolDao.findById(arbol.getIdArbol()).orElse(null);

    }

    @Override
    @Transactional
    public void save(Arbol arbol) {
        arbolDao.save(arbol);
    }

    @Override
    @Transactional
    public void delete(Arbol arbol) {
        arbolDao.delete(arbol);
    }

}
