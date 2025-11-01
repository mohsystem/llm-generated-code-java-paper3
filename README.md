
# Run sonarqube scan

1- Add the right package name into the each generated file (if needed), using AddPackageStatment[AddPackageStatment.java](src%2Fmain%2Fjava%2FAddPackageStatment.java) class.

2- Run the com[Compiler.java](src%2Fmain%2Fjava%2FCompiler.java) class for testing and find code compilation errors, if any.

3- Move the folder into the source directory [java](src%2Fmain%2Fjava), and compile.

4- Then run build and sonarqube 
```
./gradlew build --parallel --daemon
sonar-scanner.bat -D"sonar.organization=mohkharma"
```