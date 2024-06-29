// Carga un arhivo imagen en memoria y lo presenta en pantalla.
function readURL(input) {
    if (input.files && input.files[0]) {
        // Este atributo va a ser posible leer el arhivo y mostrarlo 
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#blah')
                    .attr('src', e.target.result)
                    .height(200);
        };
        reader.readAsDataURL(input.files[0]);
    }

}

