package com.example.exersicthestudentandlibririan.Services;

import com.example.exersicthestudentandlibririan.ApiExeption.ApiExeption;
import com.example.exersicthestudentandlibririan.Model.Book;
import com.example.exersicthestudentandlibririan.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book>getAll(){
       List<Book> allBooks=  bookRepository.findAll();
       return allBooks;
    }
    public void addBook(Book book){
        bookRepository.save(book);;
    }
//All CRUD
//-Get books by Category
//-Get books hava pages more than 300
//Get books by Author
//-search for book by title
    public void updteBook(Book book,Integer id){
        Book oldbook=bookRepository.getById(id);
        if(oldbook==null){
          throw new ApiExeption("");
        }
        oldbook.setId(book.getId());
        oldbook.setCategory(book.getCategory());
        oldbook.setAuthor(book.getAuthor());
        oldbook.setNumberOfPages(book.getNumberOfPages());
        bookRepository.save(oldbook);
}
       public void deleteBook(Integer id){
        Book dbook=bookRepository.getById(id);
        if(dbook==null){
            throw new ApiExeption("Enter a correct ID");
        }
      bookRepository.delete(dbook);
    }
    public Book getBlogByAuothor(String auother){
        Book abook=bookRepository.getBooksByAuthor(auother);
        if(abook==null)
            throw new ApiExeption("Make sure from the name of auother ");
        return abook;
    }
    public List<Book> getUserByCatogry(String catogry){
        List<Book> cbook=bookRepository.getBooksByCategory(catogry);
        if(cbook==null)
            throw new ApiExeption("Make sure from your catogry");
        return cbook;
    }
   public List<Book> getBookByNumberOfPagesGreaterThan(int nOfp){
       List<Book> nbook=bookRepository.getBookByNumberOfPagesGreaterThan(nOfp);

       if(nbook==null)
           throw new ApiExeption("Make sure from your catogry");
       return nbook;
   }
   public Book searchByTitle(String title){
       Book sbook=bookRepository.getBooksByAuthor(title);
       if(sbook==null)
           throw new ApiExeption("Make sure from the name of auother ");
       return sbook;
   }
   }
