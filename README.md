# Projet donjon réalisé par Loïc NEYRAT et Robin SEVERAC.

Notre jeu consiste à parcourir un donjon jusqu'à avoir rempli le ou les objectifs qui sont les conditions de victoire. 
Dans chaque salle, vous serez susceptible de rencontrer un ennemi, de voir un ou plusieurs trésors et de déclencher un 
ou plusieurs pièges.

Par défaut, la condition de victoire est de parcourir 20 salles différentes. D'autres conditions de victoire sont implémentées
(trouver un item de quête, et vaincre 20 ennemis). Pour les tester, il suffit de les créer dans le constructeur de la classe
Game. Attention : si vous créez plusieurs conditions de victoire, il vous faudra remplir toutes ces conditions pour
gagner la partie.

Au début d'une partie, vous pouvez choisir votre système de combat, donner votre nom et choisir votre personnage. Pour
mourir facilement et tester la mort, nous vous conseillons le promeneur non préparé. 

Lorsque vous vous déplacez, vous vous orientez automatiquement dans la direction du mouvement : la porte que vous 
avez utilisé pour entrer est derrière vous. Par conséquent, si vous allez vers le sud, la flèche "up" va vous faire 
continuer d'avancer vers le sud. La flèche sur laquelle vous appuyez ne correspond donc pas forcément au mouvement
visible sur la grille : up ne vous fera pas nécessairement aller vers le haut dans la grille.  

Nous avons choisi de prioriser sur la conception plutôt que sur la qualité générale du jeu, de ses mécaniques et de l'équilibrage. 
Ainsi, les combats se déroulent automatiquement et instantanément (ce qui reste conforme à l'énoncé donné). 

L'interface graphique manque de polish, sur les points suivants : 

* Les ennemis ne s'affichent pas à l'entrée de la pièce. C'est lié au fait que le combat se déroule quasi-instantanément
et que le Thread.sleep (que vous pouvez voir commenté dans la méthode fight du ViewModel) semble aussi mettre en pause 
le rendu de l'ennemi. Vous pouvez néanmoins voir que l'ennemi "devrait" s'afficher : il suffit d'empêcher le fight (en 
commentant l'appel à cette méthode dans la classe ViewModel, package controller).

* Les coffres disparaissent une fois lootés. Cela est lié au fait que l'affichage des coffres n'est pas cohérente : 
les coffres sont toujours affichées en face de vous, donc si vous quittez la salle par une autre porte pour ensuite 
y revenir les coffres se téléporteront. Nous avons des pistes pour améliorer ça (attribuer une direction absolue aux 
ImageView, en créant une entité au dessus d'elles, et manipuler ces entités dans les renderer), mais les implémenter 
prendrait trop de temps et nécessiterait trop de modifications à cette étape du projet. Nous avons donc décidé de faire 
avec tant que les coffres ne sont pas lootés (ils se téléporteront dans la pièce), et de les faire disparaître une fois 
looté.

* Les ennemis disparaissent une fois vaincus. Nous n'affichons pas de corps. Encore une fois, ce n'est pas une difficulté
technique lié au modèle (il suffit de vérifier si l'ennemi d'une salle est mort ou non et d'adapter le rendu), 
mais nous avons préféré prioriser sur la résolution des bugs et l'amélioration de la conception plutôt que de chercher 
les images et de les réadapter à la perspective. Et nous aurions encore eu les soucis de cohérence de l'orientation du 
corps si vous revenez dans la salle par une autre porte.

* Il y a peu de feed-back lorsque vous prenez des dégâts. Seule la barre de vie évolue. 

Cependant, il s'agit là de problèmes graphiques, dont Basile nous avait dit qu'ils n'étaient pas important, dès lors que 
le modèle était correctement conçu (c'est-à-dire répondait aux principes SOLID et facilitait les évolutions). 
De ce point de vue, le modèle rend très facile l'ajout de nouveaux personnages, de systèmes de combat personnalisés, 
la personnalisation des différents aspects de la génération des pièces, de leur affichage au sein de l'interface, ou encore 
l'ajout de nouveaux items. Seule contrainte : ajouter également leur nom de classe canonique (donc entier) dans le fichier 
correspondant dans le package src.main.resource.constituents, afin de les rendre utilisables en jeu.

Bon jeu ! (Même si nous nous faisons peu d'illusion sur le plaisir que vous pourriez avoir à y jouer)
