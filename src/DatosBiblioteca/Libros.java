/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBiblioteca; // Define el paquete al que pertenece la clase

import java.util.Date; // Importa la clase Date para manejar las fechas de publicación

 /**
 * @author  Weymer Orocú Amador
 * Nombre del Proyecto: Sistema de Gestión y Registro de Libros
 * Descripcion del proyecto: El sistema consiste en una aplicacion desarrollada en Java Swing 
 * bajo el patrón MVC, que permite el registro, edición, búsqueda y listado de libros en tiempo 
 * real mediante el manejo de colecciones en memoria.
 */
public class Libros { // Declaración de la clase Libros
    private final int id; // ID único del libro. Es 'final' porque no debe cambiar una vez asignado
    private String titulo; // Atributo que almacena el título del libro.
    private String autor; // Atributo que almacena el autor
    private Date fechaPublicacion; // Almacena la fecha en que fue publicado el libro
    private String biblioteca;  // Atributo que almacena el nombre de la biblioteca donde se encuentra el libro.

    // Constructor de la clase.
    // Se ejecuta cuando se crea un nuevo objeto Libros.
    public Libros(int id, String titulo, String autor, Date fechaPublicacion, String biblioteca) {
        this.id = id; // Asigna el ID recibido por parámetro al atributo id de la clase
        this.titulo = titulo; // Asigna el titulo recibido por parámetro al atributo titulo de la clase
        this.autor = autor; // Asigna el autor recibido al atributo autor de la clase
        this.fechaPublicacion = fechaPublicacion; // Asigna la fecha de publicación recibida al atributo correspondiente.
        this.biblioteca = biblioteca; // Asigna la biblioteca recibida al atributo biblioteca de la clase
    }

    public int getId() { // Método getter que devuelve el identificador del libro.
        return id; // Retorna el valor actual del ID
    }

    public String getTitulo() { // Método Getter para obtener el título del libro
        return titulo; // Retorna el texto guardado en el atributo titulo
    }

    public void setTitulo(String titulo) { // Método setter que permite modificar el título del libro.
        this.titulo = titulo; // Reemplaza el título anterior por el nuevo valor recibido
    }

    public String getAutor() {  // Método getter que devuelve el nombre del autor.
        return autor; // Retorna el texto guardado en el atributo autor
    }

    public void setAutor(String autor) {  // Método setter que permite modificar el autor
        this.autor = autor; // Reemplaza el autor anterior por el nuevo valor recibido
    }

    public Date getFechaPublicacion() {  // Método getter que devuelve la fecha de publicación.
        return fechaPublicacion; // Retorna el objeto Date guardado en el atributo fechaPublicacion
    }

    public void setFechaPublicacion(Date fechaPublicacion) { // Método setter que permite cambiar la fecha de publicación
        this.fechaPublicacion = fechaPublicacion; // Reemplaza la fecha anterior por la nueva fecha recibida
    }

    public String getBiblioteca() { // Método Getter para obtener el nombre de la biblioteca
        return biblioteca;  // Retorna el texto guardado en el atributo biblioteca
    }

    public void setBiblioteca(String biblioteca) { // Método setter que permite modificar la biblioteca.
        this.biblioteca = biblioteca; // Reemplaza la biblioteca anterior por la nueva recibida
    }
}