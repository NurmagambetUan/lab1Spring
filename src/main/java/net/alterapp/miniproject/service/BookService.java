package net.alterapp.miniproject.service;

import net.alterapp.miniproject.domain.Book;
import net.alterapp.miniproject.domain.Library;
import net.alterapp.miniproject.repository.BookRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookService {
    private final BookRepo bookRepo;
    private final LibraryService libraryService;

    public BookService(BookRepo bookRepo, LibraryService libraryService) {
        this.bookRepo = bookRepo;
        this.libraryService = libraryService;
    }

    public List<Book> findAll() {
        return bookRepo.findAllByDeletedAtIsNull();
    }

    public Book add(Book book, Long id) {
        Library library = libraryService.findId(id);
        book.setLibrary(library);
        if (book.getLibrary().getId() == null) {
            System.out.println("there is no such id");
            return book;
        } else {
            bookRepo.save(book);
            return book;
        }
    }
    public Book findId (Long id){
        return bookRepo.findByIdAndDeletedAtIsNull(id);
    }

    public String update (Long id, String author, String genre){
        Book book = bookRepo.findByIdAndDeletedAtIsNull(id);
        book.setAuthor(author);
        book.setGenre(genre);
        bookRepo.save(book);
        return "updated";
    }
    public void delete (Long id) {
            Book book = bookRepo.findByIdAndDeletedAtIsNull(id);
            Date date = new Date();
            book.setDeletedAt(date);
            bookRepo.save(book);
        }

//    public List<Book> findAll_v2() {
//        for (Book book : books) {
//            if(book.getPagesamount()> i)
//                System.out.println(book);
//        }
//    }



    }
