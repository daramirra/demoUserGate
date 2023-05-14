# Проект по автоматизации тестирования демонстрационного стенда [UserGate](https://demo.usergate.com:8001/)

## Технологии и инструменты

<p  align="center"

<code><img width="5%" title="IntelliJ IDEA" src="images/daramirra_IDEA-logo.svg"></code>
<code><img width="5%" title="Java" src="images/daramirra_java-logo.svg"></code>
<code><img width="5%" title="Selenide" src="images/daramirra_selenide-logo.svg"></code>
<code><img width="5%" title="REST-Assured" src="images/daramirra_rest-assured-logo.svg"></code>
<code><img width="5%" title="Selenoid" src="images/daramirra_selenoid-logo.svg"></code>
<code><img width="5%" title="Gradle" src="images/daramirra_gradle-logo.svg"></code>
<code><img width="5%" title="JUnit5" src="images/daramirra_junit5-logo.svg"></code>
<code><img width="5%" title="Allure Report" src="images/daramirra_allure-Report-logo.svg"></code>
<code><img width="5%" title="Allure TestOps" src="images/daramirra_allure-ee-logo.svg"></code>
<code><img width="5%" title="Github" src="images/daramirra_git-logo.svg"></code>
<code><img width="5%" title="Jenkins" src="images/daramirra_jenkins-logo.svg"></code>
<code><img width="5%" title="Jira" src="images/daramirra_jira-logo.svg"></code>
<code><img width="5%" title="Telegram" src="images/daramirra_Telegram.svg"></code>
</p>

> *В данном проекте автотесты написаны на <code><strong>*Java*</strong></code> с использованием фреймворка <code><strong>*Selenide*</strong></code> для UI-тестов.*
>
>*Для сборки проекта используется <code><strong>*Gradle*</strong></code>.*
>
>*<code><strong>*JUnit 5*</strong></code> используется как фреймворк для модульного тестирования.*
>
>*Запуск тестов выполняется из <code><strong>*Jenkins*</strong></code>.*
>
>*<code><strong>*Selenoid*</strong></code> используется для запуска браузеров в контейнерах  <code><strong>*Docker*</strong></code>.*
>
>*<code><strong>*Allure Report, Allure TestOps, Jira, Telegram Bot*</strong></code> используются для визуализации результатов тестирования.*

## Реализованы проверки

>- [x] *Лог консоли браузера на странице входа в Систему не содержит ошибок*
>- [x] *Успешный вход в Систему*
>- [x] *Попытка входа в Систему с неверным регистром значения в поле Логин*
>- [x] *Попытка входа в Систему с указанием спецсимволов в поле Логин*
>- [x] *Попытка входа в Систему с незаполненными полями Логин, Пароль*
>- [x] *Попытка входа в Систему с незаполненным полем Пароль*
>- [x] *Попытка входа в Систему с незаполненным полем Логин*
>- [x] *Попытка входа в Систему с неверным паролем*
>- [x] *Попытка входа в Систему с неверным логином*
>- [x] *Выход из Системы*

## Запуск тестов из терминала

*Запуск тестов с заполненным remote.properties:*

```bash
gradle clean test
```

*Запуск тестов без заполненного remote.properties:*

```bash
gradle clean test 
  -Dbrowser=[BROWSER]
  -DbrowserVersion=[BROWSER_VERSION]
  -DbrowserSize=[BROWSER_SIZE]
  -DremoteDriverUrl=https://[selenoidUser]:[selenoidPwd]@[REMOTE_DRIVER_URL]/wd/hub/
  -DvideoStorage=https://[REMOTE_DRIVER_URL]/video/
  -Dthreads=[THREADS]
  -DaccountPassword=[ACCOUNT_PASSWORD]
  -DbaseUrl=[BASE_URL]
```

где:
>- [x] *Dbrowser - браузер, в котором будут выполняться тесты (по умолчанию chrome)*
>- [x] *DbrowserVersion - версия браузера (по умолчанию 100.0)*
>- [x] *DbrowserSize - размер окна браузера (по умолчанию 1920x1080)*
>- [x] *DremoteDriverUrl - логин, пароль и адрес удаленного сервера, где будут выполняться тесты*
>- [x] *DvideoStorage - хранилище видео выполненных тестов*
>- [x] *Dthreads - количество потоков выполняющихся тестов*
>- [x] *DaccountPassword - пароль учетной записи пользователя для тестов*
>- [x] *DbaseUrl - основной адрес тестового стенда*

*Запуск тестов в несколько потоков:*

```bash
gradle clean test -Dthreads=[threadsValue]
```

