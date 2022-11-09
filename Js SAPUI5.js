UI5 Code Examples

//BusyIndicator:
	sap.ui.core.BusyIndicator.show();
	sap.ui.core.BusyIndicator.hide();
	
	
//Ajax:
	GET:
		var url = "/nornick.ru~nsi~uer~wm/uer/resumeRequest";
		sap.ui.core.BusyIndicator.show();
		$.ajax({
				url: url,
				type: 'GET',
				data: query,
				contentType: "application/json; charset=utf-8",
				async: false,
				cache: false,
				success: function(data){
					console.log("success: " + url);					
					sap.ui.core.BusyIndicator.hide();
					
				},
				error: function(e){
					sap.ui.core.BusyIndicator.hide();
					console.log("Error " + url);
					MessageToast.show("Ошибка " + url);
					
				}
			});	
				
				
				
	POST:
		sap.ui.core.BusyIndicator.show();
		$.ajax({
					url: url,
					type: "POST",
					contentType: "application/json; charset=utf-8",
					dataType: "json",
					data: JSON.stringify(dataFilterMap),
					async: true,
					cache: false,
					success: function (response) {
						console.log("success: " + url);
						sap.ui.core.BusyIndicator.hide();


					},
					error: function (e) {
						sap.ui.core.BusyIndicator.hide();
						console.log("Error " + url);
						MessageToast.show("Ошибка при получении данных таблицы");
					}
				});
	
	
	
				
//DateFormat:
	var options = { year: 'numeric', month: 'long' };
	var date = new Date(item.creationDate);
	var dateStr = date.toLocaleDateString("ru-RU", options);


//Create model from JSON:

	1. 
	var model = new JSONModel(sap.ui.require.toUrl("sap/cc") + "/json/workType.json");
    this.getView().setModel(model, "workType");

	2.
	var rows = [];
	var listRows = {};
	
	var row = {		  "id" : item.id,
					  "nameAbsolute": item.nameAbsolute,
					  "procedureName": item.procedureName,
					  "creationDate": that.getFormatDate(item.creationDate,false) ,//+ postfix
					  "absoluteCount": item.absoluteCount,
					  "relativeCount": that.cropNumber(item.relativeCount),
					  "item": item.item,
					  "ButtonId" : ""+item.id,
					  "ButtonVisible" : that.hideSupportInterface ? false : visibleButton
				};

	rows.push(row)
	listRows.rows = rows;

	var oJsonModelListRows = new JSONModel(listRows);
	that.getView().setModel(oJsonModelListRows, listName);
	that.getView().getModel(listName).refresh();
	
	
//Load model event
	oModel.attachRequestCompleted(function() {
		console.log("handler: " + oModel.getData());
	});
	
//Load JSON from file (sap/cc - namespace):
	var muModel = new JSONModel(sap.ui.require.toUrl("sap/cc") + "/json/mu.json");
	
	//namespace
	data-sap-ui-resourceroots='{
				"sap.cc": "/nornick.ru~nsi~uer~prt/app"				
				}'>
				
//suggestion field
	initMuSearchField: function (){
			
		var muModel = new JSONModel(sap.ui.require.toUrl("sap/cc") + "/json/mu.json");

		var mu = this.byId("mu");
		mu.bindAggregation("suggestionItems", {
			path:"/ProductCollection",
			template: new sap.ui.core.Item({
				text: '{Name}'
			})
		});
		
		mu.setModel(muModel);
		
		this.byId("mu").setFilterFunction(function(sTerm, oItem) {
			return oItem.getText().match(new RegExp(sTerm, "i"));
		});
		

	},
				
				
				
//cookie
	 jQuery.sap.storage.get, 
	 jQuery.sap.storage.put, 
	 jQuery.sap.storage.remove, 
	 jQuery.sap.storage.clear, 
	 jQuery.sap.storage.getType and 
	 jQuery.sap.storage.removeAll
	 
	alert( jQuery.sap.storage.get("example") );
	jQuery.sap.storage.put("example", "foo");
	 
 
//paddings
	sapUiNoContentPadding
	
