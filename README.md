# delivery-changes-service
#### Приложение для регистрации заявок на перенос времени доставки от курьеров

#### Решаемые проблемы
Курьер едет вручать груз. <br> 
И ему внезапно потребовалось сообщить клиенту, что он сегодня не приедет. <br>
Курьер за рулем и ему неудобно звонить клиенту и договариваться о новом времени приезда. <br>
Курьеру нужно оповестить Call-центр в “один клик”, чтобы они позвонили клиенту и 
договорились о новой дате и времени доставки. 

#### Техническое решение

Через web-интерфейс для курьера, где он указывает номер заказа и нажимает кнопку “Не успеваю” происходит 
создание заявки для обработки колл-центров.

При нажатии добавляется новое задание для call-центра в БД.

Web-интерфейс для оператора call-центра: Список заданий для прозвона клиентов. <br>
В интерфейсе оператора выводится таблица с колонками:
- Номер заказа,
- Дата и Время добавления задания.

Также имеется фильтр или поиск “по номеру заказа”.

#### Представления
Интерфейс водителя, размещающего заявку на обработку в колл-центр
````
http://{application.host}/registerTask
````
Интерфейс оператора, обрабатывающего заявки
````
http://{application.host}/tasks
````
#### Реляционная модель
**client** - сущность клиента, содержащая минимально необходимые данные о нем
* id - PK
* last_name - фамилия
* first_name - имя
* middle_name - отчество
* sex - пол

**orders** - сущность, описывающая заказ
* id - PK
* order_number - номер заказа
* client_id - fk на клиента
* is_processed - доставлен ли заказ
* order_state - статус обработки заказа

**tasks** - сущность, описывающая заявку на обраотку в колл-центр
* id - PK
* created - дата содания заявки
* processed - дата обработки заявки
* order_number - номер заказа
* is_postponed - является ли заявка заявкой на перенос даты доставки
* hasProcessed - обработана ли заявка

