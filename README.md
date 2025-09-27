
Run sonarqube scan

1- Add the package name into the each generated file, using AddPackageStatment[AddPackageStatment.java](src%2Fmain%2Fjava%2FAddPackageStatment.java) class.

2- Run the com[Compiler.java](src%2Fmain%2Fjava%2FCompiler.java) class

3- Move the folder into the source directory [java](src%2Fmain%2Fjava), and compile.

4- Then run sonarqube 
```
sonar-scanner.bat -D"sonar.organization=mohkharma"
```