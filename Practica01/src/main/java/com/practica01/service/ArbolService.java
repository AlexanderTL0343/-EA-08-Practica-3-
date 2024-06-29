// Todos estos paquetes como dao, domain o service 
// es para poder ordenar el sql 

package com.practica01.service;

import com.practica01.domain.Arbol;
import java.util.List;

public interface ArbolService {
    
    // Se recupera la lista de arbols 
    //de la tabla arbol dentro de un arrayList
    // Solo las activas o todas...
    public List<Arbol> getArbols(boolean activo);
    
    
    // Se obtiene un registro de arbols en un 
    // objeto de tipo arbol
    // Si el idArbol existe si no existe es nulo.
    public Arbol getarbol(Arbol arbol);
    
    // Se crea un nuevo registro en la tabla arbol,
    // si el obbjeto Arbol NO tiene idArbol
    // Se actualiza el regitro en la tabla arbol,
    // Si el objeto Arbol tiene un idArbol  
    public void save(Arbol arbol);
    
    // Se elimina el registro en la tabla arbol si 
    // el idArbol existe en la tabla
    public void delete(Arbol arbol);
    
    
}
