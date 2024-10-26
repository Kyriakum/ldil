# Lightweight Dependency Injection Library

**By Kyriakum**

<hr> 

- ### [Features](#features)
- ### [License](#license)
- ### [To Dos](#to dos)

<hr>

## Features
<hr>

**Currently supports minimal features as I've just started working on the project.**

`@Inject` annotation to inject a field (Constructor injection is not yet supported :(
)

`@Prototype` annotation to define concrete classes you want injected as prototype (**New** instance each with object instantion)

`@Singleton` annotation to define concrete classes as singleton (**One** instance for all objects)

**Example code:**
```java
  public static void main(String[] args) {
        DependencyProvider dependencyProvider=new DependencyProvider();
        Injector injector=new Injector(dependencyProvider);
        injector.getMappingService().bindClassToClass(TestInterface.class,TestConcrete.class);
        TestObject obj = injector.createInstance(TestObject.class);
        }
```

Yay! TestObject was injected with a TestConcrete object! Wow!

<hr>

## License

<hr>

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

<hr>

## To Dos

<hr>

- Handle RuntimeExceptions with custom exceptions.
- Include slf4j for logging.
- Add dependency injection to constructors.