

## Commande pour tuer le processus sur le port 8080

 sudo kill -9 $(sudo lsof -t -i :8080)

## Commande pour récupérer et exécuter l'image Docker

docker pull ghcr.io/ayrron/tp-back_info-910:main

docker run -d -p 8080:8080 --name tp-back ghcr.io/ayrron/tp-back_info-910:main
