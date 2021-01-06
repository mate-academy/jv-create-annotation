# jv-create-annotation
 
### First HW
Посмотреть видео ([часть 1](https://mate-academy.github.io/jv-program-fulltime/02_jdbc/homework/01_DAO.html)) 
и создать АНАЛОГИЧНЫЙ проект:
- ConsoleHandler class 
- Bet model
- Storage class
- BetDao and BetDaoImpl
- Main

Затем: 
- Добавить ещё одну модель и DAO слой для неё. 

В конце первой части создать Pull request, и закинуть на проверку.

### Second HW
Приступать к выполнению второй части домашки желательно только после принятия первой, чтобы избежать конфликтов и проблем з git.
После принятия первой части домашки — нужно выполнить следующие действия - [video](https://www.youtube.com/watch?v=8MXeePzuE68&list=PL7FuXFaDeEX2JdShqx3URwdvqf6ow8G7H&index=9).

Посмотреть видео ([часть 2](https://mate-academy.github.io/jv-program-fulltime/02_jdbc/homework/02_injector.html)).
Затем: 
- Сделать так, чтобы DAO имплементацию этой модели ТАКЖЕ можно было внедрить инжектором в поле любого класса (например, в поле ConsoleHandler).
- Добавить в инжектор проверки на то, что над классом, экземпляр которого надо внедрить, стоит нужная аннотация.
- Если над классом-имплементацией, которую мы хотим внедрить в поле ConsoleHandler, отсутствует аннотация @Dao, 
нужно создать свой собственный Exception и пробрасывать его в инжекторе.

Не нужно создавать дополнительных аннотаций! У вас должно быть всего две аннотации - `@Dao` и `@Inject`.

В конце второй части также создать Pull request, и закинуть на проверку.
