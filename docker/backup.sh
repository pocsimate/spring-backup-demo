#!/bin/bash
timestamp=$1

mariadb-dump --host=mariadb --port=3306 --user=test --password=test --databases demo > "dump_$timestamp.sql"
