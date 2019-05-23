package org.quanye.aknoteweb.service;

import org.quanye.aknoteweb.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<DOMAIN> implements BaseMapper<DOMAIN> {

	@Autowired
	private BaseMapper<DOMAIN> mapper;

	@Override
	public DOMAIN findById(Integer id) {
		return mapper.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		mapper.deleteById(id);
	}

	@Override
	public void updateById(Integer id, DOMAIN domain) {
		mapper.updateById(id, domain);
	}

	@Override
	public void insertNew(DOMAIN domain) {
		mapper.insertNew(domain);
	}

}
