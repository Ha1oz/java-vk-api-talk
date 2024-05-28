## Как запустить?

1) Создаём сообщество ВК и из настроек берём ключ аутификации и код для подсоединения сервера
> Управление -> Работа с API
  
2) Клонируем репозиторий и заполняем следующие строки в файле конфигурации *application.properties*:

> Строка, которую сервер должен вернуть при первом подключении сервера:
> > *vk.confirm.response.string=*

> Аутификационный токен:
> > *vk.auth.token=*

> Адрес сервера:
> > *server.address=*

> Порт сервера:
> > *server.port=*

3) Запускаем приложение и в настройках сообщества ВК подтверждаем наш сервер указав url и добавив постфикс
> по умолчанию стоит */vk*. Можно изменить в *application.properties* в параметре *controller.request.mapping*

> Например: https://localhost:8080/vk
4) Теперь всё работает. Пользуемся.

