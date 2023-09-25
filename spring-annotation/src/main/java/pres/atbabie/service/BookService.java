package pres.atbabie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pres.atbabie.dao.BookDAO;

import javax.annotation.Resource;
import javax.inject.Inject;

@Service
public class BookService {

//    @Autowired(required = false)
//    @Resource
    @Inject
    private BookDAO bookDAO;
    public void print(){
        System.out.println(bookDAO);
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDAO=" + bookDAO +
                '}';
    }
}

