package org.quanye.aknoteweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.quanye.aknoteweb.mapper.domain.Note;
import org.quanye.aknoteweb.mapper.provider.NoteMapperProvider;

@Mapper
public interface NoteMapper extends BaseMapper<Note> {
	@Select("SELECT * FROM NOTE WHERE ID = #{id}")
	@Override
	public Note findById(Integer id);

	@Override
	@Insert("INSERT INTO NOTE (TITLE, AUTHOR, CONTENT, CREATE_DATETIME, MODIFY_DATETIME, BOOK_ID)"
			+ " VALUES (#{title}, #{author}, #{content}, #{createDatetime}, #{modifyDatetime}, #{bookId})")
	public void insertNew(Note note);

	@UpdateProvider(type = NoteMapperProvider.class, method = "updateById")
	@Override
	public void updateById(Integer id, Note note);

	@Delete("DELETE NOTE WHERE ID = #{id}")
	@Override
	public void deleteById(Integer id);

	@Select("SELECT * FROM NOTE")
	public List<Note> findAll();

	@Delete("DELETE FROM NOTE WHERE BOOK_ID = #{bookId}")
	public void deleteByBookId(Integer bookId);
}
