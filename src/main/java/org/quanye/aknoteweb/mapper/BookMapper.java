package org.quanye.aknoteweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.quanye.aknoteweb.mapper.domain.Book;
import org.quanye.aknoteweb.mapper.domain.Note;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
	@Override
	@Select("SELECT * FROM BOOK WHERE ID = #{id}")
	public Book findById(Integer id);

	@Select("SELECT * FROM BOOK")
	public List<Book> findAll();

	@Override
	@Insert("INSERT INTO BOOK (TITLE, DATETIME) VALUES (#{title}, #{datetime})")
	public void insertNew(Book domain);

	@Override
	@Delete("DELETE FROM BOOK WHERE ID = #{id}")
	public void deleteById(Integer id);

	@Select("SELECT * FROM NOTE WHERE BOOK_ID = #{id}")
	public List<Note> getNotes(Integer id);
}
