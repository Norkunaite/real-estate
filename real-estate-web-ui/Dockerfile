FROM node:14.15-alpine

WORKDIR /app/estate-ui

COPY real-estate-web-ui/package*.json ./

RUN npm install -g @angular/cli && npm install

COPY real-estate-web-ui/ .

EXPOSE 4200

#CMD ["npm", "start"]
CMD ["ng","serve","--host", "0.0.0.0"]
