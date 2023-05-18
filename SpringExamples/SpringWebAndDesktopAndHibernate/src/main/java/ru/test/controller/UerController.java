package ru.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.dao.UerDAO;
import ru.test.model.Material;

import java.util.List;

@RestController
public class UerController {

	private UerDAO uerDAO;

	@Autowired
	public void setUerDAO(UerDAO uerDAO) {
		this.uerDAO = uerDAO;
	}

	public UerDAO getUerDAO() {
		return uerDAO;
	}

	@GetMapping("/findUerRecords")
	public List<Material> findUerRecords() {
		List<Material> list = (List<Material>) uerDAO.findByShortName("Уголь");
		return list;
	}
}