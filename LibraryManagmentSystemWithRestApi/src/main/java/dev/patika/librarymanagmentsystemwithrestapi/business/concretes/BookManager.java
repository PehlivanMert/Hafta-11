package dev.patika.librarymanagmentsystemwithrestapi.business.concretes;

import dev.patika.librarymanagmentsystemwithrestapi.business.abstracts.IBookService;
import dev.patika.librarymanagmentsystemwithrestapi.core.exception.NotFoundException;
import dev.patika.librarymanagmentsystemwithrestapi.core.utilies.Msg;
import dev.patika.librarymanagmentsystemwithrestapi.dao.IBookRepo;
import dev.patika.librarymanagmentsystemwithrestapi.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookManager implements IBookService {
    private final IBookRepo bookRepo;

    public BookManager(IBookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book save(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public Book get(int id) {
        return this.bookRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Book> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.bookRepo.findAll(pageable);
    }

    @Override
    public Book update(Book book) {
        this.get(book.getId());
        return this.bookRepo.save(book);
    }

    @Override
    public boolean delete(int id) {
        Book book = this.get(id);
        this.bookRepo.delete(book);
        return true;
    }
}
