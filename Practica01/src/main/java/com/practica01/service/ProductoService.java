// Todos estos paquetes como dao, domain o service 
// es para poder ordenar el sql 

package com.practica01.service;

import com.practica01.domain.Producto;
import java.util.List;

public interface ProductoService {
    
    // Se recupera la lista de productos 
    //de la tabla producto dentro de un arrayList
    // Solo las activas o todas...
    public List<Producto> getProductos(boolean activo);
    
    
    // Se obtiene un registro de productos en un 
    // objeto de tipo producto
    // Si el idProducto existe si no existe es nulo.
    public Producto getproducto(Producto producto);
    
    // Se crea un nuevo registro en la tabla producto,
    // si el obbjeto Producto NO tiene idProducto
    // Se actualiza el regitro en la tabla producto,
    // Si el objeto Producto tiene un idProducto  
    public void save(Producto producto);
    
    // Se elimina el registro en la tabla producto si 
    // el idProducto existe en la tabla
    public void delete(Producto producto);
    
    
}
