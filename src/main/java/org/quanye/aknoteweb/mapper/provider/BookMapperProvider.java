package org.quanye.aknoteweb.mapper.provider;

import org.apache.ibatis.jdbc.SQL;
import org.quanye.aknoteweb.mapper.domain.Book;

public class BookMapperProvider {
	/**
	 * updateById
	 * @param id
	 * @param book
	 * @return SQL
	 */
	public String updateById(Integer id, Book book) {
		return new SQL() {
			{
				UPDATE("BOOK");
				if (book.getTitle() != null) {
					SET("TITLE = #{title}");
				}
				if (book.getCreateDatetime() != null) {
					SET("TITLE = #{createDatetime}");
				}
				if (book.getModifyDatetime() != null) {
					SET("TITLE = #{modifyDatetime}");
				}
				WHERE("ID = #{id}");
			}
		}.toString();
	}
}
