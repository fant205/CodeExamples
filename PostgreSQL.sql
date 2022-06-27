
--Cправочник по SQL в PostgreSQL

SQL глубинные смыслы:
	Процедуры используются для:
	- для реализации сложной серверной логики обработки данных, например в банковских системах.
	- для доступа к данным в виде отчетов
	- для трансформации, очистки, валидации данных на сервере
	Плохое использование:
	- для CRUD не стоит

	Триггеры обычно используются для:
	- Логирования изменений
	- Лучше ими не злоупотреблять и вынести эту логику типа автор изменения или дата изменения явно в код.

	Индексы:
	- Для задействования индекса необходимо искать по первой части строки, то есть заменить
		like '%Ny%'
		на
		like 'Ny%'


USE geodata;

select * from _countries;

--Таблица _coutries
	--удалить колонки
	ALTER TABLE _countries 
		DROP COLUMN title_en,
		


	--изменение поля title_ru
		--изменить тип колонки
			ALTER TABLE _countries ALTER COLUMN title_ru SET DATA TYPE VARCHAR(150);

		--сделать NOT NULL
			ALTER TABLE _countries ALTER COLUMN title_ru SET NOT NULL;

		--переименовать колонку
			ALTER TABLE _countries RENAME COLUMN title_ru TO title;
			
		--индекс 		
			create index idx_countries_title on _countries (title);

		--Для Postgres, что бы сделать автоинкремент пришлось поискать в интернете
			CREATE SEQUENCE _countries_seq;
			ALTER TABLE _countries ALTER COLUMN id SET DEFAULT nextval('_countries_seq');
			ALTER TABLE _countries ALTER COLUMN id SET NOT NULL;
			ALTER SEQUENCE _countries_seq OWNED BY _countries.id;
			SELECT setval('_countries_seq', (SELECT max(id) FROM _countries));

		-- PRIMARY KEY;
			alter table _countries add primary key (id);
			
		-- FOREIGN KEY;
			alter table _regions add foreign key (country_id) references _countries (id);			



--Создание пользователя для geodata:
	CREATE ROLE user_group;
	CREATE ROLE user_db WITH LOGIN ENCRYPTED PASSWORD 'passdb';
	GRANT user_group TO user_db;
	GRANT CONNECT ON DATABASE geodata TO user_group;
	grant all privileges on database geodata to user_db;



--Создание таблицы:
	--Main table:
		create table users (
			id serial primary key, --serial указывает автонумерацию
		    login text NOT NULL UNIQUE,
		    password text NOT NULL,
		    nickname text NOT NULL UNIQUE	
		);
	--Зависимая:
		create table likes (
			id serial primary key,
			create_stamp timestamp,
			from_id integer,
			to_id integer,
			active smallint,
			foreign key (from_id) references users (id),
			foreign key (to_id) references users (id)
		);


--Изменение таблицы
		alter table likes 
		add column obj_type integer, 	--Добавить колонку
		add foreign key (obj_type)		--Добавить внешний ключ
			references obj_types (id); 

--Удаление элементов таблицы
	Alter table users
	drop constraint users_pkey;


--Импорт данных:
	Insert into users (name) 
		values 	('Вася'),
				('Маша'),
				('Катя');
				
	--дочерняя таблицаы
	Insert into likes (create_stamp, from_id, to_id, active)
		values 
			(current_timestamp, 2, 1, 1),
			(current_timestamp, 3, 1, 1),
			(current_timestamp, 1, 2, 1),
			(current_timestamp, 4, 3, 1),
			(current_timestamp, 4, 5, 1);

--Join

	--С помощью джоина вычитаю одну выборку из другой. в итоге остаеются 2 и 3)
		select users.id, users.name
		from (
			select distinct(from_id) from likes where to_id in (1,2)
		) as t1
		left join (
			select distinct(from_id) from likes where to_id = 3 order by from_id
		) as t2
		on t2.from_id = t1.from_id
		left join users
		on users.id = t1.from_id
		where t2.from_id is null; -- с помощью этого where делаем вычитание одного множества из другого


--Функуция
	--есть входные и выходные параметры:
		CREATE OR REPLACE FUNCTION  getManagerName(in f1 text, in f2 text, out f3 text)
	    AS $$ 
		
			select 'return result'
		
		$$
	    LANGUAGE SQL;

		--test
			SELECT * FROM getManagerName('f1', 'f2');

	--функция ничего не возвращает:
		CREATE OR REPLACE FUNCTION  shareFile(in fileName text, in filePath text, in ownerUser text, in targerUser text) 
		RETURNS void
		AS $$ 

		    select 'geg'

		$$
		LANGUAGE SQL;

		--test
	    	SELECT * FROM shareFile('fileName', 'filePath', 'ownerUser', 'targerUser');



--Хранимая процедура
	CREATE OR REPLACE PROCEDURE shareFile2(
	"fileName" text,
	"filePath" text,
	"ownerName" text,
	"targetUserName" text)
	LANGUAGE 'plpgsql'
	AS $BODY$
	Declare  
	    ownerId int;
	    targetUserId int;
	    fileId int;
	Begin


	    --search owner id
	    select id into ownerId from users where nickname = "ownerName";
	    
	    --search targerUser id
	    select id into targetUserId from users where nickname = "targetUserName";

	    --save file to table
	    insert into files (file_name, file_path, owner_id)
	        values ("fileName", "filePath", ownerId);
	        
	    --search file id
	    select id into fileId from files where files.file_name = "fileName" and files.file_path = "filePath" and files.owner_id = ownerId;
	        
	    --save info to share table
	    insert into files_share (file_id, target_user_id)
	        values (fileId, targetUserId);
	        
	        
	end
	$BODY$;

	--полномочия на вызов
		ALTER PROCEDURE shareFile2(text, text, text, text) OWNER TO fnrtuqrj;
	       
	--пример вызова
		CALL shareFile2('file4', 'file1Path2', 'test', 'test2')

	--пример вызова в Java:
		public static void main(String[] args) throws SQLException {
        try (Connection connection1 = DriverManager.getConnection(
                "jdbc:postgresql://tyke.db.elephantsql.com:5432/fnrtuqrj",
                "fnrtuqrj",
                "NLpOUejgCpyCN9POcNC7XlDtSK3h4Hw6")) {

            String preparedSql = " call shareFile2(?,?,?,?)";
            try (CallableStatement cstmt = connection1.prepareCall(preparedSql)) {
                cstmt.setString(1, "fileName111");
                cstmt.setString(2, "filePath111");
                cstmt.setString(3, "test");
                cstmt.setString(4, "test2");
                cstmt.execute();
            }
        }