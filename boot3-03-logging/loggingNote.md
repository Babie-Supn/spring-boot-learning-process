日志变量
---
在properties中以logging为前缀的\
%d{yyyy-MM-dd HH:mm:ss} %-5level [%thread] %logger{15} ===> %msg%n\
level:日志级别\
thread:线程 也就是日志打印的[]里的内容 有main线程\
logger:日志类,[]后的东西\
%msg%n：消息\
默认输出格式:"%clr(%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd'T'HH:mm:ss.SSSXXX}})\
{faint} %clr(${LOG_LEVEL_PATTERN:-%5p}) %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}"\
○ ALL：打印所有日志\
○ TRACE：追踪框架详细流程日志，一般不使用\
○ DEBUG：开发调试细节日志\
○ INFO：关键、感兴趣信息日志\
○ WARN：警告但不是错误的信息日志，比如：版本过时\
○ ERROR：业务错误日志，比如出现各种异常\
○ FATAL：致命错误日志，比如jvm系统崩溃\
○ OFF：关闭所有日志记录\
由低到高：ALL,TRACE, DEBUG, INFO, WARN, ERROR,FATAL,OFF；\
只会打印指定级别及以上级别的日志\
但一般开发环境下 FATAL和OFF 一般不打印\
SpringBoot底层默认的日志级别是info\
logging.level.root调整日志级别\
logging,level.(可以选择精确的包，类)来调整日志级别\
---
日志分组
---
可以取一个组名\
用logging.group.组名=全类名（pres.atbabie.logging.Boot303LoggingApplication),全类名...





   

