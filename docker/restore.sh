#!/bin/bash
filename=$1

mariadb --host=mariadb --port=3306 --user=test --password=test demo < "$filename"
