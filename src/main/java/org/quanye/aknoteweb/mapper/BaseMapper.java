package org.quanye.aknoteweb.mapper;

public interface BaseMapper<DOMAIN> {
	public DOMAIN findById(Integer id);

	public void deleteById(Integer id);

	public void updateById(Integer id, DOMAIN domain);

	public void insertNew(DOMAIN domain);
}
