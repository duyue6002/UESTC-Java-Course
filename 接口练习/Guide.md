# Guide

要求：

- 第一步：我们要给Duck类增加两个接口类型的实例变量，分别是flyBehavior和quackBehavior，它们其实就是新的设计里的“飞行”和“叫唤”行为。每个鸭子对象都将会使用各种方式来设置这些变量，以引用它们期望的运行时的特殊行为类型(使用横着飞，吱吱叫，等等)。
- 第二步：我们还要把fly()和quack()方法从Duck类里移除，因为我们已经把这些行为移到FlyBehavior和QuackBehavior接口里了。我们将使用两个相似的PerformFly()和PerformQuack()方法来替换fly()和qucak()方法，后面你会看到这两个新方法是如何起作用的。
- 第三步：我们要考虑什么时候初始化flyBehavior和quackBehavior变量。最简单的办法就是在Duck类初始化的时候同时初始化他们。但是我们这里还有更好的办法，就是提供两个可以动态设置变量值的方法SetFlyBehavior()和SetQuackBehavior()，那么就可以在运行时动态改变鸭子的行为了。