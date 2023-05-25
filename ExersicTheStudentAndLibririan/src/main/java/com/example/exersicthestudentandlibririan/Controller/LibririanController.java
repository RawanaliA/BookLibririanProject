package com.example.exersicthestudentandlibririan.Controller;
import com.example.exersicthestudentandlibririan.Model.Book;
import com.example.exersicthestudentandlibririan.Model.Librarian;
import com.example.exersicthestudentandlibririan.Repository.LibririanRepoistory;
import com.example.exersicthestudentandlibririan.Services.LibrarianServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/libriry")
@RequiredArgsConstructor
public class LibririanController  {
    private final LibrarianServices librarianServices;
    @GetMapping("/get")
    public ResponseEntity getAlll(){
        List<Librarian> gall= librarianServices.getAll();
        return ResponseEntity.status(200).body(gall);
    }
    @PostMapping("/add")
    public ResponseEntity addBook(@Valid Book book){
        return ResponseEntity.status(200).body("added Succssufullly");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@Valid@PathVariable Integer id,@RequestBody Librarian librarian ){
        librarianServices.updteBook(librarian,id);
        return ResponseEntity.status(200).body("The Libriry Update it Sucssfully");
    }
    @DeleteMapping("/delete")
    public ResponseEntity deletBook(Integer id){
        librarianServices.deleteBook(id);
        return ResponseEntity.status(200).body("The Libriry delete it Sucssfully");
    }
    //-get librarian by Id
    //-check login by username and password
    //-get librarian Account by email
    @GetMapping("/get-id/{id}")
    public ResponseEntity getById(@PathVariable Integer id){
        librarianServices.getLById(id);
        return ResponseEntity.status(200).body("The process done Sucssfully");
    }
    @GetMapping("/get-UPass/{user}/{pass}")
    public ResponseEntity getUserByUserPass(@PathVariable String user,String pass){
       Librarian librarian=librarianServices.getByUserPass(user,pass);
        return ResponseEntity.status(200).body(librarian);
    }

    @GetMapping("/get-email/{email}")
    public ResponseEntity getByTitle(@PathVariable String email){
        Librarian librarian1=librarianServices.getLByEmail(email);
        return ResponseEntity.status(200).body(librarian1);
  }

}
