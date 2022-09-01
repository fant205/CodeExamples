
--�������������� �����
	--���������
		-- create fulltext catalog
		CREATE FULLTEXT CATALOG MtrLiteCatalog
		 WITH ACCENT_SENSITIVITY = ON
		 AS DEFAULT
		 AUTHORIZATION dbo
	   GO
	   

	   --��������� ��������������� ��������
	   
	   ALTER FULLTEXT CATALOG MtrLiteCatalog
		 REBUILD WITH ACCENT_SENSITIVITY=OFF
	   GO
	   
	   
	   --���������� �����
	   
	   ALTER FULLTEXT CATALOG MtrLiteCatalog
		 REBUILD WITH ACCENT_SENSITIVITY=ON
	   GO
	   

	   --������� �������
	   --   DROP FULLTEXT CATALOG MtrLiteCatalog;

	   --�������� ��������������� �������
	   
	   CREATE FULLTEXT INDEX ON NSI_MATERIALS(ShortName)
		 KEY INDEX PK_NSI_MATERIALS ON (MtrLiteCatalog)
		 WITH (CHANGE_TRACKING AUTO)
	   GO
	   

	--������� ��������
	   --�������������� ������ ������
	   SELECT GID, ShortName
	   FROM NSI_MATERIALS
	   WHERE CONTAINS (ShortName, '"�����*����*"');
	   

	   --CONTAINS. ����� ����� �� �����������
	   SELECT GID, ShortName
	   FROM NSI_MATERIALS
	   WHERE CONTAINS (ShortName, 'FORMSOF(INFLECTIONAL, "������� ������")');

	   --CONTAINS. ����� ���� ��� ���� � ������ ������������
	   SELECT GID, ShortName
	   FROM NSI_MATERIALS
	   WHERE CONTAINS (ShortName, '"������" NEAR "�������"');

	   SELECT COUNT(*) FROM NSI_MATERIALS WHERE CONTAINS (ShortName, 'NEAR(������, �������)')

	   --FREETEXT
	   SELECT GID, ShortName
	   FROM NSI_MATERIALS
	   WHERE FREETEXT (ShortName, '������');
	   
	   
	   INSERT INTO NSI_MATERIALS (GID, ShortName)
	   VALUES 
	   ('GID1', N'������� ���������'),
	   ('GID2', N'������ �������'),
	   ('GID3', N'�������� ���a��� (����� � � � ������ ����������)'),
	   ('GID4', N'������� ������'),
	   ('GID5', N'������ �������'),
	   ('GID6', N'������ �������'),
	   ('GID7', N'������� �������'),
	   ('GID8', N'������� ������� ������')
	   --('GID15', N'������� ����������'),
	   --('GID17', N'������� ������')

--SQL 
	--����� �������� ��������� ��������� ����������
			select *
			from demo
			where 
				name like N'%[A-Z][�-�][A-Z]%'
				or name like N'%[�-�][A-Z][�-�]%'
				or name like N'%[�-�][A-Z][ ]%'
				or name like N'%[ ][A-Z][�-�]%'
				or name like N'%[A-Z][�-�][ ]%'
				or name like N'%[ ][�-�][A-Z]%'
				
	--�������� ���� ���������� � ��������������� ��� �����������
		select *
		from
			(select 
				GID, 
				substring(name, 1, CHARINDEX(' ', name)) as firstWord
			from demo 
			) as one
		where 
			firstWord like '%[A-Z][A-Z]%' collate Latin1_General_BIN --����������� (������� ������ ��� ����� ���������)
			or upper(substring(firstWord, LEN(firstWord) - 1, LEN(firstWord))) in (N'��', N'��', N'��', N'��') -- ����� ��������������� (������� ��������� 2 ����� ������� ����� � ���� � ����������� �� ���������. ����� ������� ������� ����������)
			
	--�������� 'test' ��� � ����
		select *
		from demo
		where 
			CHARINDEX('test', name) = 0
		
	
--DDL
	drop table UER;
	
	CREATE TABLE RecordStatus (
		id int IDENTITY(1,1) NOT NULL PRIMARY KEY,
		gid int not null unique,
		statusName nvarchar(20) NOT NULL,
		creationDate datetime NOT NULL,
		creationAuthor nvarchar(20) NOT NULL,
	);
	
	insert into RecordStatus (statusName, creationDate, modificationDate, creationAuthor, modificationAuthor)
	values (N'��������', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'komarovavl', 'komarovavl'),

	create table [dbo].[UER](
		id int IDENTITY(1,1) NOT NULL PRIMARY KEY,
		gid nvarchar(20) NULL,
		code nvarchar(20) NULL,
		uerName nvarchar(300) NULL,
		recordStatus int FOREIGN KEY REFERENCES RecordStatus(id)
	);

	insert into UER (gid, code, uerName)
	values ('1', N'���-06-02-01', N'��������� ������ ����-������ (� �.�. ����������, ���, �������������)');


--TRIGGER
	CREATE TRIGGER RequestStatus_INSERT
	ON RequestStatus
	AFTER INSERT
	AS

	BEGIN
		UPDATE RequestStatus
		set 
			creationDate = CURRENT_TIMESTAMP,
			modificationDate = CURRENT_TIMESTAMP,
			creationAuthor = SYSTEM_USER,
			modificationAuthor = SYSTEM_USER
		where id in (select id from INSERTED)
	END
	
--change tracking
	--turn on cdc
	--1
	SELECT [name], database_id, is_cdc_enabled  
	FROM sys.databases   

	--2
	EXEC sys.sp_cdc_enable_db 

	--3
	SELECT [name], is_tracked_by_cdc  
	FROM sys.tables

	--4
	EXEC sys.sp_cdc_enable_table 
	@source_schema = N'dbo', 
	@source_name   = N'YourTable', 
	@role_name     = NULL 

	--5
	SELECT * FROM cdc.dbo_YourTable_CT where id = 309