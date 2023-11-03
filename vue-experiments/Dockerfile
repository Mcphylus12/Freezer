FROM node as builder
WORKDIR /node
COPY . .
RUN npm install && npm run build

FROM nginx as host
COPY --from=builder /node/dist /usr/share/nginx/html