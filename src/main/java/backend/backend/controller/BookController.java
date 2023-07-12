/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.backend.controller;

import backend.backend.entity.Book;
import backend.backend.model.ErrorObject;
import backend.backend.repository.BookRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import utils.Util;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping(value = "/api/v1/book")
@CrossOrigin("*")
@Tag(name = "book", description = "The book API")
public class BookController {

    @Autowired
    private BookRepository repository;

    @Operation(
            summary = "Find all books",
            description = "Find all books",
            tags = "book"
    )
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "successful operation",
                        content = @Content(
                                array = @ArraySchema(
                                        schema = @Schema(implementation = Book.class)
                                )
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Bad request",
                        content = @Content(
                                schema = @Schema(implementation = ErrorObject.class)
                        )
                )
            }
    )
    @GetMapping(path = {"/all"}, produces = "application/json")
    ResponseEntity<?> all() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Operation(
            summary = "Find book by ID",
            description = "Search book by the id",
            tags = "book"
    )
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "successful operation",
                        content = @Content(
                                schema = @Schema(implementation = Book.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Book not found",
                        content = @Content(
                                schema = @Schema(implementation = ErrorObject.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Bad request",
                        content = @Content(
                                schema = @Schema(implementation = ErrorObject.class)
                        )
                )
            }
    )
    @GetMapping(value = "/get/{id}", produces = "application/json")
    public ResponseEntity<?> byId(@PathVariable(value = "id") Long id) {
        try {
            Optional<Book> opt = repository.findById(id);
            if (opt.isPresent()) {
                return ResponseEntity.ok(opt.get());
            } else {
                return notFound();
            }
        } catch (Exception exp) {
            return badRequest(exp);
        }
    }

    @Operation(
            summary = "Create new book",
            description = "Create a new book",
            tags = "book"
    )
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "successful operation",
                        content = @Content(
                                schema = @Schema(implementation = Book.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Bad request",
                        content = @Content(
                                schema = @Schema(implementation = ErrorObject.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "409",
                        description = "Book already exists",
                        content = @Content(
                                schema = @Schema(implementation = ErrorObject.class)
                        )
                )
            }
    )
    @PostMapping(path = {"/save"}, consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> save(@RequestBody Book book) {
        try {
            Optional<Book> optionalBook = repository.findById(book.getId());
            if (optionalBook.isPresent()) {
                return conflict();
            } else {
                return ResponseEntity.ok(repository.save(book));
            }
        } catch (Exception exp) {
            return badRequest(exp);
        }
    }

    @Operation(
            summary = "Update book",
            description = "Update book info",
            tags = "book"
    )
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "successful operation",
                        content = @Content(
                                schema = @Schema(implementation = Book.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Book not found",
                        content = @Content(
                                schema = @Schema(implementation = ErrorObject.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Bad request",
                        content = @Content(
                                schema = @Schema(implementation = ErrorObject.class)
                        )
                )
            }
    )
            @PutMapping(path = {"/update/{id}"}, consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> update(@RequestBody Book book, @PathVariable(value = "id") Long id) {
        try {
            Optional<Book> optionalBook = repository.findById(id);
            if (optionalBook.isPresent()) {
                 Book b = Util.convertToDto(optionalBook.get(),Book.class); 
                return ResponseEntity.ok(repository.save(b));
            } else {
                return notFound();
            }
        } catch (Exception exp) {
            return badRequest(exp);
        }
    }

    @Operation(
            summary = "Delete a book",
            description = "Delete a book",
            tags = "book"
    )
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "successful operation",
                        content = @Content(
                                schema = @Schema(implementation = Book.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Bad request",
                        content = @Content(
                                schema = @Schema(implementation = ErrorObject.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Book not found",
                        content = @Content(
                                schema = @Schema(implementation = ErrorObject.class)
                        )
                )
            }
    )
    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            Optional<Book> optionalBook = repository.findById(id);
            if (optionalBook.isPresent()) {
                Book book = optionalBook.get();
                repository.delete(book);
                return ResponseEntity.ok(book);
            } else {
                return notFound();
            }
        } catch (Exception exp) {
            return badRequest(exp);
        }
    }

    private ResponseEntity<?> notFound() {
        return new ResponseEntity<>(
                new ErrorObject(HttpStatus.NOT_FOUND.toString(), "Object not found"),
                HttpStatus.NOT_FOUND
        );
    }

    private ResponseEntity<?> badRequest(Throwable throwable) {
        return new ResponseEntity<>(
                new ErrorObject(HttpStatus.BAD_REQUEST.toString(), "Bad request"),
                HttpStatus.BAD_REQUEST
        );
    }

    private ResponseEntity<?> conflict() {
        return new ResponseEntity<>(
                new ErrorObject(HttpStatus.CONFLICT.toString(), "Object already exists"),
                HttpStatus.CONFLICT
        );
    }
}
