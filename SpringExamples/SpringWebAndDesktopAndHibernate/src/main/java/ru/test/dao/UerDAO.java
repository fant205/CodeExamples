package ru.test.dao;

import java.util.List;

import ru.test.model.Material;

public interface UerDAO {
	List<Material> findByShortName(String shortName);

}
