FROM ubuntu
RUN apt-get update 
RUN apt-get install --assume-yes apache2 
RUN apt-get install --assume-yes apache2-utils 
RUN apt-get --assume-yes install wget
RUN apt-get --assume-yes install unzip
RUN apt-get clean
#RUN wget https://github.com/SAP/openui5/releases/download/1.108.8/openui5-runtime-1.108.8.zip -P /var/www/html/
#RUN unzip -o /var/www/html/openui5-runtime-1.108.8.zip -d /var/www/html/
#RUN rm /var/www/html/openui5-runtime-1.108.8.zip
RUN wget https://github.com/SAP/openui5/releases/download/1.71.36/openui5-runtime-1.71.36.zip -P /var/www/html/
RUN unzip -o /var/www/html/openui5-runtime-1.71.36.zip -d /var/www/html/
RUN rm /var/www/html/openui5-runtime-1.71.36.zip
COPY apache2.conf /etc/apache2/apache2.conf
RUN a2enmod headers && service apache2 restart
EXPOSE 80
CMD ["apache2ctl", "-D","FOREGROUND"]