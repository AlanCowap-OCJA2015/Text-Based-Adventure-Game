if "%1" == "" (javac -cp ..\bin -d ..\bin *.java) ELSE (javac -cp ..\bin -d ..\bin %1)
