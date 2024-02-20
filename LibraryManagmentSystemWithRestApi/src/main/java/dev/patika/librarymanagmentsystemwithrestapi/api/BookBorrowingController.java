package dev.patika.librarymanagmentsystemwithrestapi.api;

import dev.patika.librarymanagmentsystemwithrestapi.business.abstracts.IBookBorrowingService;
import dev.patika.librarymanagmentsystemwithrestapi.business.abstracts.IBookService;
import dev.patika.librarymanagmentsystemwithrestapi.core.config.modelMapper.IModelMapperService;
import dev.patika.librarymanagmentsystemwithrestapi.core.result.Result;
import dev.patika.librarymanagmentsystemwithrestapi.core.result.ResultData;
import dev.patika.librarymanagmentsystemwithrestapi.core.utilies.ResultHelper;
import dev.patika.librarymanagmentsystemwithrestapi.dto.request.bookborrowing.BookBorrowingSaveRequest;
import dev.patika.librarymanagmentsystemwithrestapi.dto.request.bookborrowing.BookBorrowingUpdateRequest;
import dev.patika.librarymanagmentsystemwithrestapi.dto.response.CursorResponse;
import dev.patika.librarymanagmentsystemwithrestapi.dto.response.bookborrowing.BookBorrowingResponse;
import dev.patika.librarymanagmentsystemwithrestapi.entities.Book;
import dev.patika.librarymanagmentsystemwithrestapi.entities.BookBorrowing;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/bookborrowings")
public class BookBorrowingController {

    private final IBookBorrowingService bookBorrowingService;
    private final IBookService bookService;
    private final IModelMapperService modelMapper;

    public BookBorrowingController(IBookBorrowingService bookBorrowingService, IBookService bookService, IModelMapperService modelMapper) {
        this.bookBorrowingService = bookBorrowingService;
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookBorrowingResponse> save(@Valid @RequestBody BookBorrowingSaveRequest bookBorrowingSaveRequest) {
        BookBorrowing saveBookBorrowing = this.modelMapper.forRequest().map(bookBorrowingSaveRequest, BookBorrowing.class);

        Book book = this.bookService.get(bookBorrowingSaveRequest.getBookId());
        saveBookBorrowing.setBook(book);

        this.bookBorrowingService.save(saveBookBorrowing);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveBookBorrowing, BookBorrowingResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookBorrowingResponse> get(@PathVariable("id") int id) {
        return ResultHelper.success(this.modelMapper.forResponse().map(this.bookBorrowingService.get(id), BookBorrowingResponse.class));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<BookBorrowingResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize

    ) {
        Page<BookBorrowing> bookBorrowingPage = this.bookBorrowingService.cursor(page, pageSize);
        Page<BookBorrowingResponse> bookBorrowingResponsePage = bookBorrowingPage
                .map(bookBorrowing -> this.modelMapper.forResponse().map(bookBorrowing, BookBorrowingResponse.class));

        return ResultHelper.cursor(bookBorrowingResponsePage);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookBorrowingResponse> update(@Valid @RequestBody BookBorrowingUpdateRequest bookBorrowingUpdateRequest) {

        BookBorrowing updateBookBorrowing = this.modelMapper.forRequest().map(bookBorrowingUpdateRequest, BookBorrowing.class);
        this.bookBorrowingService.update(updateBookBorrowing);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateBookBorrowing, BookBorrowingResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.bookBorrowingService.delete(id);
        return ResultHelper.ok();
    }
}