//таблица
//	sap.m.table:
	<Table items="{path:'uer>/basicTechnologicalOperations'}" width="900px" mode="Delete" delete="onDeleteRow" alternateRowColors="true">
		<headerToolbar>
			<OverflowToolbar>
				<content>
					<Button icon="sap-icon://add" type="Accept" press="onAddRow"/>
				</content>
			</OverflowToolbar>
		</headerToolbar>
		<columns>
			<Column hAlign="Center">
				<header>
					<Text text="ГИД" />
				</header>
			</Column>
			<Column hAlign="Center">
				<header>
					<Text text="Код" />
				</header>
			</Column>
			<Column hAlign="Center">
				<header>
					<Text text="Основные технологические операции" />
				</header>
			</Column>
		</columns>
		<ColumnListItem vAlign="Middle" type="Active" press="onRecordSelected">
			<Input value="{uer>gid}" />
			<Input value="{uer>code}" />
			<Input value="{uer>operations}" />
		</ColumnListItem>
	</Table>
	
	//добавить строку в таблицу
	onAddRow: function (oEvent) {
				console.log("onAddRow");
				this.getView().getModel("uer").getProperty('/basicTechnologicalOperations').push({
					"gid": "",
					"code": "",
					"operations": ""
				});
				this.getView().getModel("uer").refresh();

				
			},

	//удалить строку
	onDeleteRow: function(oEvent){
		console.log("onDeleteRow");

		var path = oEvent.getParameter("listItem").getBindingContextPath()
		var index = path.replace("/basicTechnologicalOperations/", "");			
		this.getView().getModel("uer").getProperty('/basicTechnologicalOperations').splice(index, 1);
		this.getView().getModel("uer").refresh();

	}
		
	//как взять выбранный элемент в таблице
		//Responsive Table:
		onItemSelected: function(oEvent) {
			
			//uer это название модели на что забиндена таблица, т.е. таблица обозначена так:
			//<Table items="{path:'uer>/records'}">
			var path = oEvent.getSource().getBindingContext("uer").getPath()
			//path содержит путь в модели до выбранного элемента		
			
			//дальше берем нужный нам элемент из вьюшки по id, 
			//и биндим к нему по указанному элемент из нашей модели
			var oProductDetailPanel = this.getView().byId("productDetailsPanel");
			oProductDetailPanel.bindElement({ path: sPath, model: "products" });
			
			
			//---------------------//
			//Другой способ, взять значение из конкретной ячейки
			var gid = oEvent.getSource().getCells()[0].getText();
		}
		
		//Grid Table:
			var path = oEvent.getParameter("rowBindingContext").sPath;
			var row = this.getView().getModel("modelName").getProperty(path);	
	 
	
	//как взять выбранные галочками элементы
		var table = this.byId("requestsTable");
		var rec = table.getSelectedItems();
	 
	 
	//sap.ui.table:
	<Table id="mtrTable" items="{path:'uer>/mtr'}" delete="onDeleteRowMTR" alternateRowColors="false">
		<columns>
			<Column hAlign="Center" width="80px">
				<header>
					<Text text="ГИД" />
				</header>
			</Column>
			<Column hAlign="Begin">
				<header>
					<Text text="Наименование полное МТР" />
				</header>
			</Column>
			<Column hAlign="Center" width="80px">
				<header>
					<Text text="ЕИ" />
				</header>
			</Column>
			<Column hAlign="Center" width="200px">
				<header>
					<Text text="Норма потерь и отходов материалов" />
				</header>
			</Column>
		</columns>
		<ColumnListItem vAlign="Middle" type="Active" press="onRecordSelected">
			<ObjectIdentifier title="{uer>mtrGid}" />
			<Input value="{uer>mtrFullName}" editable="false" enabled="false" />
			<Input value="{uer>mtrMu}" editable="false" enabled="false" />
			<Input value="{uer>mtrNorm}" editable="false" enabled="false" />
		</ColumnListItem>
	</Table> -->
	
	//взять строку 
	var path = oEvent.getParameter("rowBindingContext").sPath;
	
	//выбранный галочкой
	var index = table.getSelectedIndex();
	table.getSelectedIndices()


