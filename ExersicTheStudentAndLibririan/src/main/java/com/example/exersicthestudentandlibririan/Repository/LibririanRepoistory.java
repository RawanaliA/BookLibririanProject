package com.example.exersicthestudentandlibririan.Repository;

import com.example.exersicthestudentandlibririan.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibririanRepoistory extends JpaRepository<Librarian,Integer> {
//-get librarian by Id
//-check login by username and password
//-get librarian Account by email
    Librarian getLibrarianById(Integer id);
    Librarian getLibrarianByUsernameAndEmail(String username,String email);
    Librarian getLibrarianByEmail(String e);
}
