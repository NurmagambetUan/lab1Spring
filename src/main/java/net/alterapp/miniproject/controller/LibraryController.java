package net.alterapp.miniproject.controller;

import net.alterapp.miniproject.domain.Library;
import net.alterapp.miniproject.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/library")
public class LibraryController extends BaseController{
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> getAll() {
        return buildResponse(libraryService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/findId")
    public ResponseEntity<?> getId(@RequestParam Long id){
        return buildResponse(libraryService.findId(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Library library) {
        return buildResponse(libraryService.add(library), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam Long id,
                                    @RequestParam String name,
                                    @RequestParam String address) {
        return buildResponse(libraryService.update(id, name, address), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam(value ="city") String city) {
             libraryService.delete(city);
             return buildResponse("deleted", HttpStatus.OK);
     }
}



