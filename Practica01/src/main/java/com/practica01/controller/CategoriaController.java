package com.practica01.controller;

import com.practica01.domain.Categoria;
import com.practica01.service.CategoriaService;
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
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Mapea la ruta que se quiera utilizar
    @GetMapping("/listado")
    public String listado(Model model) {

        var lista = categoriaService.getCategorias(false);
        model.addAttribute("categorias", lista);
        model.addAttribute("totalCategorias", lista.size());
        // Puedo pasar informacion al html listado
        // Este busca un paquete categoria con un html listado en OTHER SOURCES del codigo
        return "/categoria/listado";
    }
    // para poder crear una unica copia del metodo
    @Autowired
    private FireBaseStorageService firebaseStorageService;

    // Metodo para agregar una nueva categoria
    @PostMapping("/guardar")
    public String guardar(Categoria categoria,
            @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            categoriaService.save(categoria);
            String rutaImagen
                    = firebaseStorageService.cargaImagen(imagenFile,
                            "categoria", categoria.getIdCategoria());
            categoria.setRutaImagen(rutaImagen);
        }
        categoriaService.save(categoria);

        // Vata y ejecute el metodo listado de esta misma clase
        return "redirect:/categoria/listado";

    }

    @GetMapping("/eliminar/{idCategoria}")
    public String eliminar(Categoria categoria) {
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";

    }

    @GetMapping("/modificar/{idCategoria}")
    public String modificar(Categoria categoria, Model model) {
        // Recuperar el objeto categoria por el id que me pasan. 
        categoria = categoriaService.getcategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";

    }
    
    
}
