Proyecto Simulador de Procesos

El proyecto esta dividido en tres paquetes, el paquete "Classes" contendra todas las clases relacionadas con
el proyecto. El paquete "dataStructures" contiene las principales estructuras de datos que se usaran en el proyecto
como podria ser listas enlazadas, pilas, colas, etc. Y Por ultimo el paquete GUI tendra las interfaces graficas construidas
con el IDE Netbeans.

-Todo el codigo se ejecuta en la clase "Main" dentro del metodo "main".
-La clase "Simulacion" se encarga de juntar todas las clases y sincronizarlas de forma que todas trabajen en conjunto. Esta clase tiene un 
metodo llamado "startSimulation()" el cual sera el encargado de ejecutar las principales funciones de la simulacion.
-La clase abstracta "MemoryEntity" se creo con el fin de definir que clases son entidades que estaran cargadas en memoria principal, las cuales serian 
las clases "Process" y "OperativeSystem".  
