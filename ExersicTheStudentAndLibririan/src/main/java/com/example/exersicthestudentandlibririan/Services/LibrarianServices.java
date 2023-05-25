package com.example.exersicthestudentandlibririan.Services;

import com.example.exersicthestudentandlibririan.ApiExeption.ApiExeption;
import com.example.exersicthestudentandlibririan.Model.Book;
import com.example.exersicthestudentandlibririan.Model.Librarian;
import com.example.exersicthestudentandlibririan.Repository.LibririanRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianServices {
    private  final LibririanRepoistory libririanRepoistory;
    //All CRUD
    public List<Librarian> getAll(){
        List<Librarian> allBooks=  libririanRepoistory.findAll();
        return allBooks;
    }
    public void addBook(Librarian librarian ){
        libririanRepoistory.save(librarian);;
    }
    public void updteBook(Librarian librarian,Integer id){
        Librarian librarian1 =libririanRepoistory.getById(id);
        if(librarian==null){
            throw new ApiExeption("");
        }
        librarian.setId(librarian.getId());
        librarian.setName(librarian.getName());
        librarian.setUsername(librarian.getUsername());
        librarian.setPassword(librarian.getPassword());
        librarian.setEmail(librarian.getEmail());
        libririanRepoistory.save(librarian1);
    }
    public void deleteBook(Integer id){
        Librarian librarian2 =libririanRepoistory.getById(id);
        if(librarian2==null){
            throw new ApiExeption("Enter a correct ID");
        }
        libririanRepoistory.delete(librarian2);
    }
    //
    public Librarian getLById(Integer id){
       Librarian librarian=libririanRepoistory.getLibrarianById(id);
        if(librarian==null)
            throw new ApiExeption("Make sure from your Id ");
        return librarian;
    }
    public Librarian getByUserPass(String user,String pass){
        Librarian librarian=libririanRepoistory.getLibrarianByUsernameAndEmail(user,pass);
        if(librarian==null)
            throw new ApiExeption("Make sure from your Id ");
        return librarian;
    }
    public Librarian getLByEmail(String email ){
        Librarian librarian=libririanRepoistory.getLibrarianByEmail(email);
        if(librarian==null)
            throw new ApiExeption("Make sure from your Id ");
        return librarian;
    }
}
