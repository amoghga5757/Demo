#!/bin/bash

# Clean up old containers and images
docker container prune -f
docker image prune -f
docker volume prune -f  # If you want to remove unused volumes too
docker network prune -f  # If you want to remove unused networks

# Remove old containers
docker compose -f "docker-compose.yml" down 

# Updates new changes to the container
docker compose -f "docker-compose.yml" up -d --build 
