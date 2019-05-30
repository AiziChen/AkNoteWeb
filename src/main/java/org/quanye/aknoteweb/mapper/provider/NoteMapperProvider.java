package org.quanye.aknoteweb.mapper.provider;

import org.apache.ibatis.jdbc.SQL;
import org.quanye.aknoteweb.mapper.domain.Note;

public class NoteMapperProvider {
	/**
	 * updateById
	 * @param id
	 * @param note
	 * @return SQL
	 */
	public String updateById(Integer id, Note note) {
		return new SQL() {
			{
				UPDATE("NOTE");
				if (note.getAuthor() != null) {
					SET("AUTHOR = #{author}");
				}
				if (note.getContent() != null) {
					SET("CONTENT = #{content}");
				}
				if (note.getCreateDatetime() != null) {
					SET("DATETIME = #{createDatetime}");
				}
				if (note.getModifyDatetime() != null) {
					SET("DATETIME = #{modifyDatetime}");
				}
				if (note.getTitle() != null) {
					SET("TITLE = #{title}");
				}
				WHERE("ID = #{id}");
			}
		}.toString();
	}
}
