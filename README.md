# Proyecto-Java---Fin-Semestre
Aplicación (Nivel medio - avanzado) de P.O.O en Java
Problema de implementación: 
Un Zoo necesita una aplicación informática para llevar su organización respecto a las especies
que posee, los empleados (cuidadores y guías), y los distintos itinerarios de visita que ofrece.
La información está estructurada de la siguiente manera:
> Especies: De las especies interesa saber el nombre en español, el nombre científico y
una descripción general. Hay que tener en cuenta que una especie puede vivir en
diferentes hábitats naturales y que un hábitat puede ser ocupado por diferentes
especies. Las especies se encuentran en distintas zonas del parque de manera que
cada especie está en una zona y en una zona hay varias especies.
> Hábitats: Los diferentes hábitats naturales vienen definidos por el nombre, el clima, y
el tipo de vegetación predominante, así como el continente o continentes en los que
se encuentran.
> Zonas: Las zonas del parque en las que se encuentran las distintas especies vienen
definidas por el nombre y la extensión que ocupan.
> Itinerarios: Los itinerarios discurren por distintas zonas del parque. La información
relevante para los itinerarios es: código del itinerario, la duración del recorrido, la
longitud del itinerario, el máximo número de visitantes autorizado y el número de
distintas especies que visita. Hay que tener en cuenta que un itinerario recorre
distintas zonas del parque y que una zona puede ser recorrida por diferentes
itinerarios.
> Guías: Los guías del parque vienen definidos por el nombre, dirección, teléfono y fecha
en la que comenzaron a trabajar en el Zoo. Interesa saber que guías llevan itinerarios
teniendo en cuenta que un guía puede llevar varios itinerarios y que un itinerario
puede ser asignado a varios guías en diferentes horas, siendo éstas un dato de interés.
> Cuidadores: Los cuidadores vienen definidos por el nombre, dirección, teléfono y
fecha de ingreso en el parque. Hay que tener en cuenta que un cuidador puede estar a
cargo de varias especies y una especie puede ser atendida por varios cuidadores,
siendo de interés la fecha en la que un cuidador se hace cargo de la especie.
Generar el diagrama de clases a nivel de diseño que permita resolver el problema.
Generar una aplicación en Java utilizando los componentes de la librería swing para
automatizar la solución al requerimiento, la cual debe tener las siguientes consideraciones:
Para el acceso al sistema se necesita ingresar con un usuario y clave. Una vez superada la
validación se podrá acceder a la pantalla principal del sistema, desde la cual se podrá utilizar
las diferentes funcionalidades creadas.
Los datos de los objetos se deberán almacenar en archivos.
Todas las clases deberán tener las operaciones básicas de lo que se denomina CRUD (Create,
Read, Update, Delete). También se deberá crear una funcionalidad para administrar las
cuentas de usuario mencionadas anteriormente. En el caso de los métodos de lectura se debe 
considerar las opciones de ordenamiento tanto ascendente como descendente y considerando
por lo menos dos criterios de ordenamiento: (uno por nombre, otro por código o
identificador).
Previo a realizar una operación de modificación, creación o eliminación de información se
debe invocar la operación de búsqueda, la cual podrá realizarse por identificador o por
nombre. Si no existe la información consultada, el sistema debe emitir un mensaje informativo
al usuario.
No se podrán tener dos objetos idénticos de ninguna de las clases, por lo que deberá
implementar las validaciones que considere necesarias.
El sistema deberá estar estructurado en capas separando la interfaz de usuario (vista) de la
capa de datos (Modelo) y la capa de negocio (Controlador).
En el caso de la capa de presentación las pantallas deberán tener una sección para el ingreso
de información y una sección en la misma pantalla que permita visualizar todos los datos
existentes.
Se deberá implementar un adecuado manejo de errores y excepciones en el programa.
El programa debe tener los comentarios de documentación basados en el API Javadoc y se
deberá entregar el archivo HTML generado como parte de la solución final.
Es opcional el uso de Colecciones propias del Lenguaje de Programación Java. Si no desea
utilizarlas deberá utilizar arreglos.
