FROM openjdk:11-jre-slim
#COPY . /usr/local/CORE_TIN_TXPENDINGSEND/
#WORKDIR /usr/local/CORE_TIN_TXPENDINGSEND/
COPY Configure /usr/local/Configure/
ADD target/CoreTinUpdateSigner-1.0-SNAPSHOT.jar app.jar
ENV PATH_CONFIG_CORE_TIN='/usr/local/Configure/'
#VOLUME /Configuration_TXPendingSend
CMD ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"] 
#EXPOSE 9001
