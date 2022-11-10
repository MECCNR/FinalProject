# FinalProject

Для запуска следующих тестов необходимы следующие действия...

## Тестирование совместимости БД MySQL

1. Ввести в папке scripts команду в терминале: npm start
2. Ввести во втором терминале: docker compose up
3. Ввести в третьем терминале, в папке artifacts: java -jar aqa-shop.jar -port=8080
4. Запустить тест в src/test/java/ - FinalTestDBMySQL.java

## Тестирование покупки по карте

1. Ввести в папке scripts команду в терминале: npm start
2. Ввести во втором терминале: docker compose up
3. Ввести в третьем терминале, в папке artifacts: java -jar aqa-shop.jar -port=8080
4. Запустить тест в src/test/java/ - FinalTestPurchase.java

## Тестирование оформления кредита по карте

1. Ввести в папке scripts команду в терминале: npm start
2. Ввести во втором терминале: docker compose up
3. Ввести в третьем терминале, в папке artifacts: java -jar aqa-shop.jar -port=8080
4. Запустить тест в src/test/java/ - FinalTestCredit.java

## Тестирование совместимости БД PostgreSQL

1. Заменить файлы docker-compose.yml и application.properties в artifacts, файлами из reversePostgre
