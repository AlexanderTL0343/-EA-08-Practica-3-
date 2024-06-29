
package com.practica01.service;


import org.springframework.web.multipart.MultipartFile;

public interface FireBaseStorageService {
    // La carpeta es donde se quiere que se coloque la imagen.
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "tarea2flores.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "Tarea2Flores";

    //Ubicación donde se encuentra el archivo de configuración Json en other Sources.
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "tarea2flores-firebase-adminsdk-w02xn-9af31ae538.json";
}
