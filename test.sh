#!/bin/bash

#docker run --name testdb -p 4306:3306 -e MYSQL_ROOT_PASSWORD=root -d mariadb/server:10.3
mysql --user="root" -proot --execute="CREATE SCHEMA IF NOT EXISTS demo_test;"
mysql --user="root" -proot demo_test < src/main/resources/migration/V1.1__create_employee_table.sql
mysql --user="root" -proot demo_test < src/main/resources/migration/V1.2__seed_employees.sql
gradle clean build test
gradle check > build.out
mysql --user="root" -proot --execute="DROP SCHEMA IF EXISTS demo_test;"
#docker stop testdb
#docker rm $(docker images | grep mariadb | awk '{print $3}')