
/*por las dudas explico lo que hace la funcion
*/

$(document).ready(function () {
  //le da nombre al datatable
            $('#tablaClientes').DataTable({
                pageLength: 5,
                lengthMenu: [ [5, 10, 15, -1], [5, 10, 15, "Todos"] ],
       
                language: {
                    lengthMenu: "Mostrar _MENU_ registros",
                    zeroRecords: "No se encontraron clientes",
                    info: "Mostrando _START_ a _END_ de _TOTAL_ registros",

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
                responsive: true
            });
        });
