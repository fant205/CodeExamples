FROM node:16.16.0

WORKDIR /usr/app

# RUN npm set @sap:registry=https://npm.sap.com
RUN npm set @sap:registry=http://registry.npmjs.org/

COPY . .

RUN npm install

EXPOSE 80

CMD ["npm","start"]
