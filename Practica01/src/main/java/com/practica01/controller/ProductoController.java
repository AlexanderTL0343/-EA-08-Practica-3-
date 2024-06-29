package com.practica01.controller;

import com.practica01.domain.Producto;
import com.practica01.service.ProductoService;
import com.practica01.service.FireBaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
// Esta clase mapea el la clase html de listado. 

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Mapea la ruta que se quiera utilizar
    @GetMapping("/listado")
    public String listado(Model model) {

        var lista = productoService.getProductos(false);
        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());
        // Puedo pasar informacion al html listado
        // Este busca un paquete producto con un html listado en OTHER SOURCES del codigo
        return "/producto/listado";
    }
    // para poder crear una unica copia del metodo
    @Autowired
    private FireBaseStorageService firebaseStorageService;

    // Metodo para agregar una nueva producto
    @PostMapping("/guardar")
    public String guardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            String rutaImagen
                    = firebaseStorageService.cargaImagen(imagenFile,
                            "producto", producto.getIdProducto());
            producto.setRutaImagen(rutaImagen);
        }
        productoService.save(producto);

        // Vata y ejecute el metodo listado de esta misma clase
        return "redirect:/producto/listado";

    }

    @GetMapping("/eliminar/{idProducto}")
    public String eliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/producto/listado";

    }

    @GetMapping("/modificar/{idProducto}")
    public String modificar(Producto producto, Model model) {
        // Recuperar el objeto producto por el id que me pasan. 
        producto = productoService.getproducto(producto);
        model.addAttribute("producto", producto);
        return "/producto/modifica";

    }
    
    
}
