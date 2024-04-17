FROM postgres

ENV POSTGRES_PASSWORD postgres

COPY ./create_table.sql /docker-entrypoint-initdb.d/
