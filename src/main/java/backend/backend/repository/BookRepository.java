/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.backend.repository;

import backend.backend.entity.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    //Find by id
    List<Book> findById(long id);
    //Find all sorted by ID asc
    @Query("from Book order by id")
    List<Book> findAllSorted();
    //Find greater than id
    List<Book> findByIdGreaterThan( long id);
    //Find by id name sorted
    @Query("from Book where name=?1 order by role")
    List<Book> findByNameSorted(  String name );
    @Query( value="Select * from Book LIKE '%name%';" , nativeQuery=true)
    Integer countByName(String name); 
    
}
