package org.quanye.aknoteweb.service;

import java.util.List;

import org.quanye.aknoteweb.mapper.BookMapper;
import org.quanye.aknoteweb.mapper.NoteMapper;
import org.quanye.aknoteweb.mapper.domain.Book;
import org.quanye.aknoteweb.mapper.domain.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService extends BaseService<Book> implements BookMapper {

	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private NoteMapper noteMapper;

	@Override
	public List<Book> findAll() {
		return bookMapper.findAll();
	}

	@Override
	public List<Note> getNotes(Integer id) {
		return bookMapper.getNotes(id);
	}

	@Override
	public void deleteById(Integer id) {
		super.deleteById(id);
		noteMapper.deleteByBookId(id);
	}
}
