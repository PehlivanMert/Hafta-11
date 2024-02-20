package dev.patika.librarymanagmentsystemwithrestapi.api;

import dev.patika.librarymanagmentsystemwithrestapi.business.abstracts.*;
import dev.patika.librarymanagmentsystemwithrestapi.core.config.modelMapper.IModelMapperService;
import dev.patika.librarymanagmentsystemwithrestapi.core.result.Result;
import dev.patika.librarymanagmentsystemwithrestapi.core.result.ResultData;
import dev.patika.librarymanagmentsystemwithrestapi.core.utilies.ResultHelper;
import dev.patika.librarymanagmentsystemwithrestapi.dto.request.book.BookSaveRequest;
import dev.patika.librarymanagmentsystemwithrestapi.dto.request.book.BookUpdateRequest;
import dev.patika.librarymanagmentsystemwithrestapi.dto.request.bookborrowing.BookBorrowingUpdateRequest;
import dev.patika.librarymanagmentsystemwithrestapi.dto.response.CursorResponse;
import dev.patika.librarymanagmentsystemwithrestapi.dto.response.book.BookResponse;
import dev.patika.librarymanagmentsystemwithrestapi.dto.response.category.CategoryResponse;
import dev.patika.librarymanagmentsystemwithrestapi.entities.*;
import dev.patika.librarymanagmentsystemwithrestapi.entities.Book;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    private final IBookService bookService;
    private final IAuthorService authorService;
    private final ICategoryService categoryService;
    private final IPublisherService publisherService;
    private final IModelMapperService modelMapper;

    public BookController(IBookService bookService, IAuthorService authorService, ICategoryService categoryService, IPublisherService publisherService, IModelMapperService modelMapper) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.publisherService = publisherService;
        this.modelMapper = modelMapper;
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest) {
        Book saveBook = this.modelMapper.forRequest().map(bookSaveRequest, Book.class);

        Author author = this.authorService.get(bookSaveRequest.getAuthorId());
        saveBook.setAuthor(author);

        Publisher publisher  = this.publisherService.get(bookSaveRequest.getPublisherId());
        saveBook.setPublisher(publisher);

        List<Category> categoryList = new ArrayList<>();
        for (Integer categoryId : bookSaveRequest.getCategoryIds()) {
            Category category = this.categoryService.get(categoryId);
            categoryList.add(category);
        }
        saveBook.setCategorylist(categoryList);

        this.bookService.save(saveBook);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveBook, BookResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> get(@PathVariable("id") int id) {
        return ResultHelper.success(this.modelMapper.forResponse().map(this.bookService.get(id), BookResponse.class));
    }


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<BookResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize

    ) {
        Page<Book> bookPage = this.bookService.cursor(page, pageSize);
        Page<BookResponse> bookResponsePage = bookPage
                .map(book -> this.modelMapper.forResponse().map(book, BookResponse.class));

        return ResultHelper.cursor(bookResponsePage);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> update(@Valid @RequestBody BookUpdateRequest bookUpdateRequest) {

        Book updateBook = this.modelMapper.forRequest().map(bookUpdateRequest, Book.class);
        this.bookService.update(updateBook);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateBook, BookResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.bookService.delete(id);
        return ResultHelper.ok();
    }
}

