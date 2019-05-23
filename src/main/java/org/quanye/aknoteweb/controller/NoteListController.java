package org.quanye.aknoteweb.controller;

import java.util.Date;

import org.quanye.aknoteweb.mapper.domain.Note;
import org.quanye.aknoteweb.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/note")
public class NoteListController {

	@Autowired
	private NoteService noteService;

	@RequestMapping("/newNote/{bookId}")
	public String newNote(@RequestParam String title,
			@RequestParam String content, @RequestParam String author,
			@PathVariable Integer bookId, Model model) {
		Note note = new Note();
		note.setAuthor(author);
		note.setTitle(title);
		note.setContent(content);
		note.setBookId(bookId);
		note.setDatetime(new Date());
		noteService.insertNew(note);
		model.addAttribute("note", note);
		return "note_view";
	}

	@RequestMapping("/{id}")
	public String entryNote(@PathVariable Integer id, Model model) {
		Note note = noteService.findById(id);
		System.out.println(note.getTitle() + "--" + note.getDatetime());
		model.addAttribute("note", note);
		return "note_view";
	}
}
