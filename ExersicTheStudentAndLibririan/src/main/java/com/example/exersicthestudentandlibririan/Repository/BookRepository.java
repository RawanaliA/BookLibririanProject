package com.example.exersicthestudentandlibririan.Repository;
import com.example.exersicthestudentandlibririan.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
//All CRUD
//-Get books by Category
//-Get books hava pages more than 300
// Get books by Author
//-search for book by title
//Book getBookById(Integer id);
    List<Book> getBooksByCategory(String catogry);
    Book getBooksByAuthor(String author);
    Book findBookByTitle(String title);
    List<Book> getBookByNumberOfPagesGreaterThan(int nOfpage);
    Book getBooksById(Integer id);
}
