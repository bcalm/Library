#stop docker
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)

#Stop colima

colima stop

#set java version
export JAVA_HOME=`/usr/libexec/java_home -v 1.8`

#start kafka services

/Users/bcalm/work/petProject/confluent-5.1.0/bin/confluent stop