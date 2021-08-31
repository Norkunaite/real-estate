FROM openjdk:11

WORKDIR /app/estate

#jei atskirai rasom build komandas
COPY estate/target/*.jar ./app.jar
# jei kartu rasom build komandas^^
#COPY target/*.jar ./app.jar

EXPOSE $PORT

CMD [ "java", "-jar", "./app.jar" ]