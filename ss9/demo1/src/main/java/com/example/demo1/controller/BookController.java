package com.example.demo1.controller;

import com.example.demo1.exception.ExceptionHandle;
import com.example.demo1.model.Book;
import com.example.demo1.model.BorrowBook;
import com.example.demo1.service.IBookService;
import com.example.demo1.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Random;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;

    @Autowired
    private IBorrowService iBorrowBookService;

    @GetMapping("")
    public String showList(Model model) {
        List<Book> bookList = iBookService.findAll();
        model.addAttribute("bookList", bookList);
        return "/list";
    }

    @GetMapping("/view/{id}")
    public String showFormBorrow(@PathVariable int id, Model model) throws ExceptionHandle {
        Book book = iBookService.findById(id);
        if (book.getAmount() == 0) {
            throw new ExceptionHandle();
        } else {
            model.addAttribute("book", book);
        }
        return "borrow";
    }

    @PostMapping("/borrow")
    public String saveBorrowBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        book.setAmount(book.getAmount() - 1);
        iBookService.save(book);

        String code = String.valueOf(new Random().nextInt(90000) + 10000);
        BorrowBook borrowBook = new BorrowBook(book.getBookId(), code);
        iBorrowBookService.save(borrowBook);

        redirectAttributes.addFlashAttribute("message", "Bạn đã mượn " + book.getName() + "thành công"
                + ", Mã mượn sách: " + code);
        return "redirect:/";
    }

    @GetMapping("/return-book")
    public String showFormReturnBook() {
        return "/return";
    }

    @PostMapping("/return")
    public String saveReturnBook(@RequestParam String code, RedirectAttributes redirectAttributes) {
        BorrowBook borrowBook = iBorrowBookService.findByCode(code);

        if (borrowBook == null) {
            redirectAttributes.addFlashAttribute("message", "Mã mượn sách không đúng, vui lòng nhập lại");
            return "redirect:return-book";
        } else {
            Book book = iBookService.findById(borrowBook.getId());
            book.setAmount(book.getAmount() + 1);
            iBookService.save(book);
            iBorrowBookService.remove(borrowBook.getId());
            redirectAttributes.addFlashAttribute("message", "Bạn đã trả sách: " +
                    book.getName() + "thành công.");
            return "redirect:/";
        }
    }

    @ExceptionHandler(ExceptionHandle.class)
    public String showException() {
        return "errorPage";
    }
}
