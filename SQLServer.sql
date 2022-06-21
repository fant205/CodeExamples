
--Полнотекстовый поиск
	--Настройка
		/*-- create fulltext catalog
		CREATE FULLTEXT CATALOG MtrLiteCatalog
		 WITH ACCENT_SENSITIVITY = ON
		 AS DEFAULT
		 AUTHORIZATION dbo
	   GO
	   */

	   --Изменение полнотекстового каталога
	   /*
	   ALTER FULLTEXT CATALOG MtrLiteCatalog
		 REBUILD WITH ACCENT_SENSITIVITY=OFF
	   GO
	   */
	   
	   --возвращаем назад
	   /*
	   ALTER FULLTEXT CATALOG MtrLiteCatalog
		 REBUILD WITH ACCENT_SENSITIVITY=ON
	   GO
	   */

	   --удалить каталог
	   --   DROP FULLTEXT CATALOG MtrLiteCatalog;

	   --Создание полнотекстового индекса
	   /*
	   CREATE FULLTEXT INDEX ON NSI_MATERIALS(ShortName)
		 KEY INDEX PK_NSI_MATERIALS ON (MtrLiteCatalog)
		 WITH (CHANGE_TRACKING AUTO)
	   GO
	   */

	--Примеры запросов
	   --полнотекстовый запрос пример
	   SELECT GID, ShortName
	   FROM NSI_MATERIALS
	   WHERE CONTAINS (ShortName, '"Батар*труб*"');
	   

	   --CONTAINS. Поиск слова по словоформам
	   SELECT GID, ShortName
	   FROM NSI_MATERIALS
	   WHERE CONTAINS (ShortName, 'FORMSOF(INFLECTIONAL, "Красная гитара")');

	   --CONTAINS. Поиск слов или фраз с учетом расположения
	   SELECT GID, ShortName
	   FROM NSI_MATERIALS
	   WHERE CONTAINS (ShortName, '"ГИТАРА" NEAR "красная"');

	   SELECT COUNT(*) FROM NSI_MATERIALS WHERE CONTAINS (ShortName, 'NEAR(гитара, красная)')

	   --FREETEXT
	   SELECT GID, ShortName
	   FROM NSI_MATERIALS
	   WHERE FREETEXT (ShortName, 'струна');
	   
	   
	   INSERT INTO NSI_MATERIALS (GID, ShortName)
	   VALUES 
	   ('GID1', N'Красные материалы'),
	   ('GID2', N'Гитаре красной'),
	   ('GID3', N'Красными гитaрой (здесь в а в гитаре английская)'),
	   ('GID4', N'красная гитара'),
	   ('GID5', N'гитара красная'),
	   ('GID6', N'гитаре красной'),
	   ('GID7', N'ГИТАРОЙ КРасной'),
	   ('GID8', N'Красная зеленая гитара')
	   --('GID15', N'Зеленый автомобиль'),
	   --('GID17', N'Зеленая машина')

		



