Bibliothèque virtuelle
===================

Dans le cadre de notre 5ème année nous avons dû créer un site de E-Commerce dans le cadre d'un cours de gestion de projet logiciel avec l'entreprise ATOS. Cette bibliothèque virtuelle doit permettre de mutualiser, à travers le web, la gestion des ressources documentaires et bibliothécaires de l'école Neo School et de l’ensemble de ses partenaires internationaux.

----------

Projet
-------------
Dans cette partie nous allons présenter en détail notre projet en décrivant la partie visuelle, ainsi que la partie logique et architecturale. 

Fonctionnalité du projet :

La Bibliothèque Virtuelle doit permettre :
• le prêt d’ouvrages aux abonnés
• le suivi des prêts

Le site web doit disposer de deux espaces :
- un espace pédagogique permettant aux abonnés d’emprunter des ouvrages
• Etudiants
• Enseignants
– d’un espace privé réservé au bibliothécaire et à l’administrateur du système

Les principaux menus attendu sont :
• Menus
• Catalogue de livres disponible
• Possibilité de rechercher les livres selon les matières (Maths-Informatique etc...)
• Les nouveautés
• Une barre de recherche (par titre, par auteur, etc...)
• Un bouton pour s'abonner
• Affichage des livres
• Description des livres


#### <i class="icon-file"></i> Les vues
Présentation de l'ensemble des vues.

#### <i class="icon-file"></i> Architecture
Dans cette partie nous allons décrire l'ensemble de l'architecture de notre application JEE. Ainsi que l'ensemble des fonctionnalitées que nous avons embarquer à l'intérieur.

##### Spring MVC

Afin de réaliser notre projet avec la maximum de découplage possible nous avons utiliser un framework logiciel nommé Spring Web MVC. 

> **Note:**

> - Nous avons utilisé Spring afin de découvrir le monde des technologies utilisées en entreprise lors de projets JEE conséquent.

###### Petite Description de l'architecture 
Lors du développement d'un projet Spring, nous devons déclarer un dispatcher qui va analyser l'ensemble des requêtes provenants des clients et qui va diriger les requêtes aux contrôleurs de notre application.

Une fois que l'un des contrôleurs a fini d'analyser la requête il va retourner une vue directement à l'utilisateur à qui appartient la requête.

##### Le debug dans notre application

Afin de débuger notre application nous utilisons plusieurs bibliothèques de debug. Dans un premier temps nous utilisons un framework de test afin de tester unitairement l'ensemble des classes qui se nomme JUnit.

Afin de séparer le code métier des fonctionnalitées de notre logiciel nous utilisons une bibliothèque de debug nommé AspectJ. Nous utilisons cette bibliothèque logiciel pour par exemple séparé les messages de login du code métier afin d'éviter d'ajouter des fonctionnalitées pas nécessaire au fonctionnement de notre application.

Généralement, en Java nous utilisons des assert pour vérifier le bon fonctionnement d'un programme. Les assert de JUnit ne sont pas très intuitifs c'est pour cela que nous utilisons Hamcrest qui permet d'avoir des asserts très intuitifs.

En résumé, voici la liste des bibliothèques logiciels utilisé:

 - AspectJ
 - Spring-aop (intégration de aspect dans spring)
 - JUnit
 - Hamcrest

##### Persistance dans notre application
Dans notre application, nous utilisons une base de donnée de type MySql. Afin de simplifier l'intéraction avec cette base de donnée nous utilisons nous utilisons JdbcTemplate qui est un composant provenant du package core de spring.

Pour une table, nous aurons une classe représentant une ligne de la table, ainsi qu'une classe gérant l'ajout d'une nouvelle ligne, la récupération d'une ligne en particulier... Afn de récupérer l'ensemble des éléments d'un tableau dans le bon ordre il sera nécessaire de développer un wrapper récupérant la liste correspondante et la transformant dans le type d'objet de la liste.

