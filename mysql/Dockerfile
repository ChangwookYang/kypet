# docker build -t pet-mysql-image .
# docker run -d --name mysql-container -p 3306:3306 pet-mysql-image
# docker exec -it mysql-container mysql -u root -p
# CREATE DATABASE petdb;
# CREATE USER 'pet'@'%' IDENTIFIED BY '1234';
# GRANT ALL PRIVILEGES ON petdb.* TO 'pet'@'%';
# FLUSH PRIVILEGES;

FROM mysql:latest

# MySQL 설정
ENV MYSQL_ROOT_PASSWORD=1234
ENV MYSQL_DATABASE=petdb
ENV MYSQL_USER=pet_admin
ENV MYSQL_PASSWORD=1234

# 포트 설정 (기본 MySQL 포트는 3306)
EXPOSE 3306

# Copy the custom MySQL configuration file
# COPY my.cnf /etc/mysql/my.cnf