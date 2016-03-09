# selTestAutomation
Working QA TA Framework. has commented out own selenium wrappers classes in favor of using Selenide's

-Durl=""

-DbrowserClient=""

GradleRunConfig:

clean test -PbrowserClient=gc

TestNGRunConfig:

VM options: -ea -javaagent:"D:\0_MyService_MyIT\myServiceMiscDocs\aspectjweaver-1.8.4.jar" -Denv=bvt

//
main Selenide classes to explore available manipulations: Selenide.java, SelenideElement.java, Condition.java
