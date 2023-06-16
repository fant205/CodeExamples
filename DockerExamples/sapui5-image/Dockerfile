FROM node:12.16.1
WORKDIR /usr/app
RUN npm set @sap:registry=https://npm.sap.com
COPY . .
RUN npm install
EXPOSE 80
CMD ["npm","start"]








#FROM ubuntu
#RUN apt-get update
#RUN apt-get install --assume-yes apache2
#RUN apt-get install --assume-yes apache2-utils
#RUN apt-get --assume-yes install wget
#RUN apt-get --assume-yes install unzip
#RUN apt-get clean
#RUN wget https://tools.eu1.hana.ondemand.com/additional/sapui5-rt-1.94.1.zip -P /var/www/html/
#RUN unzip -o /var/www/html/sapui5-rt-1.94.1.zip -d /var/www/html/
#RUN rm /var/www/html/sapui5-rt-1.94.1.zip
#COPY apache2.conf /etc/apache2/apache2.conf
#RUN a2enmod headers && service apache2 restart
#EXPOSE 80
#CMD ["apache2ctl", "-D","FOREGROUND"]