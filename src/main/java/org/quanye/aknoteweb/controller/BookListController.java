package org.quanye.aknoteweb.controller;

import java.util.Date;
import java.util.List;

import org.quanye.aknoteweb.mapper.domain.Book;
import org.quanye.aknoteweb.mapper.domain.Note;
import org.quanye.aknoteweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookListController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("books", bookService.findAll());
		return "index";
	}

	@RequestMapping("book/{id}")
	public String entryNote(@PathVariable Integer id, Model model) {
		Book book = bookService.findById(id);
		model.addAttribute("bookName", book.getTitle());
		List<Note> notes = bookService.getNotes(id);
		model.addAttribute("notes", notes);
		return "note_list";
	}

	@RequestMapping("/book/deleteBook")
	public String deleteBook(@RequestParam Integer id, Model model) {
		if (id != null) {
			bookService.deleteById(id);
		}
		return "redirect:/";
	}

	@RequestMapping("/book/newBook")
	public String insertNewBook(@RequestParam String name) {
		Book book = new Book();
		book.setCreateDatetime(new Date());
		book.setModifyDatetime(book.getCreateDatetime());
		book.setTitle(name);
		bookService.insertNew(book);
		return "redirect:/";
	}
}
