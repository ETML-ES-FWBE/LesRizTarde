## Table des matières

1. [🚀 À propos](#-à-propos)
2. [🎓 Prérequis](#-prérequis)
3. [📝 Exécuter le projet](#-exécuter-le-projet)
4. [📚 Documentation](#-documentation)
    - [Accéder à l'application](#accéder-à-lapplication)


## 🚀 À propos

Cette application de gestion des étudiants et des notes, construite avec **Spring Boot** et **MySQL**, permet de gérer les informations des étudiants et leurs notes à travers une API RESTful. Il est également possible de déployer l'application via **Docker** pour la gestion des environnements et l'intégration continue.


## 🎓 Prérequis
Avant de commencer, assurez-vous d'avoir installé et configuré les outils suivants :

- **JDK 11 ou supérieur**
- **Maven** pour la gestion des dépendances
- **Docker** pour la gestion des conteneurs et la mise en place de la base de données MySQL
- **IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)** pour le développement Java


## 📝 Exécuter le projet

Pour compiler et exécuter le projet avec Docker, suivez ces étapes :

```shell
# Ouvrir un terminal (Invite de commandes ou PowerShell sur Windows, Terminal sur macOS ou Linux)

# Assurez-vous que Git est installé

# Cloner le repository
git clone https://github.com/ETML-ES-FWBE/LesRizTarde.git

# Naviguer dans le dossier du projet
cd LesRizTarde

# Démarrer le Docker Engine

# Lancer la commande Docker Compose pour construire et démarrer tous les services
docker-compose up --build

# Accéder au conteneur MySQL et ouvrir une session interactive
docker exec -it spring-boot-mysql mysql -u root -p

```

## 📚 Documentation

### Accéder à l'application
Une fois les conteneurs en cours d'exécution, vous pouvez accéder à l'API REST via http://localhost:8080. Vous pouvez tester les différentes méthodes **GET, POST, PUT,** et **DELETE** pour manipuler les entités comme Student et Grade.

Exemple de requête curl :
```shell
#Récupérer toutes les notes
curl -X GET http://localhost:8080/grades
```

## 🏗 Architecture du Projet

### 📂 Organisation des packages
Config/ → Contient DataLoader.java pour le chargement initial des données.

Controllers/ → Gère les requêtes HTTP et les réponses.

Entities/ → Définit les modèles de données (Student, Grade).

Exceptions/ → Gère les exceptions personnalisées (GradeNotFoundException.java, StudentNotFoundException.java).

Repositories/ → Interfaces JPA pour la gestion des bases de données.

Services/ → Contient la logique métier (gestion des étudiants et des notes).

PayrollApplication.java → Point d’entrée de l’application.

[Back to top](#top)