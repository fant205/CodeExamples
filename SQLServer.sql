
--�������������� �����
	--���������
		/*-- create fulltext catalog
		CREATE FULLTEXT CATALOG MtrLiteCatalog
		 WITH ACCENT_SENSITIVITY = ON
		 AS DEFAULT
		 AUTHORIZATION dbo
	   GO
	   */

	   --��������� ��������������� ��������
	   /*
	   ALTER FULLTEXT CATALOG MtrLiteCatalog
		 REBUILD WITH ACCENT_SENSITIVITY=OFF
	   GO
	   */
	   
	   --���������� �����
	   /*
	   ALTER FULLTEXT CATALOG MtrLiteCatalog
		 REBUILD WITH ACCENT_SENSITIVITY=ON
	   GO
	   */

	   --������� �������
	   --   DROP FULLTEXT CATALOG MtrLiteCatalog;

	   --�������� ��������������� �������
	   /*
	   CREATE FULLTEXT INDEX ON NSI_MATERIALS(ShortName)
		 KEY INDEX PK_NSI_MATERIALS ON (MtrLiteCatalog)
		 WITH (CHANGE_TRACKING AUTO)
	   GO
	   */

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

		



