# selTestAutomation
Working QA TA Framework

-Durl=""
-DbrowserClient=""

GradleRunConfig:
clean test -PbrowserClient=gc

TestNGRunConfig:
VM options: -ea -javaagent:"D:\0_MyService_MyIT\myServiceMiscDocs\aspectjweaver-1.8.4.jar" -Denv=bvt
