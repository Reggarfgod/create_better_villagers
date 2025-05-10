@echo off
setlocal
for /f "tokens=2 delims=:." %%x in ('chcp') do set _codepage=%%x
chcp 65001>nul
cd D:\Download\MOD\create_better_villagers\run
"C:\Users\Anoop Singh\.jdks\temurin-21.0.7\bin\java.exe" @D:\Download\MOD\create_better_villagers\build\moddev\clientRunClasspath.txt @D:\Download\MOD\create_better_villagers\build\moddev\clientRunVmArgs.txt -Dfml.modFolders=create_better_villagers%%%%D:\Download\MOD\create_better_villagers\build\classes\java\main;create_better_villagers%%%%D:\Download\MOD\create_better_villagers\build\resources\main net.neoforged.devlaunch.Main @D:\Download\MOD\create_better_villagers\build\moddev\clientRunProgramArgs.txt
if not ERRORLEVEL 0 (  echo Minecraft failed with exit code %ERRORLEVEL%  pause)
chcp %_codepage%>nul
endlocal