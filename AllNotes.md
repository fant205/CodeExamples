# Linux

## Общие

    lscpu - вывод инфо о процессорах
    free -h - вывод инфо о RAM
    lsb_release -dc - Версия ОС
    sudo systemctl disable apache2 - Отключение по умолчанию сервера из списка автостарта
    ls -la \target - просмотр содержимого нужной папки
    curl -X POST localhost:8080/actuator/shutdown - POST вызов
    curl localhost:8080/actuator/health - GET вызов
    pscp -P 22 file_name.txt login@111.22.33.44:/folder
    du -sh ./Загрузки/* - подсчет размера всех папок в папке загрузки
    du -sh * - подсчет всех папок внутри текущей папки
	hostnamectl - узнать параметры ОС
	ssh login@hostname - подключение к linus по ssh
    ssh -i <path/id_rsa> admin@ip - подключение с помощью локального публичного ключа шифрования. Его нужно добавить на сервер (админы это делают)

## File operations:

    mv <source> <targer>
    mv dist1/* dist2 - все файлы из папки 1 переедут в папку 2
    cp -r /home/alexey/Downloads/dump/dump . - скопировать папку 1 в текущую папку
    cp -r /home/alexey/Downloads/dump/dump/* . - скопировать все файлы из папки 1 в текущую папку
    readlink -f _countries.sql или realpath _countries.sql - путь до файла
    du -hs - размер текущей папки
    du -hs * - размер файлов и папок в текущей папке

## Процессы:

    ps -eF - список процессов
    ps -efH - список деревом
    ps -efL - список с потоками
    pgrep <имя программы> - вернет PID
    kill <PID> - закрыть программу

## Zip

    unzip file.zip -d destination_folder
    unzip file.zip
   	zip 1.zip * - зипишем все файлы в текущей папке в архив с именем 1.zip
   	zip -r archivename.zip directory_name - зипуем все внутри папки

## Git token
    ssh-keygen -t ed25519 -C "komarovavl@nornick.ru" - генерируем токен
    eval "$(ssh-agent -s)" - запускаем ssh агент
    ssh-add ~/.ssh/id_ed25519 - добавляем в ssh агент токен
    clip < ~/.ssh/id_ed25519.pub - копируем в буфер токен

# Java

## Запуск jar

    java -cp allClasses.jar Class1
    java -jar app.jar

## Список установленных Java:

    sudo update-alternatives --config java

## Установка oracle Java:
    sudo apt install oracle-java11-installer-local

# Spring:

## Версии Spring - совместимость библиотек

    grep -A 1 hibernate- ~/.m2/repository/org/springframework/spring-orm/4.3.12.RELEASE/spring-orm-4.3.12.RELEASE.pom
    spring_profiles_active=dev - профайл profile dev (application-dev.yaml)
    java -jar -Dspring.profiles.active=dev demo-0.0.1-SNAPSHOT.jar - запуск jar с нужным профайлом

## Specification:

    public static Specification<Uer> equalMu(String value) {
        return (root, query, criteriaBuilder) -> {
            Join<Mu, Uer> mu = root.join("mu");
            return criteriaBuilder.equal(mu.get("symbol"), value);
    };

    public static Specification<Uer> equalMu(String value) {
        return ((root, query, criteriaBuilder) -> {
          Mu o = new Mu();
            o.setSymbol(value);
            return criteriaBuilder.equal(root.get("mu"), o);
       });
    }

# Git:

    .gitignore - Что бы игнорировать файл или папку, необходимо добавить его в файл .gitignore, лучше всего его разместить в корне репозитория.
    - Папка \*\*\<имя папки> будет игнорироваться, где бы она не была.
    - Для игнорирования, файл или папка должы быть исключены из индекса. Если файл раньше коммитился, то надо его убрать из индекса:
    	echo debug.log >> .gitignore
    	git rm --cached debug.log
    	git commit -m "Start ignoring debug.log"

    Официальный мануал https://www.atlassian.com/git/tutorials/saving-changes/gitignore

## Команды

    git push -u origin master - отправить закомиченные изменения на GitHub
    git pull origin master - скачать актуальную версию с GitHub

    git branch - список веток
    git branch newBranch - создать ветку newBranch
    git switch branch1 - переключиться на ветку branch1
    git checkout commitId1 - переключиться на указанный коммит
    git checkout -b newBranch - создать ветку и переключиться на нее
    git branch -d (--delete) - удалить ветку
    git branch -D - удалить обособленную ветку, которая еще не слита с интеграционной
    git branch <branch 1> <commit id1> - создать ветку на основе определенного коммита
    git branch -m (—move) branch2 - переименует текущую ветку в branch2
    git branch -m branch1 branch2 - переименует ветку 1 в 2
    git branch -v - вывод информации о локальных ветках
    git branch -vv - очень подробное описание веток + все ветки слежения
    git branch -a - флаг -all выводит все ветки - локальные + слежения
    git switch b1 - переключение на ветку b1. Если вас нет локальной ветки b1, но такая есть в ветках слежения, то git автоматом создаст локальную ветку b1 и историю коммитов в ней и можно в ней дальше работать

    git status
    git add . - добавить все измененные файлы в индекс
    git commit -m "some message"

    git log - вывод списка всех коммитов
    git log --oneline - краткий список логов репозитория
    git log --abbrev-commit --pretty=online - краткий список логов репозитория (аналог предыдущей)
    git log --abbrev-commit - вывод кратких ид коммитов
    git log --oneline --all - отображение всех веток в одном логе
    git log --oneline --all --graph - отображение лога в виде графа

    git diff - разница между рабочим каталогом и индексом
    git diff --cached - разница между индексом и базой данных объектов
    git diff --word-diff - вывод разницы отдельных слов, а не строк
    git diff <branch 1> <branch 2> - разница между финальными состояниями двух веток
    git diff <commit id1> <commit id2> - разница между двумя коммитами
    git diff <branch 1> - сравнение ветки с рабочим каталогом, при этом рабочий каталог будто на 2 месте в аргументах

    git restore file1 - вернет в рабочий каталог версию из индекса
    git restore —staged file1 - копирует содержимое файла из бд объектов в индекс

    git rm file1 - удалит файл из рабочего каталога и из индекса, останется только сделать коммит. Если просто удалить файл мышкой, то надо будет делать git add и только потом коммит
    git rm -r folder1 - удаление папки рекурсивно (удалит все внутри)
    git rm --cached debug.log - удалить из индекса файл

    git mv file1 file2 - переименует файл в рабочем каталоге и индексе. Принцип работы как у git rm. Эта команда так же может переместить файл

    git commit —amend -m ‘fix2’ - изменит сообщение коммита. Гит копирует из бд объектов все в индекс и создает полную копию предыдущего коммита с теми же тегами и содержимым, но новым сообщением. Старого коммита не будет видно и в последствии гит его удалит.  При выполнении индекс должен быть чист, иначе добавятся новые изменения в коммит.

    git diff HEAD-1 HEAD - покажет разницу между предыдущим коммитом и текущим
        HEAD^1 или HEAD^2 - указать коммит первого или второго родителя (у коммитов слияния 2 родителя)
        HEAD^1~2 - взять у первого родителя второго предка
        
    git reset commit-id-1 - переместит HEAD на указанный коммит
    git reset HEAD~1 - переместит head на -1 коммит 
    git reset —soft commitId2 - переместит изменения из коммита commitId2 в индекс и рабочий каталог
    git reset —mixed commitId1 - вернет изменения из коммита 1 в индекс и рабочий каталог, затем вернет данные из предыдущего коммита в индекс. В итоге изменения будут только в рабочем каталоге
    git reset —hard commitId1 - вернет данные из бд объектов из предыдущего коммита в индекс и рабочий каталог. В итоге все выглядит будто последнего коммита вообще не было

    git revert commitId1 - сформирует антикоммит для commitId1 и дальше предложит ввести сообщение нового антикоммита

    git push -u origin b1 - флаг -u это —set-upstream - указание создать в удаленном репозитории ветку b1
    git fetch - обновляет все ветки слежения, вытаскивает в них всю историю коммитов
    git fetch -p - обновит ветки на актуальные, удаляя ветки слежения, которые были удалены на сервере, останется удалить ветки локально
    git push -d origin b1 - удалить ветку на сервере

    git blame text.txt - покажет изменения в файле в последнем коммите
    git blame commitId1 text.txt - покажет изменения в файле в указанном коммите
    git grep cheese - найдет все файлы в репозитории в которых есть слово cheese с учетом регистра
      флаги grep:
        -i - без учета регистра
        -n - вывод номера строки в файле
        -l - вывод только списка файлов где есть искомая строка

    git log -S msg - найдет коммит когда было добавлено или удалено слово msg
    git log -S msg file1 - ищет в указанном файле
    git log -S msg -p - покажет фактические различия в файлах при добавлении и удалении msg (поддерживается —word-diff)
    git log -G text1 - ищет все коммиты, где слово text1 было в секции diff коммита. Работают флаги -p и —word-diff
    git log —grep text1 - ищет текст в сообщениях коммита

        git bisect - бинарный поиск по коммитам. Общий смысл - нашли ошибку в текущем коммите, но надо узнать когда она появилась. Говорим git  как плохой коммит, потом какой хороший, гит начинает искать средний коммит и переписывает на него рабочий каталог. Нам надо решить есть ли ошибка и сказать гиту хороший или плохой это коммит. Гит соответственно находит средний коммит между текущим и плохим или хорошим в зависимости от того хороший или плохой текущий коммит и так по циклу до нужного коммита. Такая логика - это и есть бинарный поиск.
        git bisect:
            git bisect start - начинаем бинарный поиск
            git bisect bad - говорим что последний HEAD плохой коммит
            git bisect good id1 - говорим какой коммит хороший
            После этих команд гит берет средний коммит между плохим или хорошим и делает git checkout на него переписывая рабочий каталог. Мы смотрим есть ли ошибка и говорим либо git bisect bad/good - git пойдет выбирать след коммит более ранний или поздний зависимо от нашего ответа
            git bisect reset - конец режима поиска. Рабочий каталог будет переписан на последний коммит. Лучше обновить файлы в IDE. 

    git config —list —show-origin - вывод всех настроек конфигурации - глобальные и локальные
    git config user.name ted - задаем свойство локально в репозитории
    git config —global user.name ted - задаем глобально	
        

    git remote add origin <URL SSH> - настройка удаленного соединения
    git remote -v - проверка удаленного соединения, нужно что бы было два - fetch & push
    git clean -f - To remove untracked files (e.g., new files, generated files):
    git clean -fd - Or untracked directories (e.g., new or automatically generated directories):

    git -c http.sslVerify=false clone https_ссылка_из_гитлаба
    git -c http.sslVerify=false pull origin development - push по https
    git -c http.sslVerify=false push origin development - push по https
	
## Сценарии работы:

### Если версию в удаленном репозитории впереди нежели твоя локальная:
    git fetch - вытащит из удаленного репозитория все ветки слежения и будет ясно как ты отстал
    git branch -a - покажет все ветки и локальные и слежения
    git switch <имя удаленной ветки без origin> - переключишься на удаленную ветку и она станет локальной и можно глянуть что в ней, если это вообще нужно
    git merge branch1 - делаем merge в текущую ветку из указанной branch1:
        - Если в новой ветке есть изменения в файлах (или посто добавили файлы), в которых в текущей ветке изменений не было, то git сделает авто слияние и новый коммит.
        - Если в новой ветке есть изменения в файлах, и в текущей ветке есть изменения в этих же файлах, то git сделает новый коммит для внесения изменений файлов 
        и конфликт слияния, и нужно самому изменить файлы в текущей ветке и потом сделать коммит.
    git merge origin/branch1 - делаешь merge с удаленной веткой (если она еще не локальная) и после этого решаем merge и можно push
	

# MongoDB:
    mongo - управляющая программа    
    mongo -u <user> -p <pass> --authenticationDatabase admin
    mongoimport --db restaurants --collection MyCollection --file primer-dataset.json - 		импорт файла в бд (запросы надо делать через db.<collection>.<оператор>)
    show dbs - все бд
    use restaurants - переключение на бд
    show collections - показать коллекции в текущей бд
    db.<имя коллекии>.find() - вызов оператора find

# SSL Certificates

    keytool -list -v -keystore /path/to/cacerts  > java_cacerts.txt - получиться данные сертификатор и можно в результирующем файле поискать сертификат по Serial Number. Сертификаты обычно лежат:
    	./jdk1.6.0_24/jre/lib/security/cacerts
    	./jre1.6.0_24/lib/security/cacerts

    Enter keystore password:  changeit - по умолчанию пароль такой
    В браузере

    keytool -import -alias example -keystore  /path/to/cacerts -file example.der - команда импорта сертификата в Java хранилище

    keytool - Утилита находится ...\jdk_folder\bin

    keytool -delete -alias sms01199.npr.nornick.ru -keystore  C:\Work\Soft\jdk1.8.0_171\jre\lib\security\cacerts - удалить сертификат из keystore

# Chrome:

    сброк кэша: Shift + F5

# Java:

    	//fill collection
        {
            List<Integer> list = new ArrayList<Integer>();
            Collections.addAll(list, 0, -5, -7, -12, 5, 15);
        }

        //remove element from collection.
        {
            List<Integer> list = new ArrayList<Integer>();
            Collections.addAll(list, 0, -5, -7, -12, 5, 15);
            list.removeIf(x -> x < 0);
        }

        //print collection
        {
            List<Integer> list = new ArrayList<Integer>();
            Collections.addAll(list, 0, -5, -7, -12, 5, 15);
            list.forEach(System.out::println);
        }

        //switch
        {
            LocalDate date = LocalDate.now();
            DayOfWeek day = date.getDayOfWeek();
            switch (day) {
                case MONDAY:
                    System.out.println("Понедельник");
                case TUESDAY:
                    System.out.println("Вторник");
                case WEDNESDAY:
                    System.out.println("Среда");
                case THURSDAY:
                    System.out.println("Четверг");
                case FRIDAY:
                    System.out.println("Пятница");
                case SATURDAY:
                    System.out.println("Суббота");
                case SUNDAY:
                    System.out.println("Воскресенье");
            }
        }

        {
            //string format
            System.out.println(String.format("%-10s Hi", "Alex"));//10 это кол-во пустых мест в строке

// Вывод:Alex Hi
System.out.println(String.format("%-10.5s Hi", "ABCDEFGHIK"));
// Вывод:ABCDE Hi
System.out.println(String.format("%3d", 1));
// Вывод:1
System.out.println(String.format("%05d", 1));//заполнить нулями перецифрой
// Вывод:00001
}

#### Date

    Date date = new Date();
    System.out.println(date.toString());

    LocalDateTime:
    	LocalDateTime now = LocalDateTime.now();
    	LocalDateTime date = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 0, now.getSecond() + offsetDays);
    	return new Timestamp(date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

#### Logging

    log.debugT(method, "Xml for Import manager: {0}", new Object[] { importXmlName });

#### Rest Controller

    @RestController
    public class SupportController {

    	public static final Location log = Location.getLocation(SupportController.class);
    	private static final Location loc = Location.getLocation(Location.getLocation("MtrSyncLog.log"));

    	@GetMapping("/changeLang")
    	public ResponseEntity<?> changeLang(@RequestParam(defaultValue = "grigorevatv") String login, @RequestParam(defaultValue = "ru") String lang) {

    		try{

    			return new ResponseEntity<>("Hello!", HttpStatus.OK);

    		} catch (Exception e) {
    			ExceptionHelper.printStackTrace(e, log);
    			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    		}
    	}
    }

#### Format date

    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    result = format.format(((DateTimeValue) value).getDate());

#### Nio

    //rename file
    Path of = Path.of("storage/2.txt");
    Files.move(of, of.getParent().resolve("2.txt"));

#### ModellMapper:

// modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

// modelMapper.getConfiguration().setAmbiguityIgnored(true);
// modelMapper.createTypeMap(Request.class, RequestDto.class).addMapping(Request::getUer, RequestDto::setUerDto);
// modelMapper.createTypeMap(Uer.class, UerDto.class);

// modelMapper.typeMap(Request.class, RequestInfo.class).addMappings(mapper -> {
// mapper.map(src -> src.getCreationDate(), RequestInfo::setRequestDate);
// mapper.map(src -> src.getId(), RequestInfo::setRequestID);
// mapper.map(src -> src.getUserAuthor().getUerLogin(), RequestInfo::setRequestAuthor);
// mapper.map(src -> src.getRequestType().getCode(), RequestInfo::setRequestTypeID);
// });
// modelMapper.typeMap(Uer.class, UER.class).addMappings(mapper -> {
// mapper.using(new RemoteKeysConverter()).map(Uer::getRemoteKeys, UER::setLocalID);
// mapper.using(new BPConverter()).map(Uer::getBp, UER::setBusinessPartner);
// mapper.using(new MtrConverter()).map(Uer::getMtr, UER::setMtrNorm);
// mapper.map(Uer::getMu, UER::setMeasureUnit);
// mapper.map(Uer::getClarificationMu, UER::setClarificationMeasureUnit);
// mapper.map(Uer::getBasicTechnologicalOperations, UER::setBasicTechnologicalOperation);
// mapper.map(Uer::getAdditionalOperation, UER::setAdditionalOperation);
// });
// modelMapper.typeMap(Mu.class, MeasureUnits.class).addMappings(mapper -> {
// mapper.map(Mu::getMuName, MeasureUnits::setName);
// mapper.map(Mu::getModificationDate, MeasureUnits::setUpdateTime);
// });
// modelMapper.typeMap(RecordStatus.class, RecordStatuses.class).addMappings(mapper -> {
// mapper.map(RecordStatus::getModificationDate, RecordStatuses::setUpdateTime);
// });
// modelMapper.typeMap(BasicTechnologicalOperation.class, ru.asupb.uer.BasicTechnologicalOperation.class)
// .addMapping(BasicTechnologicalOperation::getId, ru.asupb.uer.BasicTechnologicalOperation::setGID);
//
// modelMapper.typeMap(AdditionalOperation.class, ru.asupb.uer.AdditionalOperation.class)
// .addMapping(AdditionalOperation::getId, ru.asupb.uer.AdditionalOperation::setGID);

#### JSON Mapper:

    	ObjectMapper objectMapper = new ObjectMapper();
        String carAsString = objectMapper.writeValueAsString(requestByIdResponse.getRequest());

        RequestDto requestDto = new ObjectMapper().readValue(json, RequestDto.class);

=======

#### Lambda

    //Объявляем интерфейс с 1 методом, аннотация @FunctionalInterface делает проверку что в интерейсе только 1 метод (можно создавать другие методы, но тогда они должны быть default)
    @FunctionalInterface
    public interface Operation {
    	int apply(int x, int y);
    }

    public static void main(String[] args){
    	//lambda
    	Operation o1 = (x, y) -> x + y;

    	//Method reference
    		//1.
    		Operation o2 = Integer::sum;
    		//2.
    		Operation o3 = Main::go;

    	//Делаем вызов
    	o1.apply(1,2);
    	o2.apply(1,2);
    	o3.apply(1,2);

    	//Передача в функцию:
    	calc(1, 2, o1);
    	calc(1, 2, o2);
    	calc(1, 2, o3);


    }

    //делаем метод который имеет такие же входные параметры и выходные и можно его использовать как method reference
    public static int go(int t, int z){
    	return t / z;
    }

    //В жизни используется для передачи в функции
    public static int calc(int x, int y, Operation o){
    	return o.apply(x, y);
    }

#### Stream API

    //Базовые интерфейсы
    	//forEach, peek
    	Consumer<String> printer = System.out::println;
    	printer.accept("Hello");

    	//filter, anyMatch, allMatch, noneMatch
    	Predicate<Integer> isOdd = x -> x % 2 != 0;

    	//map, FlatMap
    	Function<String, Integer> length = String::length;
    	System.out.pringln("length.apply("123"));

    	//collect
    	Supplier<Integer> supplier = () -> 1;
    	Supplier<Map<String, Map<Integer, Set<Long>>>> supplier = HashMap::new;



    //Пример использования

    	//вытащить только поле из листа объектов и собрать в лист
    	//1
    		List<String> names =
    		personList.stream()
              .map(Person::getName)
              .collect(Collectors.toList());
    	//2
    		u.getRequestProcessor().stream().map(RequestProcessor::getUser_id).map(UerUser::getFio).collect(Collectors.toList()).toString(),



    	//filter odd and print
    	Stream.of(1,2,3,4,5,6,7,8,9)
    	.filter(x -> x % 2 == 0)
    	.forEach(System.out::println);

    	//increment all values by 1 and collect to list
    	List<Integer> list = Stream.of(1,2,3,4,5)
    		.map(x -> x + 2)
    		.toList();

    	System.out.println(list.toString());

    	//calculate sum
    	Integer result = Stream.of(1,2,3)
    		.reduce(0, Integer::sum);
    	System.out.pringln(result);

    	//words counter
    	Map<String, Integer> words = Files.lines(Path.of("folder", "1.txt")) //вытащили текстовый файл по строчкам в Stream
    		.flatMap(s -> Stream.of(s.split(" +"))) //разбили каждую строчку в Stream и с помощью flatMap собрали все в один Stream
    		.map(String::toLowerCase) //каждый элемент привели в нижний регистр
    		.map(s -> s.replaceAll("\\W\\d", "")) //каждый элемент - убрали не букву и не цифру
    		.filter(StringUtils::isNoneBlank) //убрали пустые элементы
    		//.forEach(System.out.println); //вывод каждого элемента
    		.collect(Collectors.toMap( //собираем результат в map, что бы показать сколько раз какое слово попадается в тексте
    			Function.identity(), // возвращаем саму себя, т.е. слово будет ключом map
    			value -> 1, // говорим что со значением, говорим что когда клю попался первый раз, то кладем 1
    			Integer::sum // говорим что делать со значением, если уже был такой ключ - говорим складывать старое и новое значение
    		));

    	//counter rate
    	words.entrySet().stream()
    		.sorted((e1, e2) -> e2.getValue - e1.getValue) //передаем comparator, что бы показать как сортировать entrySet
    		.forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

    	//классическая задача flat
    	int[][] array = new int[][]{ {1,2}, {1,2,3}, {1,2,3,4}};
    	Arrays.stream(array)
    		.flatMap(Stream::of)
    		.toList();

    	System.out.println();

#### Spring:

    Spring аннотации:
    	@SpringBootApplication - указывается для класса запускающего spring boot приложение. Обычно оно находится на самом верхнем уровне, и по умолчанию spring сканирует все классы на этом же уровне и все дочерние пакеты. Поэтому можно не указывать @ComponentScan. Аннотация в числе прочих наследуется от аннотаций @Configuration,@ComponentScan, @EnableAutoConfiguration.
    	@ComponentScan("package.name") - указывается для класса с @Configuration или @SpringBootApplication какие пакеты нужно сканировать
    	@PostConstruct - вызов для бина после вызова конструктора
    	@RequiredArgsConstructor - makes constructor and fill non-initialized fields with final and fill fields with @NonNull, make check for NullPointerException

    	@Controller - указывает что класс Java является контроллером, т.е. является спринг-бином и значит что будет принимать вызовы веб-методов GET, POST и т.д. Так же если не указывать аннотацию @RequestBody, то автоматом подключается Thymeleaf и ищет страницу для ответа на запрос, если указать @RequestBody то, в ответ будет отправлен объект.
    	@RestController - тоже самое что @Controller, но на каждом метода автоматически будет учтена аннотация @ResponseBody, и ее не надо каждый раз писать.
    	@RequestParam - указываем что это параметр запроса, в нем можно указать назавние параметра отлично от самой переменной java, начальное значение, обязательность.
    	@PathVariable - указываем что в пути-ссылке на данный REST-метод будет переменная и она будет считана в данную переменную.
    	@RequestBody - указываем для Post, Put, Delete, это объект который придет на вход.
    	@ResponseBody - ставится над методом REST, говорит спрингу, что ответ будет объектом и отменяет применение Thymeleaf

    Spring Boot зависимости (Starters):
    	● spring-boot-starter-parent — это специальный стартер, предоставляющий настройки Maven по умолчанию и раздел управления зависимостями, чтобы вы могли опустить теги версии для Spring-зависимостей.
    	● spring-boot-starter-web — используется для создания веб-служб RESTful с использованием Spring MVC и Tomcat в качестве встроенного контейнера приложений;
    	● spring-boot-starter-thymeleaf — подключение шаблонизатора Thymeleaf
    	● spring-boot-starter-data-jpa — подключает модуль Spring Data JPA
    	● spring-boot-starter-security — подключает модуль Spring Security для обеспечения безопасности веб-приложения
    	● spring-boot-starter-jersey — альтернатива Spring-boot-starter-web, в которой используется встроенный сервер приложений Jersey, а не Tomcat;
    	● spring-boot-starter-jdbc — реализует пул соединений JDBC, основан на реализации пула JDBC Tomcat.

    Spring Boot Security:

    	Есть два способа настройки security:
    			1. Через WebSecurityConfigurerAdapter - объявлен устаревшим
    			2. Через SecurityConfig, в котором надо создать бин SecurityFilterChain и сделать сразу его настройку.
    					Пример с SecurityFilterChain (по новому):
    					@Configuration
    					public class SecurityConfig {
    					    @Bean
    					    public SecurityFilterChain mySecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
    					        return httpSecurity.authorizeRequests()
    					                .antMatchers("/app/admin-page").hasRole("ADMIN")
    					                .antMatchers("/app/user-page").hasAnyRole("USER", "ADMIN")
    					                .antMatchers("/app/home").authenticated()
    					                .antMatchers("/app/guest").permitAll()
    					                .and()
    					                .formLogin()
    					                .and()
    					                .build();
    					    }
    					}
    				В данном способе можно инициализиваровать правила для нужны ссылок через аннотации:
    					- ставим над методом в RestController аннотацию @Secured("ROLE_ADMIN")
    					- в файле конфигурации безопасности SecurityConfig аннотацию @EnableGlobalMethodSecurity(securedEnabled = true)

    			Пример по старому (через WebSecurityConfigurerAdapter)
    				Опередяем конфиг:
    					@Configuration
    					@EnableWebSecurity
    					@EnableGlobalMethodSecurity(securedEnabled = true)
    					public class SecurityConfig extends WebSecurityConfigurerAdapter {
    						// ...
    					}

    				Аннотации:
    					@EnableWebSecurity - отключает стандартные настройки безопасности Spring Security и начинает использовать правила, прописанные в SecurityConfig.
    					@EnableGlobalMethodSecurity - активирует возможность ставить защиту на уровне методов (для этого над методами ставятся аннотации @Secured и @PreAuthorized).

    				Пример конфига когда мы сами определяем как будем искать юзера и полномочия, исползуется: DaoAuthenticationProvider и UserService, который будет искать юзера, его пароль, его роли и будет хешировать пароль с помощью BCryptPasswordEncoder:
    					@Configuration
    					@EnableWebSecurity
    					@EnableGlobalMethodSecurity(securedEnabled = true)
    					public class SecurityConfig extends WebSecurityConfigurerAdapter {
    						private UserService userService;

    						@Autowired
    						public void setUserService(UserService userService) {
    							this.userService = userService;
    						}

    						@Bean
    						public BCryptPasswordEncoder passwordEncoder() {
    							return new BCryptPasswordEncoder();
    						}

    						@Bean
    						public DaoAuthenticationProvider authenticationProvider() {
    							DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
    							auth.setUserDetailsService(userService);
    							auth.setPasswordEncoder(passwordEncoder());
    							return auth;
    						}

    						@Override
    						protected void configure(HttpSecurity http) throws Exception {
    							http.authorizeRequests()
    							.antMatchers("/").hasAnyRole("USER")
    							.antMatchers("/admin/**").hasRole("ADMIN")
    							.and()
    							.formLogin()
    							.loginPage("/login")
    							.loginProcessingUrl("/authenticateTheUser")
    							.permitAll();
    						}

    						//пояснение:
    						● Метод configure(HttpSecurity http) отвечает за настройку защиты на уровне запросов и конфигурирование процессов авторизации.
    						● antMatchers — с помощью данного метода указывается http-метод и URL (или шаблон URL), доступ к которому необходимо ограничить.
    						● hasRole(String role), hasAnyRole(String... roles) — в нем указывается одна роль или набор ролей, необходимых пользователю для доступа к данному ресурсу.
    						● formLogin() — дает возможность настроить форму для авторизации.
    						● loginPage — URL формы авторизации.
    						● loginProcessingUrl — URL, на который будут отправляться данные формы (методом POST).
    						● * logout() — позволяет настроить правила выхода из учетной записи.
    						● * failureUrl — адрес для перенаправления пользователя в случае неудачной авторизации.
    						● * logoutSuccessUrl — URL, на который будет перенаправлен пользователь при выходе из аккаунта автора.
    						● * usernameParameter и passwordParameter — имена полей формы, содержащие логин и пароль, если не используются стандартные имена username и password;

    					}

    					Пример реализации UserService:
    						@Service
    						public class UserService implements UserDetailsService {
    							private UserRepository userRepository;
    							private RoleRepository roleRepository;

    							@Autowired
    							public void setUserRepository(UserRepository userRepository) {
    								this.userRepository = userRepository;
    							}

    							@Autowired
    							public void setRoleRepository(RoleRepository roleRepository) {
    								this.roleRepository = roleRepository;
    							}

    							public User findByUsername(String username) {
    								return userRepository.findOneByUsername(username);
    							}

    							@Override
    							public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    								User user = userRepository.findOneByUsername(username);
    								if (user == null) {
    									throw new UsernameNotFoundException("Invalid username or password");
    								}
    								return new org.springframework.security.core.userdetails.User(user.getPhone(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    							}

    							private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
    								return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    							}

    						}


    	Пример конфига для стандартной парs таблиц: users и authorities. Все что нужно, это заинжектить DataSource, создать таблицы в базе, и добавить туда пользователей.
    		@Configuration
    		@EnableWebSecurity
    		@EnableGlobalMethodSecurity(prePostEnabled = true)
    		public class SecurityConfig extends WebSecurityConfigurerAdapter {
    			private DataSource dataSource;

    			@Autowired
    			public void setDataSource(DataSource dataSource) {
    				this.dataSource = dataSource;
    			}

    			@Override
    			protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    				auth.jdbcAuthentication().dataSource(dataSource);
    			}

    			@Override
    			protected void configure(HttpSecurity http) throws Exception {
    				http.authorizeRequests()
    				.antMatchers("/").hasAnyRole("USER")
    				.antMatchers("/admin/**").hasRole("ADMIN")
    				.and()
    				.formLogin()
    				.loginPage("/login")
    				.loginProcessingUrl("/authenticateTheUser")
    				.permitAll();
    			}
    		}
    		Конфиг для dataSource:
    				spring.datasource.driver-class-name=org.postgresql.Driver
    				spring.datasource.url=jdbc:postgresql://localhost:5231/postgres?currentSchema=spring
    				spring.datasource.username=user
    				spring.datasource.password=user

    		Конфиг для inMemory:
    			@Override
    			protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    				User.UserBuilder users = User.withDefaultPasswordEncoder();
    				auth.inMemoryAuthentication()
    				.withUser(users.username("user1").password("pass1").roles("USER",
    				"ADMIN"))
    				.withUser(users.username("user2").password("pass2").roles("USER"));
    			}
    		Скрипты SQL для таблиц по стандартной схеме:
    			CREATE TABLE users (
    				username varchar(50) NOT NULL,
    				password varchar(100) NOT NULL,
    				enabled tinyint(1) NOT NULL,
    				PRIMARY KEY (username)
    			) ENGINE=InnoDB DEFAULT CHARSET=latin1;

    			INSERT INTO users
    			VALUES
    				('user1', 'user1', 1),
    				('user2', 'user2', 1);

    			CREATE TABLE authorities (
    				username varchar(50) NOT NULL,
    				authority varchar(50) NOT NULL,
    				UNIQUE KEY authorities_idx_1 (username, authority),
    				CONSTRAINT authorities_ibfk_1
    				FOREIGN KEY (username)
    				REFERENCES users (username)
    			) ENGINE=InnoDB DEFAULT CHARSET=latin1;

    			INSERT INTO authorities
    			VALUES
    				('user1', 'ROLE_ADMIN'),
    				('user1', 'ROLE_USER'),
    				('user2', 'ROLE_USER');

#### Пример настройки авторизации через БД:

    @EnableGlobalMethodSecurity(securedEnabled = true)
    @Configuration
    @Profile("!ldap")
    @RequiredArgsConstructor
    @Slf4j
    public class SecurityConfigDb {
    	private final JwtRequestFilter jwtRequestFilter;

    	@Bean
    	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    		return authenticationConfiguration.getAuthenticationManager();
    	}

    	@Bean
    	public SecurityFilterChain mySecurityFilterChain(HttpSecurity http) throws Exception {

    		http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
    				.authorizeHttpRequests((requests) -> requests
    						.requestMatchers("/auth").permitAll()
    						.requestMatchers("/records/**").permitAll()
    						.requestMatchers("/h2-console/**").permitAll()
    						.requestMatchers("/swagger-ui/**").permitAll()
    						.requestMatchers("/v3/**").permitAll()
    						.anyRequest().authenticated())
    				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    				.headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable())) //to make accessible h2 console, it works as frame
    				.exceptionHandling(httpSecurityExceptionHandlingConfigurer -> httpSecurityExceptionHandlingConfigurer.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
    				.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    		log.info("Авторизация через бд настроена");

    		return http.build();

    	}

    	@Bean
    	public BCryptPasswordEncoder passwordEncoder() {
    		return new BCryptPasswordEncoder();
    	}


    }

#### Пример авторазации через LDAP:

    @EnableGlobalMethodSecurity(securedEnabled = true)
    @Configuration
    @Profile("ldap")
    @RequiredArgsConstructor
    @Slf4j
    public class SecurityConfigLdap {
    	private final JwtRequestFilter jwtRequestFilter;
    	@Value("${ldap.context-source.userDnPatterns}")
    	private String userDnPatterns;
    	@Value("${ldap.context-source.userSearchBase}")
    	private String userSearchBase;
    	@Value("${ldap.context-source.userSearchFilter}")
    	private String userSearchFilter;
    	@Value("${ldap.context-source.groupSearchBase}")
    	private String groupSearchBase;
    	@Value("${ldap.context-source.groupSearchFilter}")
    	private String groupSearchFilter;
    	@Value("${ldap.context-source.url}")
    	private String url;
    	@Value("${ldap.context-source.userDn}")
    	private String userDn;
    	@Value("${ldap.context-source.password}")
    	private String password;

    	@Bean
    	public SecurityFilterChain mySecurityFilterChain(HttpSecurity http) throws Exception {

    		http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
    				.authorizeHttpRequests((requests) -> requests
    						.requestMatchers("/auth").permitAll()
    						.requestMatchers("/records/**").permitAll()
    						.requestMatchers("/h2-console/**").permitAll()
    						.requestMatchers("/swagger-ui/**").permitAll()
    						.requestMatchers("/v3/**").permitAll()
    						.anyRequest().authenticated())
    				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    				.headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable())) //to make accessible h2 console, it works as frame
    				.exceptionHandling(httpSecurityExceptionHandlingConfigurer -> httpSecurityExceptionHandlingConfigurer.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
    				.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    		log.info("LDAP authorization configured!");
    		return http.build();
    	}

    	@Bean
    	public BCryptPasswordEncoder passwordEncoder() {
    		return new BCryptPasswordEncoder();
    	}

    	@Bean
    	@ConfigurationProperties(prefix = "ldap.context-source")
    	public LdapContextSource getLdapContext() {
    		return new LdapContextSource();
    	}

    	@Bean
    	AuthenticationManager ldapAuthenticationManager(BaseLdapPathContextSource contextSource) {
    		LdapBindAuthenticationManagerFactory factory = new LdapBindAuthenticationManagerFactory(contextSource);
    		factory.setUserDnPatterns(userDnPatterns);
    		factory.setUserSearchBase(userSearchBase);
    		factory.setUserSearchFilter(userSearchFilter);
    		return factory.createAuthenticationManager();
    	}

    	@Bean
    	LdapAuthoritiesPopulator authorities(BaseLdapPathContextSource contextSource) {
    		DefaultLdapAuthoritiesPopulator authorities = new DefaultLdapAuthoritiesPopulator
    				(contextSource, groupSearchBase);
    		authorities.setGroupSearchFilter(groupSearchFilter);
    		return authorities;
    	}

    	@Bean
    	ActiveDirectoryLdapAuthenticationProvider authenticationProvider() {
    		return new ActiveDirectoryLdapAuthenticationProvider("free.dmz", url);
    	}


    }

    yaml:
    	ldap:
    	  context-source:
    		userDnPatterns: CN={0},CN=Users,DC=test,DC=ddd
    		userSearchBase: CN=Users,DC=test,DC=ddd
    		userSearchFilter: (CN={0})
    		groupSearchBase: CN=Some-Base-Group,CN=Users,DC=test,DC=ddd
    		groupSearchFilter: member={0}
    		url: ldap://localhost:389
    		userDn: some-user
    		password: some-pass
    	  #you'll want connection polling set to true so ldapTemplate reuse the connection when searching recursively
    	  #    pooled: true
    	  use: true

#### ldapTemplate:

        List<String> search = ldapTemplate
                .search(
                        userSearchBase,
                        "CN=" + username,
                        (AttributesMapper<String>) attrs -> (String) attrs.get("memberOf").get());
        log.debug("LDAP Search: {}", search.toString());

        List<String> search = ldapTemplate.search(
                userSearchBase,
                "CN=" + username,
                (AttributesMapper<ArrayList<String>>) attrs ->
                {
                    Attribute memberOf = attrs.get("memberOf");
                    if (memberOf == null) {
                        throw new RuntimeException("User " + username + " does not have any role in LDAP");
                    }
                    return (ArrayList<String>) Collections.list(attrs.get("memberOf").getAll());
                }
        ).get(0);
        log.debug("User memberOf: {}", search.toString());

#### Spring transactions:

    	- Когда мы ставим аннотацию Transactional, то Spring делает прокси-классы для нашего класса, где делает старт транзацкии, ее коммит или роллбек при ошибке

#### Spring Exception:

    	Пример класса который объявляется перехватчиком всех исключений от всех контроллеров (класс срабатывает на исключения объявленные как входные параметры методов):
    		@ControllerAdvice
    		@Slf4j
    		public class GlobalExceptionHandler {
    		    @ExceptionHandler
    		    public ResponseEntity<AppError> catchResourceNotFoundException(ResourceNotFoundException e) {
    		        log.error(e.getMessage(), e);
    		        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    		    }

    		    @ExceptionHandler
    		    public ResponseEntity<FieldsValidationError> catchValidationException(ValidationException e) {
    		        log.error(e.getMessage(), e);
    		        return new ResponseEntity<>(new FieldsValidationError(e.getErrorFieldsMessages()), HttpStatus.BAD_REQUEST);
    		    }
    		}

#### Spring AOP (Aspects):

    	- Если в дебаге видно что бин спринга является не самим классом, а прокси классом SJLib, то это значит используются аспекты, и надо смотреть какую логику добавили в них
    	- Аспекты как теневые программы могут менять программу и данные, это приводит к усложнению поддержки программы

#### Настройки Java:

    	<properties>
    		<java.version>11</java.version>
    	</properties>

#### Spring Boot Maven plugin:

    	<build>
    		<plugins>
    			<plugin>
    				<groupId>org.springframework.boot</groupId>
    				<artifactId>spring-boot-maven-plugin</artifactId>
    			</plugin>
    		</plugins>
    	</build>

#### Настройки (application.properties):

    	server.port=8189
    	spring.datasource.url=jdbc:h2:~/spring.h2
    	spring.datasource.driver-class-name=org.h2.Driver

    Настройки application.yaml (тоже самое что и application.properties, только возможна иерархия, что бы не повторять свойства):
    	server:
    		port: 8189
    		servlet:
    		  context-path: /app - для главное сервлета spring - DispatcherServlet задаем ключевую ссылку - /app, т.е. адресс для локального ПК будет http://localhost:8189/app

    Spring Boot отладка:
    	java -jar my-app.jar --debug - трассировка бинов при запуске Spring Boot

    Lombok:
    	@Data - generate setters and getters when compile, if you use it in IDEA, you should use Lombok plugin, to use generated setters and getters
    	@AllArgsConstructor------------
    	@NoArgsConstructor
    	@RequiredArgsConstructor - делает конструктор с полями которые объявлены как final и какие то еще
    	@Slf4j - дает логгер с реализацией Lombok, и можно сразу в коде обращаться к переменной log.debut("logging")

# Maven:

    Команды:
    	mvn clean - чистка в проекте всего что было сгенерировано
    	mvn package - прогон билда, тестов, подтягивание зависимостей, если указал в pom.xml, паковка в jar файл
    	mvn install - все что и package и еще копирование в локальный репозиторий сформированного jar, и можно будет в других проектах локально юзать этот jar как либу через dependencies
    	mvn spring-boot:build-image - сделать образ java приложения
    	mvn -X - вывод полной информации о настройках программы

    Репозитории:
    	Local - локальный - на компе репозиторий, находится по адресу ${userhome}/.m2 (папка .m2 скрытая). Для винды это Documents/Users, для мак или убунту корневая папка юзера
    	Central - Центральный (https://mvnrepository.com), если в локальном не нашли, ищем в центральном, если нашли, то копирование в локальный, если не нашли, то идем в remote
    	Remote - Удаленный, это репозиторий в какой-либо компании, внутри нее, и там есть какие-то свои наработки. Можно в maven настроить как Remote какой то сервер компании, и maven будет работать с ним. Если нашли в remote, то копирование в локальный, если нет, то ошибка что такой библиотеки нет


    Полезные зависимости:
    	//Дает готовые решения для частых простых задач
    	<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
    	<dependency>
    		<groupId>org.apache.commons</groupId>
    		<artifactId>commons-lang3</artifactId>
    		<version>3.12.0</version>
    	</dependency>

    	//как и apache дает много решений для простых вещей (кеш, RateLimiter, если нужно сделать что бы был 5 запросов в секунду и не больше)
    	<!-- https://mvnrepository.com/artifact/com.google.guava/guava -->
    	<dependency>
    		<groupId>com.google.guava</groupId>
    		<artifactId>guava</artifactId>
    		<version>31.0.1-jre</version>
    	</dependency>

    settings.xml:
    	${maven.home}/conf/settings.xml - maven home можно узнать командой mvn -v
    	${user.home}/.m2/settings.xml




    mvn package - сделать jar или war, в зависимости что указано в pom.xml
    mvn tomcat:run - запуск встроенного tomcat
    mvn dependency:tree - вывод дерева зависимостей
    mvn dependency:tree -Dincludes=org.apache.logging.log4j:log4j-core - Параметр includes фильтрует вывод, чтобы показать только зависимость log4-core.
    mvn dependency:analyze -DignoreNonCompile - вывод не используемых зависимостей
    mvn org.owasp:dependency-check-maven:check -DfailBuildOnCVSS=7 - проверка уязвимостей в проекте (https://jeremylong.github.io/DependencyCheck/dependency-check-maven/)
    mvn clean package tomcat:run --пакетный запуск команд
    mvn verify - все циклы и проверка уязвимостей
    ./mvnw spring-boot:run - запуск spring boot приложения


    mvn --version - вывод версии Maven:
    	make current maven 3.8.4:
    	xport M2_HOME=/usr/local/apache-maven/apache-maven-3.8.4
    	export M2=$M2_HOME/bin
    	export MAVEN_OPTS="-Xms256m -Xmx512m"
    	export PATH=$M2:$PATH
    	source ~/.profile




    Управелние зависимостями:
    	Пример как указать конкретный jar библиотеки на своем ПК:
    		Вариант 1:
    		<dependency>
    			<groupId>com.microsoft.sqlserver</groupId>
    			<artifactId>sqljdbc</artifactId>
    			<version>6.0</version>
    			<scope>system</scope>
    			<systemPath>${basedir}/lib/com.microsoft.sqlserver/sqljdbc/6.0/sqljdbc42.jar</systemPath>
    			<optional>true</optional>
    		</dependency>

    		Вариант 2:
    			Добавляем в свой локальный репозиторий Maven свой jar:
    				mvn install:install-file -Dfile=/C/Work/JARs/tc~je~usermanagement~api.jar -DgroupId=sap.com -DartifactId=ume.api -Dversion=1.0 -Dpackaging=jar -DgeneratePom=true
    			Добавляем в pom.xml зависимость как обычно:
    				<dependency>
    					<groupId>sap.com</groupId>
    					<artifactId>ume.api</artifactId>
    					<version>1.0</version>
    				</dependency>

# Hibernate:

    # Relationships in JPA - Hibernate

## 1. OneToMany

### SQL:

    CREATE TABLE categories (
        id serial,
        title varchar(255),
    	PRIMARY KEY (id)
    );

    CREATE TABLE products (
    	id serial,
    	title varchar(255),
    	category_id integer REFERENCES categories (id)
    );

### Java:

    @Entity
    @Table(name = "products")
    public class Product {
    	@Id
    	@GeneratedValue
    	@Column(name = "id")
    	private Long id;
    	@Column(name = "title")
    	private String title;
    	@ManyToOne
    	@JoinColumn(name = "category_id")
    	private Category category;
    	// ...
    }

    @Entity
    @Table(name = "categories")
    public class Category {
    	@Id
    	@Column(name = "id")
    	@GeneratedValue
    	Long id;
    	@Column(name = "title")
    	String title;
    	@OneToMany(mappedBy = "category")
    	List<Product> products;
    	// ...
    }

## 2. OneToOne

### SQL:

    CREATE TABLE employees_details (
    	id serial,
    	address varchar(255),
    	PRIMARY KEY (id)
    );

    CREATE TABLE employees (
    	id serial,
    	first_name varchar(50),
    	last_name varchar(50),
    	details_id integer REFERENCES employees_details (id)
    );

### Java:

    @Entity
    @Table(name = "employees")
    public class Employee {
    	@Id
    	@GeneratedValue
    	@Column(name = "id")
    	private Long id;
    	@Column(name = "first_name")
    	private String firstname;
    	@Column(name = "last_name")
    	private String lastname;
    	@OneToOne
    	@JoinColumn(name = "details_id")
    	private EmployeeDetails details;
    	// ...
    }

    @Entity
    @Table(name = "employees_details")
    public class EmployeeDetails {
    	@Id
    	@GeneratedValue
    	@Column(name = "id")
    	Long id;
    	@OneToOne(mappedBy = "details")
    	Employee employee;
    	// ...
    }

## 3. ManyToMany

### SQL:

    DROP TABLE IF EXISTS categories CASCADE;
    DROP TABLE IF EXISTS products CASCADE;

    CREATE TABLE categories (
    	id serial,
    	title varchar(255),
    	PRIMARY KEY (id)
    );

    CREATE TABLE products (
    	id serial,
    	title varchar(255),
    	PRIMARY KEY (id)
    );

    CREATE TABLE products_categories (
    	product_id integer REFERENCES products (id),
    	category_id integer REFERENCES categories (id)
    );

### Java:

    @Entity
    @Table(name = "products")
    public class Product {
    	@Id
    	@GeneratedValue(strategy = GenerationType.IDENTITY)
    	@Column(name = "id")
    	private int id;
    	@Column(name = "title")
    	private String title;
    	@ManyToMany
    	@JoinTable(
    	name = "products_categories",
    	joinColumns = @JoinColumn(name = "products_id"),
    	inverseJoinColumns = @JoinColumn(name = "category_id")
    	)
    	private List<Category> categories;
    	// ...
    }

    @Entity
    @Table(name = "categories")
    public class Category {
    	@Id
    	@GeneratedValue(strategy = GenerationType.IDENTITY)
    	@Column(name = "id")
    	private int id;
    	@Column(name = "title")
    	private String title;
    	@ManyToMany
    	@JoinTable(
    	name = "products_categories",
    	joinColumns = @JoinColumn(name = "category_id"),
    	inverseJoinColumns = @JoinColumn(name = "products_id")
    	)
    	private List<Product> products;
    	// ...
    }

## Cascade Types

    ● CascadeType.ALL — каскадирование будет применяться ко всем операциям;
    ● CascadeType.REMOVE — только к методу удаления;
    ● CascadeType.PERSIST — только к методу сохранения;
    ● CascadeType.MERGE — к методу обновления;
    ● CascadeType.REFRESH — к методу синхронизации с БД;
    ● CascadeType.DETACH — каскадирование применяется к методу удаления сущности из
    контекста постоянства (но не из БД).

## Annotations JPA

    @Entity - показывает что класс является сущностью

    Описание таблицы:
        @Table(name = "demo_annotated", indexes = {
            @Index(name = "name_idx", columnList = "name"),
            @Index(name = "id_name_idx", columnList = "id, name"),
            @Index(name = "unique_name_idx", columnList = "name", unique = true)
        })

    orphanRemoval = true - удаление сироты, удаление элемента из бд, если он был убран из листа в дочернем элементе:
    	@OneToMany(mappedBy = "uer", cascade = CascadeType.ALL, orphanRemoval = true)
    	private List<BasicTechnologicalOperation> basicTechnologicalOperations;

    @OneToOne, @OneToMany, @ManyToOne, @ManyToMany - Виды связей
    @Column - описание колонки:
        @Column(name = "manual_def_str", columnDefinition = "VARCHAR(50) NOT NULL
        UNIQUE CHECK (NOT substring(lower(manual_def_str), 0, 5) = 'admin')")
        String manualDefinedString;
        @Column(name = "short_str", nullable = false, length = 10) // varchar(10)
        String shortString;
        @Column(name = "created_at", updatable = false)
        LocalDateTime createdAt;
    @CreationTimestamp и @UpdateTimestamp - Для автогенерации времени создания объекта
    в базе данных и времени его обновления используются аннотации;

    @ManyToOne (описание таблицы меппинга для многие ко многим)
    @JoinColumn(
        name = "product_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "FK_PRODUCT_ID")
    )
    Product product;

    @Id (Любая сущность должна иметь поле id с аннотацией @Id)
    @GeneratedValue(strategy = GenerationType.IDENTITY) (Указываем что значение будет генерироваться автоматически)
    @Column(name = "id")
    Long id;

    @Version поле используется для версионирования

# SQL

## PostgreSQL

###SQL глубинные смыслы:
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


###psql:
	\l - список баз данных
	\c - connection	
	\q - quit
	\? - help
	\dt - tables list
	\d tableName - table description
	\h - help
	\ create table - command description


###Types:
	id serial primary key,
	field boolean not null default false,
	clarification_mu varchar(300),
	creation_date timestamp,
	record_status int,
	is_actual smallint null,
	constraint fk_mu foreign key (mu) references mu(id),
		
###Indexes:
	create unique index unique_gid_is_actual on uer (gid, is_actual) where (gid is not null and is_actual = 1);

###SQL:

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




	Admin commands:
		sudo service postgresql status
		sudo service postgresql stop
		sudo service postgresql start

	Сonnect к PosrtgreSQL через программу терминал psql:
		sudo -u postgres psql - здесь -u это указание юзера, логин posrgres, и сама программа psql

	Получить структуру БД в SQL:
		sudo -u postgres pg_dump --schema-only --no-owner GeekBrainsDBLessons > create_the_tables.sql
		  --комменты
			пишем сначала sudo -u postgres - этим говорим, что запуск программы pg_dump будет из под УЗ postgres

	psql:
		\d - список таблиц
		\d <table name> - структура таблицы
		\h - список всех команд SQL
		\h CREATE TABLE - выводит описание команды CREATE TABLE
		\l - db list
		\c - к какой бд сейчас подключены
		\? - справка
		chcp 1251 - установка русской раскладки

	Загрузка файла sql:
		sudo cp <path to file.sql> </usr/lib/postgresql/9.3/bin/postgres> - копируем файл в папку Postgres что бы были полномочия на чтение
		realpath file.sql - узнаем реальный путь до файла
		psql -h localhost -U postgres -d employees -f <path_to_file.sql> - импорт файла

	Создание пользователя для geodata:
		CREATE ROLE user_group;
		CREATE ROLE user_db WITH LOGIN ENCRYPTED PASSWORD 'passdb';
		GRANT user_group TO user_db;
		GRANT CONNECT ON DATABASE geodata TO user_group;
		grant all privileges on database geodata to user_db;


    Пример даты '2022-10-06 10:23:37.043'

    

# Пример задач по Java:

    Полноценное клиент-серверное приложение + второе приложение, которое общается с первым через брокер сообщений. 
    Я использовала Spring MVC, Spring Security, Spring Data, для маппинга классов в бд и обратно Hibernate, 
    базу данных MySQL, брокер сообщений RabbitMq, WebSocket, контейнер сервлетов Tomcat, Log4j для логирования, 
    Java Mail для отправки сообщений на email из приложения. Для UI части использовала шаблонизатор страничек Thymeleaf.
    Для тестирования JUnit и Mockito. Получилось довольно сложное и интересное приложение - онлайн магазин с раздельным 
    функционалом для клиентов и админа. С корзиной товаров, оформлением заказа, фильтрацией каталога товаров и прочим. 
    Для админа - возможность добавления товаров, работа с заказами, изменения статусов оплаты, доставки и прочее, 
    а также различные метрики, например - валовая выручка магаза за выбранный период времени. Вторым приложением 
    был рекламный стенд с категориями-бестселлерами магазина, стенд обновлялся в режиме реального времени через брокер 
    сообщений и вебсокеты, когда происходили покупки на основном сайте магазина.

# Regexp - Регулярные выражения:

    @.* - строка начинается с @ и любые символы повторяются любой количество раз
    (handle.*)(Search) - начинается на handle далее любое количество символов и заканчивается Search, пример: _handleValueHelpSearch
    .+([0-9] ) - удаление всех цифр в начале строки с до пробела вместе с ним
    ".*?" - ищет от первой кавычки до следующей первой
    ^(.{6}) - первые 6 символов строки, если заменять на $1, - то в конце строки поставит запятую

# SAP:
sap.application.global.properties - example:

## The first name of the employee.
#% type = STRING
employee.firstName = firstName

## The family name of the employee.
#% type = STRING
employee.familyName = familyName

## The password of the employee.
#! This property will be stored encrypted and can be changed online #! via SAP NetWeaver Administrator.
#? secure = true; onlinemodifiable = true
#% type = STRING;
employee.password = initialPassword

## The unique ID of the cluster element.
#! The identification number of the cluster element. The ID is 
#! unique for the cluster. Do not modify this property. Assigned at
#! installation time.
#? parameterized = true; computed = true; 
#% type = LONG; range = [1-2147483647]
element.clusterId = ${INSTANCE_ID}50 + ${NODE_INDEX}

    Java:
    	Шаблоны кода:

    	//MultiTupleValue by values
    		MdmValue[] values = mtv.getValues();
    		for (int i = 0; i < values.length; i++) {
    			TupleValue t = (TupleValue) values[i];
    			...
    		}



    	//SAP Logging:
    		//log debug
    		if(log.beDebug()) {
    			log.debugT(method, "");
    		}

    		//log method
    		String method = "loadAnalogs";
    		boolean result = false;
    		try {

    			if (log.bePath()) {
    				log.entering(method);
    			}

    			return result;

    		} finally {
    			if(log.bePath()){
    				log.exiting(method);
    			}
    		}


    	//sap log
    		private static final Location sl = Location.getLocation(Location.getLocation("XXX.log"));

    		public void sapLog(String msg, Object... args) {
    			SimpleLogger.log(Severity.INFO, Category.APPLICATIONS, sl, "XXX", String.format(msg, args));
    		}


    		//full
    			public void logDebug(String method, String msg) {
    				if (log.beDebug()) {
    					log.debugT(method, msg);
    				}
    				SimpleLogger.log(Severity.INFO, Category.APPLICATIONS, loc, "MtrSync", msg);
    			}


    	// regexp
    			{
    				String s = "S";
    				String p = "[A-Z]";
    				System.out.println(s.matches(p));
    			}

    			{
    				String s = "SSS";
    				String p = "[A-Z]+";
    				System.out.println(s.matches(p));
    			}

    			{
    				String s = "ВАПЕ";
    				String p = "[А-Я]+";
    				System.out.println(s.matches(p));
    			}

    			{
    				String s = "фыва";
    				String p = "[^А-Я]+";
    				System.out.println(s.matches(p));
    			}

    	//deploy without NWDS
    	1. Login with sidadm on SAP NetWeaver WebAs server
    	2. Go to following directory /usr/sap/SID/InstanceNo/j2ee/deployment/scripts
    	3. Find deploy.csh \ deploy.bat
    	4. Execute following command to deploy - it will show you how to execute command.
    	5. Example of deploy command: deploy username:password@host:port file_location



    	//jpa sql
    		SELECT COUNT(t) FROM MaterialEntity t WHERE t.id IN (SELECT u.material.id FROM AreasEntity u WHERE(u.name = :name1));


    	//	Добавление Software Component в NWDI
    	Создаем в SLD, назначаем dependencies для контекста BuildTime (если какие то компоненты не видны при добавлении, то возможно они появятся уже добавленными в компонент), открываем CMS вкладка Landscape Configurator.
    	Там Domain Data
    	нажимаем кнопку Change - кнопка Update CMS.
    	Ждем.
    	Далее заходим в Track Data,
    	нажимаем  Change – нажимаем Sinchronize SC Dependencies – в появившемся окне видим компоненты, необходимо посмотреть подтянулись ли все DC и нажимаем кнопку, в названии которой есть SLD(она вторая слева). Для добавления нового SC нужно нажать кнопку Add SC и в ней выбрать свой SC и нажать кнопку «Save» другие не нажимать (всякие save and reimport).


    	//deploy JPA provider:
    		- Put all jars to directory
    		- Connect to NetWeaver using telnet <netweaver-host> 50008
    		- execute command: add orpersistence
    		- execute command: deploy_provider <your dir> -vendor org.hibernate -name hibernate4221 (<your dir > - should be inside istallution folder of sap ep)

    	// generate ear acrhetype java project
    		mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-j2ee-simple -DarchetypeVersion=1.4




    	//SAP JPA
    		@TransactionAttribute(value=TransactionAttributeType.REQUIRES_NEW) - для класса или для метода, дает открытие новой транзакции при каждом вызове метода класса. Можно ставить на класс или на метод.
    		@TransactionManagement(TransactionManagementType.BEAN)









    		package com.sap.example;
    		import javax.annotation.Resource;
    		import javax.ejb.Stateless;
    		import javax.ejb.TransactionManagement;
    		import javax.ejb.TransactionManagementType;
    		import javax.persistence.EntityManager;
    		import javax.persistence.PersistenceContext;
    		import javax.transaction.UserTransaction;

    		@Stateless
    		@TransactionManagement(TransactionManagementType.BEAN)
    		public class StatelessBean implements StatelessLocal {

    		   @Resource
    		   UserTransaction ut;

    		   @PersistenceContext
    		   EntityManager em;

    		   public void businessMethod() {

    			  ut.begin(); // Start a new transaction

    			  try {

    				 // Do work

    				 em.persist(myEntity);

    				 ut.commit(); // Commit the transaction

    			  } catch (Exception e) {

    				 ut.rollback(); // Rollback the transaction

    			  }

    		   }

    		}













    		@PersistenceContext
    		public EntityManager em;


    		@PersistenceUnit
    		EntityManagerFactory emf;
    		EntityManager em = emf.createEntityManager();

    		//Example 1
    		package com.sap.example;
    		import javax.annotation.Resource;
    		import javax.ejb.Stateless;
    		import javax.ejb.TransactionManagement;
    		import javax.ejb.TransactionManagementType;
    		import javax.persistence.EntityManager;
    		import javax.persistence.PersistenceContext;
    		import javax.transaction.UserTransaction;

    		@Stateless
    		@TransactionManagement(TransactionManagementType.BEAN)
    		public class StatelessBean implements StatelessLocal {

    			@Resource
    			UserTransaction ut;

    			@PersistenceContext
    			EntityManager em;

    			public void businessMethod() {
    				ut.begin(); // Start a new transaction
    				try {
    					// Do work
    					em.persist(myEntity);
    					ut.commit(); // Commit the transaction
    				} catch (Exception e) {
    					ut.rollback(); // Rollback the transaction
    				}
    			}
    		}



    		//Example 2
    		package com.sap.example;
    		import javax.ejb.Stateless;
    		import javax.ejb.TransactionAttribute;
    		import javax.ejb.TransactionAttributeType;
    		import javax.ejb.TransactionManagement;
    		import javax.ejb.TransactionManagementType;
    		import javax.persistence.EntityManager;
    		import javax.persistence.PersistenceContext;

    		@Stateless
    		@TransactionManagement(TransactionManagementType.CONTAINER)
    		public class StatelessBean implements StatelessLocal {

    			@PersistenceContext EntityManager em;

    			@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)

    			public void businessMethod() {

    			// Work in transaction

    			}
    		}

# JavaScript

## JavaScript Type
    number
    string
    boolean
    null
    undefined
    object
    

### Work with json

    pesonalizationMap = new Map(
        Object.entries(JSON.parse(personalization.json))
    );

    json: JSON.stringify(Object.fromEntries(pesonalizationMap)),
    
    
# TypeScript
    npm i -g typescript - установка TypeScript
    tsc -v - вывод версии
    set-executionpolicy remotesigned - разрешить выполнение сценариев
    set-executionpolicy restricted - запретить выполнение сценариев
    tsc --init - инициализация проекта
   
## Типы TypeScript:    
    let age: number = 10;
    
    let price: number = 111_222_333;
    let course: string = "Course";
    let flag: boolean = false;    
    
    let price = 111_222_333;
    let course = "Course";
    let flag = false;       
    
    все из JS плюс:
        any
        unknown
        never
        enum
        tuple
    
    let level - будет считать это типом any
    let array: number[] = [1,2,3];
    
### Tuple
    let user: [number, string] = [1, 'Ivan'];
    
### Enum       
    const enum Size {Small = 1, Medium, Large }; //const даст более оптимальный код
    let mySize: Size = Size.Medium;
    console.log(mySize);
    
### Functions
    "noImplicitReturns": true - запрещает не явный возврат результата в функциях
    "noUnusedLocals": true - запрещает наличие не используемых переменных внутри функции
    "noUnusedParameters": true - запрещает наличие входных переменных, которые не используются в функции
    
    //TypeScript автоматически поймет что функция возвращает number
    function test(a: number){
        return a;
    }
    //Явно указываем что возвращает number
    function test(a: number): number{
        return a;
    }
    //функция с параметром опционально - taxYear?
    function calculateTax(income: number, taxYear?: number): number {
        if((taxYear || 2022) < 2022){
            return income * 1.2;
        }
        return income * 1.3;
    }
    //функция со значением по умолчанию для параметра
    function calculateTax(income: number, taxYear = 2022): number {
        if((taxYear || 2022) < 2022){
            return income * 1.2;
        }
        return income * 1.3;
    }
    
### Objects
#### Example 1
    let employee = { id: 1 };
    
#### Example 2 опциональный параметр name?
    let employee: {
      id: number;
      name?: string; 
    } = { id: 1 };
    employee.name = "Test employee";

#### Example 3 Readonly field id
    let employee: {
      readonly id: number;
      name?: string;
    } = { id: 1 };
    
#### Example 4 Type aliases
    type Employee = {
      readonly id: number;
      name: string;
      retire: (data: Date) => void;
    };

    let employee: Employee = {
      id: 1,
      name: "John Smith",
      retire: (data: Date) => {
        console.log(data);
      },
    };
    
### Union Types
    function kgToLbs(weight: number | string): number {
      if (typeof weight === "number") {
        // weight - видится как number
        return weight * 2.2;
      } else {
        // weight - видится как string
        return parseInt(weight) * 2.2;
      }
    }

### Intersaction Types
    type Draggable = {
      drag: () => void;
    };

    type Resizable = {
      resize: () => void;
    };

    //Объект представляет из себя сумму двух объектов и можно обращаться к любому свойству одного из двух объектов
    type UIWidget = Draggable & Resizable;

    let textBox: UIWidget = {
      drag: () => {},
      resize: () => {},
    };

### Literal Type
    type Quantity = 50 | 100;
    let quantity: Quantity = 100;
    type Metric = "cm" | "inch";


### Nullable Types
    function greet(name: string | null | undefined) {
      if (name) {
        console.log(name.toUpperCase());
      } else {
        console.log("Hola!");
      }
    }
    
    //Если в определении функции не указать union тип null или undefined, то TS запретит вызов такой функции, так как входной параметр должен быть string. Это можно отключить "strictNullChecks": false,
    greet(null);
    greet(undefined);
    greet("test");


### Optional Chaining
    type Customer = {
      birthday: Date;
    };

    function getCustomer(id: number): Customer | null | undefined {
      return id === 0 ? null : { birthday: new Date() };
    }

    let customer = getCustomer(1);
    //Optional property access operator - мы указали ? что бы подчеркнуть что параметр может быть null или undefined
    console.log(customer?.birthday);

## Шаблонные строки    
    var param = "Hello world!";
    console.log(`This is=${param}`);

    
## tsconfig.json
        "target": "es2016" - свойство содержит версию JS
        "rootDir": "./src" - место для sources
        "outDir": "./dist"
        "removeComments": true
        "noEmitOnError": true
        "sourceMap": true

# SAP:

## JavaScript - js

### SAPUI5 Code Examples:


#### Create simple project

Links:
 - https://github.com/SAP/openui5-sample-app
 - https://sap.github.io/ui5-tooling/stable/pages/GettingStarted/


npm install --global @ui5/cli
npm install --save-dev @ui5/cli


git clone https://github.com/SAP/openui5-sample-app.git - копируем заготовку себе
cd openui5-sample-app - заходим
npm install - загружаем все пакет из зависимостей
ui5 use sapui5@latest - переключить на использование sapui5 
ui5 use openui5@latest - переключить на использование openui5
ui5 serve -o index.html - запускаем сервер
ui5 add sap.ui.core sap.m sap.ui.table themelib_sap_fiori_3 - добавить библиотеку




#### FormattedText

    		var oLabelA = new sap.m.FormattedText({
    				  htmlText:
    					"<h3>Здесь может быть что угодно</h3>" +
    					'<p>ссылка: <a href="/irj/index.html" style="color:green;">Ссылка</a> - любая ссылка.</p>' +
    					"<p>Текст: <strong>жирный</strong> and <em>курсив</em>.</p>" +
    					"<p>Пакетный поиск по нескольким ГИД, введенным через запятую или пробел. Здесь может быть любой текст, таблицы, картинки, буллеты, абзацы, ссылки</p>" +
    					"<p>Список:</p>" +
    					"<ul><li>list item 1</li><li>list item 2<ul><li>sub item 1</li><li>sub item 2</li></ul></li></ul>" +
    					"<p>pre:</p><pre>abc    def    ghi</pre>" +
    					'<p>code: <code>var el = document.getElementById("myId");</code></p>' +
    					"<p>cite: <cite>a reference to a source</cite></p>" +
    					"<dl><dt>definition:</dt><dd>definition list of terms and descriptions</dd>",
    				});
    				oLabelA.addStyleClass("sapUiMediumMargin");

#### create list dinammically

      // var list = new sap.m.List({});

        // for (let index = 0; index < 4; index++) {
        //   var item = new sap.m.DisplayListItem({
        //     label: "Label 1",
        //     value: "value 1",
        //     type: "Active",
        //     press: function (e) {
        //       console.log("asdf");
        //       var value = sap.ui
        //         .getCore()
        //         .byId(e.getParameter("id"))
        //         .getValue();
        //       sap.m.URLHelper.triggerEmail(value, "Info Request");
        //     },
        //   });
        //   list.addItem(item);
        // }

#### create column different types

oTable.bindColumns("/columns", function (sId, oContext) {
var o = oContext.getObject();

          var result = null;
          if (o.hasColor) {
    		// HTML Object
            // result = new sap.ui.table.Column({
            //   label: o.colName,
            //   template: new sap.ui.core.HTML({
            //     content:
            //       "<div style='background-color:{" +
            //       o.colorInModel +
            //       "}'>{" +
            //       o.colInModel +
            //       "}</div>",
            //   }),
            //   hAlign: o.hAlign,
            //   width: o.width,
            // });

    		// Object Status Object`
            result = new sap.ui.table.Column({
              label: o.colName,
              template: new sap.m.ObjectStatus({
                text: "{" + o.colInModel + "}",
                inverted: true,
                active: true,
                state: "{" + o.indication + "}",
              }),

              hAlign: o.hAlign,
              width: o.width,
            });
          } else {
            result = new sap.ui.table.Column({
              label: o.colName,
              template: new sap.m.Text({
                text: "{" + o.colInModel + "}",
                textAlign: "Begin",
              }),
              hAlign: o.hAlign,
              width: o.width,
            });
          }
          return result;
        });

        oTable.bindRows("/rows");

#### create table dynamically

    var columnData = [
     { "colId": "Amt", "colName": "Amount", "colVisibility": true, "colPosition": 0  },
     { "colId": "Qty", "colName": "Quantity", "colVisibility": true, "colPosition": 1 },
     { "colId": "Unt", "colName": "Unit", "colVisibility": true, "colPosition": 2 },
     { "colId": "OPA", "colName": "OpenPOAmount", "colVisibility": true, "colPosition": 3 },
     { "colId": "OPQ", "colName": "OpenPOQuantity", "colVisibility": true, "colPosition": 4 }
    ];

    var rowData = [{
        "Amount": "200",
        "Quantity": "RF",
        "Unit": "CV",
        "OpenPOAmount": "5988",
        "OpenPOQuantity": "YY",
        "EXT_FLDS": {
          "PRINTING_NUM": {
            "fieldvalue": 10,
            "fieldlabel": "Printing Number",
            "uictrl": "sap.m.Input"
          },
          "COUNTRY": {
            "fieldvalue": "Thailand",
            "fieldlabel": "Country",
            "uictrl": "sap.m.ComboBox"
          }
        }
      },
      {
        "Amount": "80",
        "Quantity": "UG",
        "Unit": "RT",
        "OpenPOAmount": "878",
        "OpenPOQuantity": "RF",
        "EXT_FLDS": {
          "PRINTING_NUM": {
            "fieldvalue": 11,
            "fieldlabel": "Printing Number",
            "uictrl": "sap.m.Input"
          },
          "COUNTRY": {
            "fieldvalue": "Thailand",
            "fieldlabel": "Country",
            "uictrl": "sap.m.ComboBox"
          }
        }
      },
      {
        "Amount": "789",
        "Quantity": "GV",
        "Unit": "ED",
        "OpenPOAmount": "8989",
        "OpenPOQuantity": "FGG",
        "EXT_FLDS": {
          "PRINTING_NUM": {
            "fieldvalue": 12,
            "fieldlabel": "Printing Number",
            "uictrl": "sap.m.Input"
          },
          "COUNTRY": {
            "fieldvalue": "Thailand",
            "fieldlabel": "Country",
            "uictrl": "sap.m.ComboBox"
          }
        }
      }
    ];
	
    var oModel = new sap.ui.model.json.JSONModel();
    oModel.setData({
      rows: rowData,
      columns: columnData
    });
  
	  
	var oTable = this.byId("reOrderTable");
	oTable.setModel(oModel);
	oTable.bindColumns("/columns", function(sId, oContext) {
	var columnName = oContext.getObject().colName;
	return new sap.ui.table.Column({
	label: columnName,
	template: columnName,
	});
	});
	oTable.bindRows("/rows");
	

#### action send email:

    		sap.m.URLHelper.triggerEmail(this._getVal(evt), "Info Request");

#### action open site:

    		sap.m.URLHelper.redirect(this._getVal(evt), true);

#### BusyIndicator:

    			sap.ui.core.BusyIndicator.show();
    			sap.ui.core.BusyIndicator.hide();


### Ajax:
#### Fetch POST:
			
	onUpdate: async function () {
		console.log("onUpdate");

		//validate on backend
		var request = that.getView().getModel("uer").getData();
		var url = prefix + "/uer/validateOnBackend";
		const response = await fetch(url, {
			method: "POST",
			cache: "no-cache",
			headers: {
				"Content-Type": "application/json",
				"Authorization": "Bearer " + token,
			},
			body: JSON.stringify(request),
		});
		const result = await response.json();

		if (result.status === "ERROR") {
			msgDialogs.error(result.msg);
			return;
		}
	}
			
			
#### GET:
    				var url = "/nornick.ru~nsi~uer~wm/uer/resumeRequest";

				var query = {
					actuality: 1
				}
 
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

### скачать файл

#### JS:

$.ajax({
url: url,
cache: false,
xhr: function () {
var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function () {
if (xhr.readyState == 2) {
if (xhr.status == 200) {
xhr.responseType = "blob";
} else {
xhr.responseType = "text";
}
}
};
return xhr;
},
success: function (data) {
//Convert the Byte Data to BLOB object.
var blob = new Blob([data], { type: "application/octetstream" });

    	//Check the Browser type and download the File.
    	var isIE = false || !!document.documentMode;
    	if (isIE) {
    		window.navigator.msSaveBlob(blob, fileName);
    	} else {
    		var url = window.URL || window.webkitURL;
    		link = url.createObjectURL(blob);
    		var a = $("<a />");
    		a.attr("download", fileName);
    		a.attr("href", link);
    		$("body").append(a);
    		a[0].click();
    		$("body").remove(a);
    	}
    }

});

#### Java Spring:

@ResponseStatus(HttpStatus.OK)
@GetMapping(value = "/excel")
public ResponseEntity<Resource> excel() throws URISyntaxException, IOException {
String fileName = "targetFile.xlsx";

    Excel f = new Excel();
    f.createXlsxExcelFile("УЕР Записи");
    f.createCellByIndexRow(0, 0, "Глобальный идентификатор УЕР");
    byte[] fileAsByteArray = f.getFileAsByteArray();

    File targetFile = new File(fileName);
    OutputStream outStream = new FileOutputStream(targetFile);
    try {
    	outStream.write(fileAsByteArray);
    } catch (IOException e) {
    	throw new RuntimeException(e);
    }
    IOUtils.closeQuietly(outStream);
    System.out.println(targetFile.getAbsolutePath());

    Path path = Paths.get(fileName);
    ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

    return ResponseEntity.ok()
    		.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "targetFile.xlsx")
    		.contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
    		.body(resource);

}

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



    		formatter:
    			<Text
    				text="{
    					path: 'jpd>status',
    					formatter: '.formatter.jpd'
    				}"/>

# SQL Server MSSQL MS SQL:

## CREATE TABLE:
	create table User(
		id int identity (1,1) not null primary key,
		name nvarchar(200),
		old int,
		descr nvarchar(1000),
		CONSTRAINT uq_deadlines_name unique (name)
	);
 
## ALTER TABLE:
	alter table ProjectCategory
	add	codeCategory nvarchar(50) not null default 'XXX',
		creationDate datetime not null default '2022-10-06 10:23:37.043',
		modificationDate datetime not null default '2022-10-06 10:23:37.043',
		creationUser nvarchar (50) not null default 'XXX',
		modificationUser nvarchar (50) not null default 'XXX'       	
 	alter table User
	alter column section nvarchar(800);	
  	alter table RequestStatus
	drop column code2;
 	
 	alter table User
	add constraint KeyName unique (muName);
 	alter table User
	drop constraint KeyName;

	UPDATE Sales_Import
	SET Sales_Import.AccountNumber = RAN.AccountNumber
	FROM Sales_Import SI
	INNER JOIN RetrieveAccountNumber RAN
	ON SI.LeadID = RAN.LeadID;


## Change Tracking - История изменений
	--turn on cdc - change data capture
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
	@source_name   = N'Uer', 
	@role_name     = NULL 
 
## TRIGGER

	--create
	CREATE TRIGGER User_INSERT
	ON User
	AFTER INSERT
	AS
	BEGIN
		UPDATE User
		set modificationDate = CURRENT_TIMESTAMP,
		creationDate = CURRENT_TIMESTAMP
		where id = (select id from INSERTED);
	END
 
	--update
	CREATE TRIGGER User_UPDATE
	ON User
	AFTER UPDATE
	AS
	BEGIN
		UPDATE User
		set modificationDate = CURRENT_TIMESTAMP
		where id = (select id from INSERTED);
	END
      

    --Полнотекстовый поиск
    	--Настройка
    		-- create fulltext catalog
    		CREATE FULLTEXT CATALOG MtrLiteCatalog
    		 WITH ACCENT_SENSITIVITY = ON
    		 AS DEFAULT
    		 AUTHORIZATION dbo
    	   GO


    	   --Изменение полнотекстового каталога

    	   ALTER FULLTEXT CATALOG MtrLiteCatalog
    		 REBUILD WITH ACCENT_SENSITIVITY=OFF
    	   GO


    	   --возвращаем назад

    	   ALTER FULLTEXT CATALOG MtrLiteCatalog
    		 REBUILD WITH ACCENT_SENSITIVITY=ON
    	   GO


    	   --удалить каталог
    	   --   DROP FULLTEXT CATALOG MtrLiteCatalog;

    	   --Создание полнотекстового индекса

    	   CREATE FULLTEXT INDEX ON NSI_MATERIALS(ShortName)
    		 KEY INDEX PK_NSI_MATERIALS ON (MtrLiteCatalog)
    		 WITH (CHANGE_TRACKING AUTO)
    	   GO


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

    --SQL
    	--Слово содержит смешанную раскладку клавиатуры
    			select *
    			from demo
    			where
    				name like N'%[A-Z][А-Я][A-Z]%'
    				or name like N'%[А-Я][A-Z][А-Я]%'
    				or name like N'%[А-Я][A-Z][ ]%'
    				or name like N'%[ ][A-Z][А-Я]%'
    				or name like N'%[A-Z][А-Я][ ]%'
    				or name like N'%[ ][А-Я][A-Z]%'

    	--Значение поля начинается с прилагательного или абревиатуры
    		select *
    		from
    			(select
    				GID,
    				substring(name, 1, CHARINDEX(' ', name)) as firstWord
    			from demo
    			) as one
    		where
    			firstWord like '%[A-Z][A-Z]%' collate Latin1_General_BIN --абревиатура (условие первые две буквы заглавные)
    			or upper(substring(firstWord, LEN(firstWord) - 1, LEN(firstWord))) in (N'ОЙ', N'ЫЙ', N'ИЙ', N'ЕЙ') -- поиск прилагательного (берутся последние 2 буквы первого слова в поле и проверяется на окончание. Метод требует таблицы исключений)

    	--Значения 'test' нет в поле
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
    	values (N'Черновик', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'komarovavl', 'komarovavl'),

    	create table [dbo].[UER](
    		id int IDENTITY(1,1) NOT NULL PRIMARY KEY,
    		gid nvarchar(20) NULL,
    		code nvarchar(20) NULL,
    		uerName nvarchar(300) NULL,
    		recordStatus int FOREIGN KEY REFERENCES RecordStatus(id)
    	);

    	insert into UER (gid, code, uerName)
    	values ('1', N'УЕР-06-02-01', N'Установка дверей внут-ренних (в т.ч. деревянных, ПВХ, металлических)');


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

# Reddis:

    Reddis - это бд в памяти NoSql, они предназначены для хранения в БД (в памяти) объекты какие-то количество времени. Хранят объекты в виде HashMap.
    Плюс Reddis:
    	- он заточен под хранение в HashMap, и по ключу будет искать значение максимально быстро. Он может настроить время жизни объекта, т.е. можно задать что к примеру корзина покупок юзера (ключ - логин, значение - json с описанием покупок) и задать время хранения этого объекта 2 недели
    	- легко масштабируются
    	- отказоустойчивы - т.е. если инстанс Reddis упадет, то он будет восстановлен без потерь данных

# Docker:

## Команды:

    docker images - все образы

### Postgres:

    docker exec  uer-postgres-1 pg_dump -U postgres --column-inserts --data-only  postgres > inserts.sql
    docker run --name postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres:11.1 - запустит в контейнере postgresql если его нет, то скачает его.
    docker run --name postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d --network resource postgres - запуск контейнера в сети rescource
    docker exec -it postgres psql -U postgres - обращаемся в контейнер postgres к программе psql и входим в терминальную сессию

    docker run --name <containerName> -p 8080:8080 -d <imageName>:<tag/version> - запуск java приложения


    docker run --name spr -p 8080:8080 -d -e "SPRING_PROFILES_ACTIVE=dev" -e spring.datasource.url=jdbc:postgresql://postgres:5432/resource --network  resource  spring-boot-docker:0.0.1-SNAPSHOT - запуск java приложения с указанием профиля (для spring) и сети rescource

    docker container ls - вывод всех контейнеров
    docker ps - вывод активных контейнеров
    docker ps -a - вывод всех контейнеров

    docker stop <containerName> - остановка контейнера
    docker rm <containerName> - удалить контейнер
    docker network create <networkName> - создаем сеть
    docker network ls - список всех сетей
    docker system prune -af --volumes - очистка всех volumes
    docker-compose up - поднимаем образы файла docker-compose.yml
    docker-compose up --build - билдим заново
    docker-compose rm - удаляем все образы
    docker-compose down -v
    winpty docker run -i -t node:alpine - использовать в Windows winpty для интерактивного запуска образа
    docker logs -f <container name> - показать логи контейнера
    docker run -v $(pwd):/var/opt/project bash:latest \bash -c "echo Hello > /var/opt/project/file.txt" - запуск баш скрипта в контейнер при запуске
    docker exec -ti myapp /bin/sh - зайти в java контейнер (если нет /bin/bash)

    docker run
    	-e spring.datasource.username=postgres
    	-e spring.datasource.password=postgres

### docker volume:

    docker volume ls - вывод всех volume
    docker volume create test-volume - создать volume c именем test-volume
    docker volume create - создать volume с рандомным именем

    docker run
    	--name mysql-01  - ставим имя контейнеру mysql-01
    	-v pv-mysql-data:/var/lib/mysql - указываем что нужно использовать volume pv-mysql-data в нашей файловой системе и смаунтить его в папку контейнера /var/lib/mysql. Если volume не был создан заранее, докер его создаст сам в стандартной папке всех volumes
    	-e MYSQL_ROOT_PASSWORD=my-password - указываем параметр
    	-d  - указываем что запуск в режиме detach - не задерживать терминал
    	mysql - имя образа, если его нет локально, докер скачает с докер хаба
    	Команда целиком - docker run --name mysql-01 -v pv-mysql-data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=my-password -d mysql

    docker volume inspect test-volume - описание указанного volume
    docker volume rm  test-volume - удаление volume
    docker volume prune - удаление не используемых volume, которые не прикреплены к работающему контейнеру

    docker run -d -v /test/app:/bin/testapp ubuntu:latest - маунт конкретной папки в ОС в папку в контейнере

##### PostgreSQL:

    docker run --name postgres-01 -v v-postgres:/var/lib/postgresql/data -d postgres - запуск PosrtgreSQL c volume

### Создание своих образов:

#### Командами в самом контейнере:

    	Создание своего образа с установленным Git:
    		docker run -i -t ubuntu:18.04 /bin/bash - запуск образа на основе ubuntu 18.04 и вход в ее терминал с помощью /bin/bash и (-i -t)
    		в терминале контейнера вводим:
    			apt-get update
    			apt-get install -y git
    		проверяем что git установлен:
    			which git
    		Выходим из контейнера:
    			exit
    		Проверяем измененные файлы:
    			docker diff 'id'
    		Делаем коммит контейнера что бы создать свой новый образ:
    			docker commit 'id' containeName


    	Создание своего образа с установленной jdk 17:
    		Вводим команду:
    			docker run -i -t ubuntu:20.04 /bin/bash - запуск образа на основе ubuntu 20.04 и вход в ее терминал с помощью /bin/bash и (-i -t)
    		Мы вошли в терминал, тут вводим:
    			apt-get update
    			apt-get install -y openjdk-17-jdk
    		Проверяем версию установленной Java:
    			java -version
    		Выходим из контейнера:
    			exit
    		Проверяем измененные файлы:
    			docker diff 'id'
    		Делаем коммит созданного контейнера что бы создать свой образ:
    			docker commit 'id' yourNewContainerName

    	Создание своего образа с установленной liberica jdk 17:
    		Вводим команду:
    			docker run -it ubuntu:20.04 /bin/bash - запуск образа на основе ubuntu 20.04 и вход в ее терминал с помощью /bin/bash и (-i -t)
    		Мы вошли в терминал, тут вводим:
    			apt-get update
    			apt-get --assume-yes install wget
    			apt-get --assume-yes install gnupg
    			wget -q -O - https://download.bell-sw.com/pki/GPG-KEY-bellsoft | apt-key add -
    			echo "deb [arch=amd64] https://apt.bell-sw.com/ stable main" | tee /etc/apt/sources.list.d/bellsoft.list
    			apt-get update
    			apt-get --assume-yes install bellsoft-java17
    		Проверяем версию установленной Java:
    			java -version
    		Выходим из контейнера:
    			exit
    		Проверяем измененные файлы:
    			docker diff 'id'
    		Делаем коммит созданного контейнера что бы создать свой образ:
    			docker commit 'id' yourNewContainerName

#### Dockerfile:

    		Создание своего образа с помощью Dockerfile с установленной jdk:
    			Cоздаем в папке файл:
    				touch Dockerfile
    			Вписываем в него следующее содержимое:
    				FROM ubuntu:18.04
    				RUN apt-get update
    	    		RUN apt-get install -y openjdk-8-jdk
    	    	Запускаем формирования образа:
    	    		docker build -t ubuntu_with_jdk . - точка это путь к файлу


    		Создание своего образа с помощью Dockerfile с установленной liberica jdk:
    			Cоздаем в папке файл:
    				touch Dockerfile
    			Вписываем в него следующее содержимое:
    				FROM ubuntu:20.04
    				RUN apt-get update
    				RUN apt-get --assume-yes install wget
    				RUN apt-get --assume-yes install gnupg
    				RUN wget -q -O - https://download.bell-sw.com/pki/GPG-KEY-bellsoft | apt-key add -
    				RUN echo "deb [arch=amd64] https://apt.bell-sw.com/ stable main" | tee /etc/apt/sources.list.d/bellsoft.list
    				RUN apt-get update
    				RUN apt-get --assume-yes install bellsoft-java17
    	    	Запускаем формирования образа:
    	    		docker build -t ubuntu_with_liberica . - точка это путь к файлу



    		Создание и запуск своего образа с java приложением на основе образа Ubuntu и jdk17:
    			Cоздаем в корне проекта файл:
    				touch Dockerfile
    			Вписываем в него следующее содержимое:
    				FROM ubuntu:20.04
    				RUN apt-get update
    				RUN apt-get install -y openjdk-17-jdk
    				COPY target/*.jar app.jar
    				ENTRYPOINT ["java","-jar","/app.jar"]
    	    	Запускаем формирования образа:
    	    		docker build -t ubuntu_with_liberica . - точка это путь к файлу
    	    	Запускаем приложение:
    				docker run -p 8080:8080 ubuntu_java_app


    		Создание и запуск своего образа с java приложением на основе образа Ubuntu и liberica jdk17:
    			Cоздаем в корне проекта файл:
    				touch Dockerfile
    			Вписываем в него следующее содержимое:
    				FROM ubuntu:20.04
    				RUN apt-get update
    				RUN apt-get --assume-yes install wget
    				RUN apt-get --assume-yes install gnupg
    				RUN wget -q -O - https://download.bell-sw.com/pki/GPG-KEY-bellsoft | apt-key add -
    				RUN echo "deb [arch=amd64] https://apt.bell-sw.com/ stable main" | tee /etc/apt/sources.list.d/bellsoft.list
    				RUN apt-get update
    				RUN apt-get --assume-yes install bellsoft-java17
    				COPY target/*.jar app.jar
    				ENTRYPOINT ["java","-jar","/app.jar"]
    	    	Запускаем формирования образа:
    	    		docker build -t ubuntu_liberica_myapp . - точка это путь к файлу
    	    	Запускаем приложение:
    				docker run -p 8080:8080 ubuntu_liberica_myapp


    		Создание и запуск java приложения на основе Астра линукс и liberica jdk17:
    			Формирование исходного образа Астра Линукс:
    				https://wiki.astralinux.ru/pages/viewpage.action?pageId=137563067 - ссылка на инструкцию от производителя
    				build-docker-image.sh - скачиваем себе этот файл, это сценирий для формирования образа
    				chmod +x build-docker-image.sh - даем права в папке с файлом на запуск сценария (код из инструкции)
    				sudo ln -s /usr/share/debootstrap/scripts/gutsy /usr/share/debootstrap/scripts/orel - делаем это что бы запустить скрипт
    				./build-docker-image.sh - запуск скрипта, после этого на нашем компе появится образ астры, который можно брать за основу
    			Cоздаем в корне java проекта файл:
    				touch Dockerfile
    			Вписываем в него следующее содержимое:
    				FROM astra_linux_ce_2.12
    				RUN apt-get update
    				RUN apt-get --assume-yes install wget
    				RUN apt-get --assume-yes install gnupg
    				RUN wget -q -O - https://download.bell-sw.com/pki/GPG-KEY-bellsoft | apt-key add -
    				RUN echo "deb [arch=amd64] https://apt.bell-sw.com/ stable main" | tee /etc/apt/sources.list.d/bellsoft.list
    				RUN apt-get update
    				RUN apt-get --assume-yes install bellsoft-java17
    				COPY target/*.jar app.jar
    				ENTRYPOINT ["java","-jar","/app.jar"]
    			Запускаем формирования образа:
    	    		docker build -t myapp . - точка это путь к файлу
    	    	Запускаем приложение:
    				docker run -p 8080:8080 myapp


    		Делаем сборку проекта в docker образе с помощью maven:
    			Cоздаем в корне проекта файл:
    				touch Dockerfile
    			Вписываем в него следующее содержимое:
    				FROM maven:3.8.7-eclipse-temurin-17
    				COPY . .
    				RUN mvn clean package
    			Создаем файл build.sh со скриптом:
    				#! /bin/bash

    				if [ -d "./target/" ]
    				then
    					rm -r target/
    				fi
    				docker build -t build-jar-inside-docker-image .
    				docker create -it --name build-jar-inside-docker build-jar-inside-docker-image bash
    				docker cp build-jar-inside-docker:/target ./target
    				docker rm -f build-jar-inside-docker
    			Получаем в итоге готовый jar в папке ./target:
    				my_app.jar


    		Сборка и запуск java приложения на основе Астра линукс и liberica jdk17:
    			Формирование исходного образа Астра Линукс:
    				https://wiki.astralinux.ru/pages/viewpage.action?pageId=137563067 - ссылка на инструкцию от производителя
    				build-docker-image.sh - скачиваем себе этот файл, это сценирий для формирования образа
    				chmod +x build-docker-image.sh - даем права в папке с файлом на запуск сценария (код из инструкции)
    				sudo apt install debootstrap - ставим себе debootstrap
    				sudo ln -s /usr/share/debootstrap/scripts/gutsy /usr/share/debootstrap/scripts/orel - делаем это что бы запустить скрипт
    				./build-docker-image.sh - запуск скрипта, после этого на нашем компе появится образ астры, который можно брать за основу
    			Cоздаем в корне java проекта файл:
    				touch Dockerfile
    			Вписываем в него следующее содержимое (первый блок FROM это сборка, второй формирование образа и запуск java приложения):
    				FROM maven:3.8.7-eclipse-temurin-17 as build
    				COPY . .
    				RUN mvn clean package

    				FROM astra_linux_ce_2.12
    				RUN apt-get update
    				RUN apt-get --assume-yes install wget
    				RUN apt-get --assume-yes install gnupg
    				RUN wget -q -O - https://download.bell-sw.com/pki/GPG-KEY-bellsoft | apt-key add -
    				RUN echo "deb [arch=amd64] https://apt.bell-sw.com/ stable main" | tee /etc/apt/sources.list.d/bellsoft.list
    				RUN apt-get update
    				RUN apt-get --assume-yes install bellsoft-java17
    				COPY --from=build target/*.jar app.jar
    				ENTRYPOINT ["java","-jar","/app.jar"]
    			Запускаем формирование образа:
    	    		docker build -t myapp . - точка это путь к файлу
    	    	Запускаем приложение:
    				docker run -p 8080:8080 myapp

    docker-compose:
    	version: '3'

    	services:
    	  postgres:
    		image: postgres:14.7
    		domainname: postgres
    		ports:
    		  - "5432:5432"
    		environment:
    		  - POSTGRES_USER=postgres
    		  - POSTGRES_PASSWORD=postgres
    		healthcheck:
    		  test: ["CMD", "pg_isready", "-q", "-U", "postgres"]
    		  interval: 5s
    		  timeout: 1s
    		  retries: 2

    	  openui5:
    		image: openui5
    		ports:
    		  - "80:80"

    	  flyway:
    	    image: boxfuse/flyway
    	    command: -url=jdbc:postgresql://postgres:5432/postgres -schemas=public -user=postgres -password=postgres -connectRetries=30 migrate
    	    volumes:
    	      - ./flyway:/flyway/sql
    	    depends_on:
    	      - postgres

    	  redis:
    	    image: 'bitnami/redis:latest'
    	    environment:
    	      - ALLOW_EMPTY_PASSWORD=yes
    	    ports:
    	      - "6379:6379"

#### Запуск разных профилей spring

Cправа вверху в раскрывающемся списке выбрать Edit configuration, в поле Environment variables ввести - SPRING_PROFILES_ACTIVE=dev (для профиля application-dev.yml)

#### Debug from idea to SAP Portal:

    	- go to Run -> Debug
    	- Select Edit Configurations
    	- Expand Template section
    	- Select "Remote"
    	- Make settings:
    		Debugger mode: Attache to remote JVM
    		Transport: Socket
    		Host: <your host>
    		Port: 50021
    		Use module classpath: <select your java module>
    	- Push button in right up "Create configuration"
    	- You will see in debug dropdown list or in Debug settings section "Remote" and there your configuration
    	- Now you can push "Debug"
    	- Check that you turned on debug on SAP Portal

# Node.js:

## node

    node --version
    node <адрес до js файла> - выполнение программы на javascript на node js, он конвертирует это в си код и запускает

## npm

    npm - node package manager позволяет устанавливать различные библиотеки, утилиты и управлять разрабатываемым проектом.

    npm --version
    npm version - вывод полной информации

    npm init --yes - создание package.json файла с автоматическим проставлением значений в поля.
    npm init -y - аналогично предыдущей, просто кратко

	npm install - целиком восстановит содрежимое папки node_modules на основе сведений файла package.json
    npm install -g sass - установка глобально пакета sass. Глобально - доступен всем проектам
    npm install bootstrap --save - установка на уровне пакета, флаг --save (-S) - на уровне пакет
    npm install jquery -S - тоже самое что выше
    npm install jquery - тоже самое что выше
    npm install webpack --save-dev - установка на уровне пакета, необходимая лишь на этапе разработки
    npm install webpack -D - тоже самое что выше
    npm install webpack-cli css-loader sass-loader --save-dev - установка нескольких пакетов сразу
    npm install <package>@<version> - установка нужной версии

    package-lock.json - содержит список всех установленных пакетов, изменять его вручную нельзя
	
	npm run <script name> - запуск скрипта указанного в файле package.json в разделе scripts

    npm list - вывод всех установленных пакетов
    npm list --depth 0 - зависимости текущего проекта
	npm list --depth 2 - зависимости на 2 уровня глубиной
    npm list -g - вывод всех установленных пакетов глобально
    npm list -g --depth 0 - вывод всех установленных пакетов глобально первого уровня

    npm view typescript versions - вывод всех доступных версий пакета typescript
    npm outdated - вывод устаревших версий пакетов
    npm update -g <пакет> - обновление устаревшего пакета
    npm uninstall popper.js - удаление указанного пакета
    npm uninstall -g popper.js - удаление глобально

    c:/users/Login/AppData/Roaming/npm-cache/_logs - логи, иногда надо чистить их

## nvm

    nvm use node - use current version
    nvm use --lts - use lts version
    nvm use 8.2.1 - use specific version
    nvm install 16.18.0 - install node version 16.18.0

# Windows

    ssh -L 8888:192.168.1.99:3389 root@192.168.1.90 - проброс порта, указываем что на локальный порт 8888 поставить порт 3389 сервера 99 через сервер 90

# React:

    ## Базовые команды
    npx create-react-app my-app - создать приложение my-app
    npm install - загрузка всех нужных пакетов
    npm start - запуск приложения
    npm test - Runs the test watcher in an interactive mode. By default, runs tests related to files changed since the last commit.
    npm run build - Builds the app for production to the build folder. It correctly bundles React in production mode and optimizes the build for the best performance. The build is minified and the filenames include the hashes. Your app is ready to be deployed.

# Версионность ПО

    1.0.0 - первая версия пакета
    1.0.1 - изменение третьего числа означает исправление ошибок с обратной совместимостью
    1.1.0 - изменение второго числа означает добавление новой функциональности с обратной совместимостью
    2.0.0 - изменение первого числа означает изменение кода, возможно, без обратной совместимости.

# Hotkeys:

#### VCS:

    Ctrl + Shift + O - Поиск метода
    Shift + Alt + F - форматирование кода
    Ctrl + G - переход к строке ...
    Shift + Alt + -> - выделение фрагментов
    Ctrl + Shift + K - удалить строку

#### IDEA:

    Ctrl + Shift + U - to lower case
    Ctrl + F12 - список методов
    Ctrl + Alt + L - форматирование
    Ctrl + Alt + Shift + L - диалог форматирования
    Ctrl + D - дубль строки
    Ctrl + Y - удаление строки
    Ctrl + Alt + Left - назад
    Shift + Alt + UP - выделение слова, метода и т.д.
