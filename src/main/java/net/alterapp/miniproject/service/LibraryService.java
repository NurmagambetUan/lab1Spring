package net.alterapp.miniproject.service;

import net.alterapp.miniproject.domain.Library;
import net.alterapp.miniproject.repository.BookRepo;
import net.alterapp.miniproject.repository.LibraryRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LibraryService {
    private final LibraryRepo libraryRepo;
    private final BookRepo bookRepo;

    public LibraryService(LibraryRepo libraryRepo, BookRepo bookRepo) {
        this.libraryRepo = libraryRepo;
        this.bookRepo = bookRepo;
    }



    public List<Library> findAll(){
        return libraryRepo.findAllByDeletedAtIsNull();
    }

    public Library add (Library library) {
        return libraryRepo.save(library);
    }

    public Library findId (Long id){
        return libraryRepo.findByIdAndDeletedAtIsNull(id);
    }

    public String update (Long id, String name, String address) {
        Library library = libraryRepo.findByIdAndDeletedAtIsNull(id);
        library.setName(name);
        library.setAddress(address);
        libraryRepo.save(library);
        return "updated";
    }
    public void delete (String city) {
        List<Library> libraries = libraryRepo.findAllByCityAndDeletedAtIsNull(city);
        if (libraries.size()>0) {
            for (Library library: libraries) {
                Date date = new Date();
                library.setDeletedAt(date);
                libraryRepo.save(library);
            }
        }
    }


//    public Library findId_v2 (Long id) {
//        return bookRepo.findAllByLibraryIdAndDeletedAtIsNull(id);
//    }



}
