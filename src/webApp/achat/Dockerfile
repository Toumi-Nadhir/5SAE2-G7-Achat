FROM node:16-alpine3.11 as angular
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

EXPOSE 4200

FROM httpd:alpine3.15
WORKDIR /usr/local/apache2/htdocs
COPY --from=angular /app/dist/achat .
