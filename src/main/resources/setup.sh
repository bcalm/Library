#Start colima

colima start --cpu 4 --memory 12


#Start mssql

docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=test@123' -e 'MSSQL_PID=Express' -p '1433:1433' --name 'sqltest' -d mcr.microsoft.com/mssql/server:2019-latest

#set java version
export JAVA_HOME=`/usr/libexec/java_home -v 1.8`

#start kafka services

/Users/bcalm/work/petProject/confluent-5.1.0/bin/confluent start