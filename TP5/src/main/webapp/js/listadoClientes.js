
/*por las dudas explico lo que hace la funcion
*/

$(document).ready(function () {
  //le da nombre al datatable
            $('#tablaClientes').DataTable({
              //en el trabajo esta el listado en 5 asi que lo pongo asi
                pageLength: 5,
              // en el pdf se ve como un ddl donde el usuario puede colocar la
              //cantidad de registros que puede ver asi que pongo esas opciones:
                lengthMenu: [ [5, 10, 25, -1], [5, 10, 25, "Todos"] ],
                //macrosss
                language: {
                  //esta linea define la cantidad de lineas que va a tener el ddl que mencione antes
                    lengthMenu: "Mostrar _MENU_ registros",
                    //cuando el datatable/dataset no trae nada
                    zeroRecords: "No se encontraron clientes",
                    //el mensajito de abajo
                    info: "Mostrando _START_ a _END_ de _TOTAL_ registros",
                    //lo que muestra si no hay datos
                    infoEmpty: "Mostrando 0 a 0 de 0 registros",
                    infoFiltered: "(filtrado de un total de _MAX_ registros)",
                    search: "Buscar:",
                    paginate: {
                        first: "Primero",
                        last: "Último",
                        next: "Siguiente",
                        previous: "Anterior"
                    }
                },
                //que sea responsivo: osea, que se adapte a las pantallas
                responsive: true
            });
        });
