#Main class

if [ $1 ]
then
  mvn compile exec:java -Dexec.mainClass="com.javabyexamples.java.core.$1"
else
mvn compile exec:java -Dexec.mainClass="com.javabyexamples.java.core.Main"
fi
