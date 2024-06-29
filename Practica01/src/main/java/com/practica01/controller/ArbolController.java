package com.practica01.controller;

import com.practica01.domain.Arbol;
import com.practica01.service.ArbolService;
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
@RequestMapping("/arbol")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    // Mapea la ruta que se quiera utilizar
    @GetMapping("/listado")
    public String listado(Model model) {

        var lista = arbolService.getArbols(false);
        model.addAttribute("arbols", lista);
        model.addAttribute("totalArbols", lista.size());
        // Puedo pasar informacion al html listado
        // Este busca un paquete arbol con un html listado en OTHER SOURCES del codigo
        return "/arbol/listado";
    }
    // para poder crear una unica copia del metodo
    @Autowired
    private FireBaseStorageService firebaseStorageService;

    // Metodo para agregar una nueva arbol
    @PostMapping("/guardar")
    public String guardar(Arbol arbol,
            @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            arbolService.save(arbol);
            String rutaImagen
                    = firebaseStorageService.cargaImagen(imagenFile,
                            "arbol", arbol.getIdArbol());
            arbol.setRutaImagen(rutaImagen);
        }
        arbolService.save(arbol);

        // Vata y ejecute el metodo listado de esta misma clase
        return "redirect:/arbol/listado";

    }

    @GetMapping("/eliminar/{idArbol}")
    public String eliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";

    }

    @GetMapping("/modificar/{idArbol}")
    public String modificar(Arbol arbol, Model model) {
        // Recuperar el objeto arbol por el id que me pasan. 
        arbol = arbolService.getarbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica";

    }
    
    
}
