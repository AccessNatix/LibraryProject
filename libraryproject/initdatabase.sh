echo "###############################"
echo "## Generate xsd from xml file #"
echo "###############################"

java -jar bookdescription/trang.jar bookdescription/library.xml bookdescription/library.xsd
java -jar bookdescription/trang.jar bookdescription/init.xml bookdescription/init.xsd

echo "###############################"
echo "####### xsd generated #########"
echo "###############################"

echo "###############################"
echo "##### object generation #######"
echo "###############################"

xjc bookdescription/library.xsd -p com.libraryproject.inportordumpbdd.xsd -d src/main/java
xjc bookdescription/init.xsd -p com.libraryproject.inportordumpbdd.init -d src/main/java