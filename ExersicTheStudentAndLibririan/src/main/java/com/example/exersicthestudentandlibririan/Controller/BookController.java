package com.example.exersicthestudentandlibririan.Controller;

import com.example.exersicthestudentandlibririan.Model.Book;
import com.example.exersicthestudentandlibririan.Services.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    //اجرب ايش يفرق الرسبونس انتتي عن الليست بالقيت اتوقع انه مارح يطبع لي اللسته كامله انا ابغى اللسته كامله
    @GetMapping("/get")
    public ResponseEntity getAlll(){
       List<Book> all= bookService.getAll();
          return ResponseEntity.status(200).body(all);
    }
    @PostMapping("/add")
    public ResponseEntity addBook(@Valid Book book){
        return ResponseEntity.status(200).body("added Succssufullly");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@Valid@PathVariable Integer id,@RequestBody Book book){
        bookService.updteBook(book,id);
        return ResponseEntity.status(200).body("The Book Update it Sucssfully");
    }
    @DeleteMapping("/delete")
    public ResponseEntity deletBook(Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("The Book delete it Sucssfully");
    }
    //the
    @GetMapping("/get-author/{author}")
public ResponseEntity getByAuothor(@PathVariable String author){
        bookService.getBlogByAuothor(author);
    return ResponseEntity.status(200).body("The process done Sucssfully");
}
    @GetMapping("/get-catogry/{catogry}")
    public ResponseEntity getUserByCatogry(@PathVariable String catogry){
        List<Book> cbook=bookService.getUserByCatogry(catogry);
        return ResponseEntity.status(200).body(cbook);
    }
    @GetMapping("/get-np/{nOfp}")
    public ResponseEntity get(@PathVariable int nOfp){
        List<Book> nbook=bookService.getBookByNumberOfPagesGreaterThan(nOfp);
        return ResponseEntity.status(200).body(nbook);
    }
    @GetMapping("/get-title/{title}")
    public ResponseEntity getByTitle(@PathVariable String title){
        Book tbook=bookService.getBlogByAuothor(title);
        return ResponseEntity.status(200).body(tbook);
    }


}
