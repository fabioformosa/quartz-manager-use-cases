#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE USER quartzmanagerusecase PASSWORD 'quartzmanagerusecase';
	CREATE DATABASE "quartzmanager-usecase";
	GRANT ALL PRIVILEGES ON DATABASE "quartzmanager-usecase" TO quartzmanagerusecase;
EOSQL