//padding
	class="sapUiNoContentPadding"
	sapUiTinyMarginTop
	sapUiTinyMarginBottom
	sapUiTinyMarginBegin
	sapUiTinyMarginEnd
	sapUiSmallMarginTop
	sapUiSmallMarginBottom
	sapUiSmallMarginBegin
	sapUiSmallMarginEnd
	sapUiMediumMarginTop
	sapUiMediumMarginBottom
	sapUiMediumMarginBegin
	sapUiMediumMarginEnd
	sapUiLargeMarginTop
	sapUiLargeMarginBottom
	sapUiLargeMarginBegin
	sapUiLargeMarginEnd

	sapUiTinyMargins
	sapUiSmallMargins
	sapUiMediumMargins
	sapUiLargeMargins

	sapUiTinyMarginBeginEnd
	sapUiTinyMarginTopBottom
	sapUiSmallMarginBeginEnd
	sapUiSmallMarginTopBottom
	sapUiMediumMarginBeginEnd
	sapUiMediumMarginTopBottom
	sapUiLargeMarginBeginEnd
	sapUiLargeMarginTopBottom

	sapUiNoMarginTop
	sapUiNoMarginBottom
	sapUiNoMarginBegin
	sapUiNoMarginEnd

	sapUiSmallPaddingBottom
	sapUiNoContentPadding
	sapUiContentPadding
	sapUiResponsiveContentPadding

//Model

	//инициализация модели при загрузке приложения и вставка данных в объекты на форме
		initModel: function () {
			var model = new JSONModel(sap.ui.require.toUrl("sap/cc") + "/json/createRecord.json");
			this.getView().setModel(model, "uer");
			this.getView().getModel("uer").refresh();

			var rightPanel = this.getView().byId("rightPanel");
			rightPanel.bindElement({ path: "/", model: "uer" });
		}

	//взять часть JSONModel и создать новую на ее основе
		initModel: function (requestId) {
			var model = new JSONModel(sap.ui.require.toUrl("sap/cc") + "/json/requests.json");

			var t = this;
			model.attachRequestCompleted(function () {
				var m = model.getProperty("/requests/" + requestId);
				var m2 = new JSONModel(m);

				t.getView().setModel(m2, "uer");			
				//привязываем модель к нужному элементу на странице
				var mainPage = t.getView().byId("mainPage");
				mainPage.bindElement({ path: "/", model: "uer" });
			});

		},
		
	//как из модели взять определенный элемент
		var table = this.byId("requestsTable");  //для примера, модель забиндена на таблицу
		var rec = table.getSelectedItems();
		var req = rec[0];
		var path = req.getBindingContextPath();
		var requestId = this.getView().getModel("uer").getProperty(path).requestId; //вытащили у нужного элемента свойство requestId


//Form

	//how to add formElement ("recordDetailContainer" - is a FormContainer)
	var formElement = new sap.ui.layout.form.FormElement(
		{
			"label": "Атрибут 1",
			"fields": [
				new sap.m.Input({
					"value": "",
					"type": "Text",
					"placeholder": "Класс МТР"
				})
			]
		}
	);
	var recordDetailContainer = this.getView().byId("recordDetailContainer");
	recordDetailContainer.addFormElement(formElement);
	
	
	
//Создать динамически объекты
	var formElement = new sap.ui.layout.form.FormElement(
		{
			"label": item,
			"fields": [
				new sap.m.Input({
					id: "attr" + index,
					value: "",
					type: "Text",
					placeholder: "Введите значение",
					textFormatMode: "KeyValue",
					showSuggestion: true,
					showTableSuggestionValueHelp: true,
					showValueHelp: true,
					valueHelpRequest: function (oEvent) {
						that.attrValueHelp(oEvent);
					},
					suggestionRows: "{path:'attrs>/values'}",
					suggestionItemSelected: function (oEvent) {
						that.attrSelect(oEvent);
					},
					suggestionColumns: [
						new sap.m.Column({
							"hAlign": "Begin",
							"popinDisplay": "Inline",
							"demandPopin": true,
							"header": new sap.m.Label({
								"text": "Значение"
							})
						})
					],
					suggestionRows: [
						new sap.m.ColumnListItem(
							{
								cells: [
									new sap.m.Label({ text: "{attrs>value}" })]
							}
						)
					],
					suggestionRowValidator: function (oEvent) {
						that.attrSuggestionRowValidator(oEvent);
					}
				})
			]
		}
	);
	
	
