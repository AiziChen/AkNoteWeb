package org.quanye.aknoteweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.quanye.aknoteweb.mapper.domain.Note;

@Mapper
public interface NoteMapper extends BaseMapper<Note> {
	@Select("SELECT * FROM NOTE WHERE ID = #{id}")
	@Override
	public Note findById(Integer id);

	@Override
	@Insert("INSERT INTO NOTE (TITLE, AUTHOR, CONTENT, DATETIME, BOOK_ID)"
			+ " VALUES (#{title}, #{author}, #{content}, #{datetime}, #{bookId})")
	public void insertNew(Note note);

	@Override
	public void updateById(Integer id, Note note);

	@Override
	public void deleteById(Integer id);

	@Select("SELECT * FROM NOTE")
	public List<Note> findAll();
}
