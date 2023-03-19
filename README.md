# money-transfer-service

Это сервис для трансфера денег между картами.

Сервис работает на порту 5500.

Запрос приходит на http://localhost:5500/transfer
с методом POST и json файлом с запросом.


---

Карта 1:  

2585541741745566

12/27

850

---

Карта 2: 

3754567210826497

10/29

113

---


## Запуск сервиса:

1. Сначала нужно слонировать его на компьютер из github.
2. Собрать архивный файл:  mvn package
3. Построить Docker image:  docker build -t transfer:1.0
4. Запустить:  docker-compose up


## FRONT:
https://serp-ya.github.io/card-transfer