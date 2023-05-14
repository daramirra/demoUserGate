# Проект по автоматизации тестирования демонстрационного стенда [UserGate]()

## Технологии и инструменты

> *В данном проекте автотесты написаны на <code><strong>*Java*</strong></code> с использованием фреймворка <code><strong>*Selenide*</strong></code> для UI-тестов
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
>- [x] *DbrowserVersion - версия браузера (по умолчанию 91.0)*
>- [x] *DbrowserSize - размер окна браузера (по умолчанию 1920x1080)*
>- [x] *DremoteDriverUrl - логин, пароль и адрес удаленного сервера, где будут выполняться тесты*
>- [x] *DvideoStorage - хранилище видео выполненных тестов*
>- [x] *Dthreads - количество потоков выполняющихся тестов (по умолчанию 5)*
>- [x] *DaccountPassword - пароль учетной записи пользователя для тестов*
>- [x] *DbaseUrl - основной адрес тестового стенда*

*Запуск тестов в несколько потоков:*

```bash
gradle clean test -Dthreads=[threadsValue]
```

*Сформировать allure отчет:*

```bash
./gradlew clean test allureReport
```
