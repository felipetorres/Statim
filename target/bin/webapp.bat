@REM ----------------------------------------------------------------------------
@REM Copyright 2001-2004 The Apache Software Foundation.
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM      http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.
@REM ----------------------------------------------------------------------------
@REM

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\br\com\caelum\vraptor\3.3.1\vraptor-3.3.1.jar;"%REPO%"\cglib\cglib-nodep\2.1_3\cglib-nodep-2.1_3.jar;"%REPO%"\com\google\guava\guava\r07\guava-r07.jar;"%REPO%"\org\slf4j\slf4j-api\1.6.1\slf4j-api-1.6.1.jar;"%REPO%"\org\slf4j\slf4j-log4j12\1.6.1\slf4j-log4j12-1.6.1.jar;"%REPO%"\log4j\log4j\1.2.16\log4j-1.2.16.jar;"%REPO%"\net\vidageek\mirror\1.5.1\mirror-1.5.1.jar;"%REPO%"\org\objenesis\objenesis\1.1\objenesis-1.1.jar;"%REPO%"\ognl\ognl\2.7.3\ognl-2.7.3.jar;"%REPO%"\jboss\javassist\3.7.ga\javassist-3.7.ga.jar;"%REPO%"\com\thoughtworks\paranamer\paranamer\2.2\paranamer-2.2.jar;"%REPO%"\org\springframework\spring-aop\3.0.5.RELEASE\spring-aop-3.0.5.RELEASE.jar;"%REPO%"\aopalliance\aopalliance\1.0\aopalliance-1.0.jar;"%REPO%"\org\springframework\spring-asm\3.0.5.RELEASE\spring-asm-3.0.5.RELEASE.jar;"%REPO%"\org\springframework\spring-beans\3.0.5.RELEASE\spring-beans-3.0.5.RELEASE.jar;"%REPO%"\org\springframework\spring-core\3.0.5.RELEASE\spring-core-3.0.5.RELEASE.jar;"%REPO%"\commons-logging\commons-logging\1.1.1\commons-logging-1.1.1.jar;"%REPO%"\org\springframework\spring-context\3.0.5.RELEASE\spring-context-3.0.5.RELEASE.jar;"%REPO%"\org\springframework\spring-expression\3.0.5.RELEASE\spring-expression-3.0.5.RELEASE.jar;"%REPO%"\org\springframework\spring-web\3.0.5.RELEASE\spring-web-3.0.5.RELEASE.jar;"%REPO%"\org\aspectj\aspectjrt\1.6.9\aspectjrt-1.6.9.jar;"%REPO%"\net\sf\scannotation\scannotation\1.0.2\scannotation-1.0.2.jar;"%REPO%"\javassist\javassist\3.12.0.GA\javassist-3.12.0.GA.jar;"%REPO%"\jfree\jfreechart\1.0.12\jfreechart-1.0.12.jar;"%REPO%"\jfree\jcommon\1.0.15\jcommon-1.0.15.jar;"%REPO%"\org\hsqldb\hsqldb\2.2.4\hsqldb-2.2.4.jar;"%REPO%"\opensymphony\sitemesh\2.4.2\sitemesh-2.4.2.jar;"%REPO%"\javax\servlet\jstl\1.2\jstl-1.2.jar;"%REPO%"\org\hibernate\hibernate-entitymanager\3.6.7.Final\hibernate-entitymanager-3.6.7.Final.jar;"%REPO%"\org\hibernate\hibernate-core\3.6.7.Final\hibernate-core-3.6.7.Final.jar;"%REPO%"\antlr\antlr\2.7.6\antlr-2.7.6.jar;"%REPO%"\commons-collections\commons-collections\3.1\commons-collections-3.1.jar;"%REPO%"\dom4j\dom4j\1.6.1\dom4j-1.6.1.jar;"%REPO%"\org\hibernate\hibernate-commons-annotations\3.2.0.Final\hibernate-commons-annotations-3.2.0.Final.jar;"%REPO%"\org\hibernate\javax\persistence\hibernate-jpa-2.0-api\1.0.1.Final\hibernate-jpa-2.0-api-1.0.1.Final.jar;"%REPO%"\javax\transaction\jta\1.1\jta-1.1.jar;"%REPO%"\cglib\cglib\2.2\cglib-2.2.jar;"%REPO%"\asm\asm\3.1\asm-3.1.jar;"%REPO%"\org\hibernate\hibernate-c3p0\3.6.7.Final\hibernate-c3p0-3.6.7.Final.jar;"%REPO%"\c3p0\c3p0\0.9.1\c3p0-0.9.1.jar;"%REPO%"\org\hibernate\hibernate-validator\4.2.0.Final\hibernate-validator-4.2.0.Final.jar;"%REPO%"\javax\validation\validation-api\1.0.0.GA\validation-api-1.0.0.GA.jar;"%REPO%"\joda-time\joda-time\2.0\joda-time-2.0.jar;"%REPO%"\com\thoughtworks\xstream\xstream\1.3.1\xstream-1.3.1.jar;"%REPO%"\xpp3\xpp3_min\1.1.4c\xpp3_min-1.1.4c.jar;"%REPO%"\org\eclipse\jetty\jetty-webapp\7.4.4.v20110707\jetty-webapp-7.4.4.v20110707.jar;"%REPO%"\org\eclipse\jetty\jetty-xml\7.4.4.v20110707\jetty-xml-7.4.4.v20110707.jar;"%REPO%"\org\eclipse\jetty\jetty-util\7.4.4.v20110707\jetty-util-7.4.4.v20110707.jar;"%REPO%"\org\eclipse\jetty\jetty-servlet\7.4.4.v20110707\jetty-servlet-7.4.4.v20110707.jar;"%REPO%"\org\eclipse\jetty\jetty-security\7.4.4.v20110707\jetty-security-7.4.4.v20110707.jar;"%REPO%"\org\eclipse\jetty\jetty-server\7.4.4.v20110707\jetty-server-7.4.4.v20110707.jar;"%REPO%"\javax\servlet\servlet-api\2.5\servlet-api-2.5.jar;"%REPO%"\org\eclipse\jetty\jetty-continuation\7.4.4.v20110707\jetty-continuation-7.4.4.v20110707.jar;"%REPO%"\org\eclipse\jetty\jetty-http\7.4.4.v20110707\jetty-http-7.4.4.v20110707.jar;"%REPO%"\org\eclipse\jetty\jetty-io\7.4.4.v20110707\jetty-io-7.4.4.v20110707.jar;"%REPO%"\org\mortbay\jetty\jsp-2.1-glassfish\2.1.v20100127\jsp-2.1-glassfish-2.1.v20100127.jar;"%REPO%"\org\eclipse\jdt\core\compiler\ecj\3.5.1\ecj-3.5.1.jar;"%REPO%"\org\mortbay\jetty\jsp-api-2.1-glassfish\2.1.v20100127\jsp-api-2.1-glassfish-2.1.v20100127.jar;"%REPO%"\ant\ant\1.6.5\ant-1.6.5.jar;"%REPO%"\testeheroku\testeheroku\0.0.1-SNAPSHOT\testeheroku-0.0.1-SNAPSHOT.jar
set EXTRA_JVM_ARGUMENTS=-Xmx512m
goto endInit

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS% %EXTRA_JVM_ARGUMENTS% -classpath %CLASSPATH_PREFIX%;%CLASSPATH% -Dapp.name="webapp" -Dapp.repo="%REPO%" -Dbasedir="%BASEDIR%" Main %CMD_LINE_ARGS%
if ERRORLEVEL 1 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=1

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@endlocal

:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
