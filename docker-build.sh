#!/usr/bin/env bash
name=tripstore-users-service
docker rmi "$name"
docker build . -t "$name"