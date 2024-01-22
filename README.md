# Getting Started

### Run DB
docker run -p 127.0.0.1:3306:3306  --name mdb -e MARIADB_ROOT_PASSWORD=Password123! -d mariadb:latest
### Init DB
From the db folder issue the following commands:

docker exec -i mdb mysql -u root -pPassword123! < 01-user-setup.sql

docker exec -i mdb mysql -u root -pPassword123! < 02-database-setup.sql