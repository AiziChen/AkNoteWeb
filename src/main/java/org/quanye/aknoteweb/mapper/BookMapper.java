package org.quanye.aknoteweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.quanye.aknoteweb.mapper.domain.Book;
import org.quanye.aknoteweb.mapper.domain.Note;
import org.quanye.aknoteweb.mapper.provider.BookMapperProvider;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
	@Override
	@Select("SELECT * FROM BOOK WHERE ID = #{id}")
	public Book findById(Integer id);

	@Select("SELECT * FROM BOOK")
	public List<Book> findAll();

	@Override
	@Insert("INSERT INTO BOOK (TITLE, CREATE_DATETIME, MODIFY_DATETIME)"
			+ " VALUES (#{title}, #{createDatetime}, #{modifyDatetime})")
	public void insertNew(Book domain);

	@Override
	@UpdateProvider(type = BookMapperProvider.class, method = "updateById")
	public void updateById(Integer id, Book domain);

	@Override
	@Delete("DELETE FROM BOOK WHERE ID = #{id}")
	public void deleteById(Integer id);

	@Select("SELECT ID, TITLE, AUTHOR, CREATE_DATETIME, MODIFY_DATETIME, BOOK_ID"
			+ " FROM NOTE WHERE BOOK_ID = #{id}")
	public List<Note> getNotes(Integer id);
}
