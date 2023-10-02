生命周期流程
---

启动前，listener 先`从META-INF/spring.fasctories`里读取到  
1.引导：  
  利用引导上下文`BootstrapContext`引导整个项目启动  
  `starting`:应用开始，`SpringApplicatio`的run方法一调用，只要有了`BootstrapContxt`就执行  
  `environmentPrepared`: 环境准备好（把启动参数等绑定到环境变量中），但是ioc还没有创建【调一次】
2.启动：  
`contextPrepared`:ioc容器创建并准备好，但是source(主配置类)没加载，并关闭引导上下文，组件都没创建 【调一次】  
`contextLoaded`ioc容器加载，主配置类加载进去了。但是ioc容器还没刷新（我们的bean没创建）  
=====截止之前，ioc容器中还未创建bean=====  
`started` ioc容器刷新了（所有bean造好了），但是runner没调用  
`ready` ioc容器刷新了，（所有bean造好了）所有runner调用完了   
3.运行：  
以前步骤都正确执行，代表容器running