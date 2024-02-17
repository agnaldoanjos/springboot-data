# Infra estrutura de banco

## Postgres
Para o projeto em questão será utilizado o banco postgres.

```
cd .\kafka

docker-compose up -d

```


docker volume create -d local --name db-data --opt device="/tmp/volume/data" --opt type="none" --opt o="bind"