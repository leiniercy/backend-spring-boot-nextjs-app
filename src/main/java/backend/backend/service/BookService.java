/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.backend.service;

import backend.backend.entity.Book;
import backend.backend.exeptions.BadRequest;
import backend.backend.exeptions.ValueNotFound;
import backend.backend.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class BookService {

    @Autowired //UTILIZAZACION DEL PATRON SINGELTON PARA CREAR UN PTO DE ACCESO GLOBAL
    BookRepository repository;

    /**
     * METODO PARA VERIFICAR SI EL OBJETO ESTA DISPONIBLE O NO
     *
     * @param entity indica el objeto que se desea guradar. No debe ser vacio
     * {@literal null}.
     * @return true/false
     *
     */
    private boolean checkBookAvailable(Book book) throws ValueNotFound {
        Optional<Book> bookFound = repository.findById(book.getId());
        if (bookFound.isPresent()) {
            throw new ValueNotFound();
        }
        return true;
    }

    /**
     * PRIMERO SE VERIFICA QUE EL OBJETO NO EXISTA, Y LUEGO SE GURADA LA
     * INFORMACION
     *
     * @param entity indica el objeto que se desea guradar. No debe ser vacio
     * {@literal null}.
     * @return el objeto guardado
     *
     */
    public Book save(Book book) throws ValueNotFound {
        if (checkBookAvailable(book)) {
            book = repository.save(book);
        }
        return book;
    }

    /**
     * Map todo
     *
     * @param from
     * @return to
     *
     */
    public Book update(Book from) throws ValueNotFound, BadRequest {
        Book toBook = findById(from.getId());
        //Mapeo del objeto para garantizar que se actualicen todos los cambios
        toBook.setAuthor(from.getAuthor());
        toBook.setTitle(from.getTitle());
        toBook.setPrice(from.getPrice());

        return repository.save(toBook);
    }

    /**
     * METODO PARA VERIFICAR SI EL MOVIL EXISTE, PREGUNTANDO POR EL ID
     *
     * @param id no debe ser vacio {@literal null}.
     * @return una referencia a la entidad que coincida con el identificador.
     *
     */
    public Book findById(Long id) throws ValueNotFound , BadRequest{
        Book book = repository.findById(id).orElseThrow(() -> new ValueNotFound());
        return book;
    }

    /**
     * METODO QUE DEVUELVE UNA LISTA CON TODOS LOS OBJETOS DE UN MISMO TIPO
     * ESPECIFICADO PREVIAMENTE
     *
     * @return un listado de objetos
     *
     */
    public List<Book> findAll() {
        return repository.findAll();
    }

    /**
     * METODO PARA ELIMINAR UN OBJETO POR SU IDENTIFICADOR
     *
     * @param Objeto
     *
     */
    public Book delete(Book book) throws ValueNotFound , BadRequest{
        Book b = findById(book.getId());
        repository.delete(book);
        return b;
    }

    /**
     * METODO PARA ELIMINAR UN OBJETO POR SU IDENTIFICADOR
     *
     * @param Identificador
     *
     */
    public Book deleteById(Long id) throws ValueNotFound, BadRequest {
        Book book = findById(id);
        repository.deleteById(id);
        return book;
    }

    /**
     * METODO PARA ELIMINAR UN CONJUNTO DE OBJETOS.
     *
     * @param Set<Object>
     *
     */
    public void deleteAll(Set<Book> books) {
        repository.deleteAll(books);
    }

    // METODO QUE DEVUELVE LA CANTIDAD DE OBJETOS QUE EXISTE
    public long count() {
        return (long) repository.count();
    }

}
