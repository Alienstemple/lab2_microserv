#!/usr/bin/env bash
set -e

# TODO для корректного создания схем в Postgres прописать свой вариант
<<<<<<< HEAD
export VARIANT=v2
=======
export VARIANT=v1
>>>>>>> ddcde107c68dd551d36121599899673804d9365a
export SCRIPT_PATH=/docker-entrypoint-initdb.d/
export PGPASSWORD=test
psql -U program -d services -f "$SCRIPT_PATH/schemes/schema-$VARIANT.sql"
