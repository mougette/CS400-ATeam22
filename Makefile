.PHONY = make jar runjar test clean

# replace with path to your javac,java,jar,javafx installations
JC = "C:\Program Files\Java\jdk-11\bin\javac"     # replace with path to javac or javac.exe
JAR = "C:\Program Files\Java\jdk-11\bin\jar"     # replace with path to jar or jar.exe
JAVA = "C:\Program Files\Java\jdk-11\bin\java"    # replace with path to java or javaw.exe
MP = --"C:\Users\james\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml #-Dfile.encoding=UTF-8 
CP = -classpath "C:\Users\james\Documents\CS400\ATeam_Project;C:\Users\james\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib\javafx.base.jar;C:\Users\james\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib\javafx.controls.jar;C:\Users\james\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib\javafx.fxml.jar;C:\Users\james\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib\javafx.graphics.jar;C:\Users\james\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib\javafx.media.jar;C:\Users\james\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib\javafx.swing.jar;C:\Users\james\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib\javafx.web.jar;C:\Users\james\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib\javafx-swt.jar;C:\Users\james\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib\src.zip"
APP = application.Main

make: 
	$(JC) $(MP) $(CP) -d . application/*.java

run:
	$(JAVA) $(MP) $(CP) application.Main

fx: 
	$(JC) $(MP) $(CP) -d . application/*.java

fxrun:
	$(JAVA) $(MP) $(CP) $(APP)

jar: 
	$(JAR) cvmf manifest.txt executable.jar .

runjar:
	java $(MP) -jar executable.jar

zip:
	zip team.zip application/* *

clean:
	\rm application/*.class
	\rm executable.jar
