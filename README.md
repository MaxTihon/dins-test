# Test app for DINS

### How it works

- Перед началом работы запустить Zookeeper и Kafka на вашем ПК
- Создать БД в MySQL
- В application.properties указать свой url, username, password
- Запустить ExampleApplication
- После запуска приложения в консоль будут выведены инструкции :
  " - To read data from DB and write to topic, enter 1"
	" - To read messages from topic and save data to DB, enter 2"
	" - Enter stop to complete the application"