*Сформировать allure отчет:*

```bash
./gradle clean test allureReport
```
## <img width="4%" title="Jenkins" src="images/daramirra_jenkins-logo.svg"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/C07-daramirra-demo/)

*Для запуска сборки необходимо нажать кнопку <code><strong>*Собрать сейчас*</strong></code>.*

<p align="center">
  <img src="images/daramirra_job_param.png" alt="job" width="800">
</p>

*После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки появится
значок <img width="2%" title="Allure Report" src="images/daramirra_allure-Report-logo.svg"><code><strong>*Allure
Report*</strong></code>, кликнув по которому, откроется страница с сформированным html-отчетом.*

<p align="center">
  <img src="images/daramirra_Allure jobs history.png" alt="job" width="1000">
</p>

## <img width="4%" title="Allure Report" src="images/daramirra_allure-Report-logo.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/C07-daramirra-demo/23/allure/)

### :pushpin: Общая информация

*Главная страница Allure-отчета содержит следующие информационные блоки:*

> - [x] <code><strong>*ALLURE REPORT*</strong></code> - отображает дату и время прохождения теста, общее количество прогнанных кейсов, а также диаграмму с указанием процента и количества успешных, упавших и сломавшихся в процессе выполнения тестов
>- [x] <code><strong>*TREND*</strong></code> - отображает тренд прохождения тестов от сборки к сборке
>- [x] <code><strong>*SUITES*</strong></code> - отображает распределение результатов тестов по тестовым наборам
>- [x] <code><strong>*ENVIRONMENT*</strong></code> - отображает тестовое окружение, на котором запускались тесты (в данном случае информация не задана)
>- [x] <code><strong>*CATEGORIES*</strong></code> - отображает распределение неуспешно прошедших тестов по видам дефектов
>- [x] <code><strong>*FEATURES BY STORIES*</strong></code> - отображает распределение тестов по функционалу, который они проверяют
>- [x] <code><strong>*EXECUTORS*</strong></code> - отображает исполнителя текущей сборки (ссылка на сборку в Jenkins)

<p align="center">
  <img src="images/daramirra_Allure Report.png" alt="Allure Report" width="900">
</p>

### :pushpin: Список тестов c описанием шагов и визуализацией результатов

*На данной странице представляется стандартное распределение выполнявшихся тестов по тестовым наборам или классам, в
которых находятся тестовые методы.*

<p align="center">
  <img src="images/daramirra_Allure Report steps.png" alt="Allure Report" width="900">
</p>

## <img width="4%" title="Allure TestOPS" src="images/daramirra_allure-ee-logo.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/2268/dashboards)

*Allure TestOps позволяет управлять как ручным, так и автоматизированным тестированием: создавать тест-кейсы и чек-листы, запускать ручные и автоматические прогоны, заводить дефекты и собирать статистику по проделанной работе. Также у Allure большой набор интеграций с различными инструментами и языками программирования. Allure TestOps позволяет автоматически переносить сценарии тестирования в код и после этого дополнять их кодом. При запуске тестов можно выбирать какие именно кейсы необходимо запустить.*

### :pushpin: Основной дашборд

<p align="center">
  <img src="images/daramirra_allureTestOPS dashboards.png" alt="dashboards" width="900">
</p>

### :pushpin: Запуски

<p align="center">
  <img src="images/daramirra_allureTestOPS launches.png" alt="launches" width="900">
</p>

### :pushpin: Результат запуска

<p align="center">
  <img src="images/daramirra_allureTestOPS launch.png" alt="launch" width="900">
</p>

### :pushpin: Тест-кейсы

<p align="center">
  <img src="images/daramirra_Test cases.png" alt="test cases" width="900">
</p>

## <img width="4%" title="Jira" src="images/daramirra_jira-logo.svg"> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-698)

*В проекте реализована интеграция с Jira, что позволяет добавлять в задачи тест-кейсы, запуски и их результаты.*

<p align="center">
  <img src="images/daramirra_allureTestOPS jira.png" alt="jira" width="1000">
</p>

## <img width="4%" title="Selenoid" src="images/daramirra_selenoid-logo.svg"> Пример запуска теста в Selenoid

<p align="center">
  <img src="images/daramirra_video.gif" alt="video" width="1000">
</p>

## <img width="4%" title="Telegram" src="images/daramirra_Telegram.svg"> Уведомления в Telegram

*После завершения сборки Telegram-бот автоматически обрабатывает и отправляет сообщение с отчетом о прогоне.*

<p align="center">
  <img src="images/daramirra_tlgrm.png" alt="Telegram" width="440">
</p>