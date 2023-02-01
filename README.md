# Estaciones_Bizi_Grupo3

#Líder de equipo: Ismael

    #Estructura de datos
    
    #Estructura de código
        #Actividades
            Splash - Ismael

            Pantalla principal - Alvaro
                Un listado de datos
                
            Pantalla para mostrar los datos - Ismael
                #Datos del Json
                id,about,title,estado,estadoEstacion,address
                tipoEquipamiento,bicisDisponibles,anclajesDisponibles,geometry(type,coordinates)
                lastUpdated,description,descripcion,icon
                 
                #Button Siguiente
                #Button Anterior


        #Logica de negocio
            Controlador para la base de datos - Raul
            Adapter del listado - Alvaro

        #Modelo - Victor
            EstacionBici
                int id
                String about    
                String title
                String estado
                String estadoEstacion
                String address
                String tipoEquipamiento
                int BicisDisponibles
                int anclajesDisponibles
                Date lastUpdated
                String description
                String descripcion
                Imagen
            Geometria
                String type
                String coordinates

            #Interfaz - Alvaro
            Interfaz de todas las actividades(layout) y del menu

            #Menu - Victor
            Contiene Listado de registros, Actualizar datos y Buscador de datos.
    
    #Descripción del proyecto
    
    El proyecto contendra 3 actividades, 2 clases y un splash. El splash aparecera al iniciarse la aplicación
    y tambien se cargaran los datos de la base de datos en ella
    
    La primera actividad aparecera despues del splash, aparecera una lista con datos(Previamente cargada en el splash) 
    de la base de datos un menu para refrescar la base de datos

    Al clickar un dato en la primera actividad iras a la segunda que apareceran los datos de la información clickada
    habra dos botones para ir pasando entre los datos de la base de datos y un menu el cual tendra para que regreses
    al listado de la actividad anterior y un buscador de datos el cual te llevara a la que tu le digas.
    