//url до приложения
	/name.ru~nsi~uer~prt/index.html
	src="/sapui5/resources/sap-ui-core.js"
	src="/sapui5-1.71/resources/sap-ui-core.js"
	src="https://sapui5.hana.ondemand.com/1.71.40/resources/sap-ui-core.js"
	/nornick.ru~nsi~uer~prt/app/index.html
	
	
//Navigation and Routind SAP Router
	this.getRouter().navTo("recordsSearch", {
				// query: {
				// 	"gid": gid
				// }
				//или так:
				query: params
	}, true /*no history*/);
			
	getRouter: function () {
			return this.getOwnerComponent().getRouter();
	},
	
	// в методе onInit:
	this.getRouter().getRoute("имя target опеределенного в манифесте").attachPatternMatched(this._onRouteSearch, this);
	
	//Пример из манифеста
	"routes": [
				{
					"pattern": "",
					"name": "appHome",
					"target": "home"
				},
				{
					"pattern": ":?query:",
					"name": "recordsSearch",
					"target": "recordsFilter"
				}
			],
			"targets": {
				"home": {
					"viewId": "home",
					"viewPath": "sap.cc.view",
					"viewName": "record",
					"viewLevel": 1
				},
				"notFound": {
					"viewId": "notFound",
					"viewPath": "sap.cc.view",
					"viewName": "NotFound",
					"transition": "show"
				},
				"recordsFilter": {
					"viewId": "home",
					"viewPath": "sap.cc.view",
					"viewName": "record",
					"viewLevel": 2
				}
			}


//serialize map
	var jsonFromMap = JSON.stringify(Object.fromEntries(map));
	
//deserialize map (jsonFromCookie - это json строкой)
	var map = new Map(Object.entries(JSON.parse(jsonFromCookie)));
	
	
//fetch
	var options = {
		method: "POST",
		body: formData,
	};

	sap.ui.core.BusyIndicator.show();
	fetch(url, options).then((response) => {
		sap.ui.core.BusyIndicator.hide();
		if (response.ok) {
			console.log("success post: " + url);
			that.loadDocs();
		} else {
			console.log("При загрузке файла произошла ошибка!");
		}
	});
	
	
	
//create object via JavaScript
new sap.m.CustomListItem({
	content: [
		new sap.m.HBox({
			items: [
				new sap.m.ObjectIdentifier({ title: "{news>title}", text: "", titleActive: false }),
				new sap.m.Label({ text: "test" }),
				
			],
			// width: "100%",
			fitContainer: true,
		}).addStyleClass("sapUiTinyMargin"),
	],
	// type: sap.m.ListType.Active,
	press: function () {
		// alert("Clicked the list item");
	},
}),



//Create dialog via JS:
	var oDialog = new Dialog({
	title: "News",
	contentWidth: "50%",
	contentHeight: "50%",
	resizable: true,
	draggable: true,
	content: new List({
		items: {
			path: "news>/",
			template: new sap.m.CustomListItem({
				content: [
					new sap.m.HBox({
						items: [new sap.m.ObjectIdentifier({ title: "{news>title}", text: "", titleActive: false })],
						// width: "100%",
						fitContainer: true,
					}).addStyleClass("sapUiTinyMargin"),
					new sap.m.HBox({
						items: [new sap.ui.core.HTML({ content: "{news>text}" })],
						// width: "100%",
						fitContainer: true,
					}).addStyleClass("sapUiTinyMargin"),
				],
				// type: sap.m.ListType.Active,
				press: function () {
					// alert("Clicked the list item");
				},
			}),
		},
		infoToolbar: {
			content: new sap.m.OverflowToolbar({
				active: true,
				press: function (){
					alert("Clicked");
				},
				content : new sap.m.Label({
					text: "This is the"
				}),
			}),
		}
	}),
	beginButton: new Button({
		type: ButtonType.Emphasized,
		text: "Ok",
		press: function () {
			oDialog.close();
		},
	}),
	});

	//to get access to the global model
	this.getView().addDependent(this.pressDialog);

	oDialog.setModel(oModel, "news");
	oDialog.open();