package org.quanye.aknoteweb.service;

import java.util.List;

import org.quanye.aknoteweb.mapper.NoteMapper;
import org.quanye.aknoteweb.mapper.domain.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService extends BaseService<Note> implements NoteMapper {

	@Autowired
	private NoteMapper noteMapper;

	@Override
	public List<Note> findAll() {
		return noteMapper.findAll();
	}

	@Override
	public void deleteByBookId(Integer bookId) {
		noteMapper.deleteByBookId(bookId);
	}

}
