# Guide

要求：

- 有两个类` Person`和 `Student`,它们存在继承关系。在`Person`中,有成员变量`name`,`sex`,`age` 三个,它们类型分别为`String`、`char`、`int`,有一个带参数的构造方法 `Person(String,char, int)`,用来对成员变量初始化。有成员方`setData(String,char, int)`设置成员变量`name`,`sex`,` age` 的值。`getData()` 是不带参数且返回值由`name`、`sex` 和 `age` 值构成的字符串的成员方法。
- `Student`类是`Person`类的子类,在`Student`中,有`int`类型的`sID`和`classNo` 成员变量用来表示学生的学号和班级号。它有带五个参数的方法`setData()`和不带参数的方法 `getData()`,`setData()`方法设置成员变量的值,而 `getData()`则是返回五个成员变量的值组成的字符串。 

实现：

简单的继承练习，注意`super`用法即可。