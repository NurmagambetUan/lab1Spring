package net.alterapp.miniproject.controller;

import net.alterapp.miniproject.domain.Book;
import net.alterapp.miniproject.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/book")
public class BookController extends BaseController {
    private final net.alterapp.miniproject.service.BookService BookService;

    public BookController(BookService bookService) {
        this.BookService = bookService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> getAll() {
        return buildResponse(BookService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestParam Long id, @RequestBody Book book) {
        return buildResponse(BookService.add(book, id), HttpStatus.OK);
    }

    @GetMapping("/findId")
    public ResponseEntity<?> getId(@RequestParam Long id){
        return buildResponse(BookService.findId(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam Long id,
                                    @RequestParam String author,
                                    @RequestParam String genre){
        return buildResponse(BookService.update(id, author, genre), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id){
        BookService.delete(id);
        return buildResponse("deleted", HttpStatus.OK);
    }
//
//    @GetMapping("/findAll/v2")
//    public ResponseEntity<?> getAll_v2(){
//        return buildResponse(BookService.findAll_v2(), HttpStatus.OK);
//    }
}