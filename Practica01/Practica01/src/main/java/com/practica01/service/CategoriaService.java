// Todos estos paquetes como dao, domain o service 
// es para poder ordenar el sql 

package com.practica01.service;

import com.practica01.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    // Se recupera la lista de categorias 
    //de la tabla categoria dentro de un arrayList
    // Solo las activas o todas...
    public List<Categoria> getCategorias(boolean activo);
    
    
    // Se obtiene un registro de categorias en un 
    // objeto de tipo categoria
    // Si el idCategoria existe si no existe es nulo.
    public Categoria getcategoria(Categoria categoria);
    
    // Se crea un nuevo registro en la tabla categoria,
    // si el obbjeto Categoria NO tiene idCategoria
    // Se actualiza el regitro en la tabla categoria,
    // Si el objeto Categoria tiene un idCategoria  
    public void save(Categoria categoria);
    
    // Se elimina el registro en la tabla categoria si 
    // el idCategoria existe en la tabla
    public void delete(Categoria categoria);
    
    
}
