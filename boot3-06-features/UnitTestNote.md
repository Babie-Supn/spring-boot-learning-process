
如何在测试类中进行单元测试
---

只需要在测试类中用 `@Autowired `自动注入组件就可以进行测试  
`@DispalyName` 用这个标签可以区分测试的结果  
`@BeforeAll` 所有测试方法运行之前，先运行这个，只打印一次  
`@BeforeEach`每个测试方法运行之前，先运行这个，这个每个测试方法运行之前，都会打印  
`@MethodSource`用来指定方法名，指定方法的返回值，就是测试参数，但是这种方法的返回值最好是`Stream`  
`Stream.of(x,x,x)`  
详细可以参考：[https://junit.org/junit5/docs/current/user-guide/#writing-tests-disabling](https://junit.org/junit5/docs/current/user-guide/#writing-tests-disabling)


---


`Assertions `这个类用来测试断言，
