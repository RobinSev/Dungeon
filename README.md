# Dungeon game

## Context
This project has been realised in the third year of my computer science degree, for the programmation and design class. 
We were in a group of 2. We built it from scratch.

**Objective :** the overall objective was to make us work on a project requiring enough class to make us use design 
patterns to respect the SOLID principles. We were to make a dungeon game with very few specifications but a clear order
to focus on the model design and keep the functionalities, game mechanics and interface to their simpliest, as the game
in itself was not the actual objective of the project.

**My participation :** I handled most of the model design, and my partner focused more on the interface. We discussed 
regularly to find the best designs to minimise the cost of adding new elements, modifying what already existed (the 
balance of the game for example), and keep our code as simple as possible. 

## Evaluation criteria
We were evaluated on :

    * the overall quality of the code (readability, architecture, correctness).
    * the flexibilty of our code through the respect of the SOLID principles (how easy it is to add a fight 
        system, new characters, new items, etc).

## Grade
16.25/20

## Known issues 
Some issues remain, mostly linked to our priorisation, considering the evaluation criteria. Thus, we do not handle the 
perspective of the treasures, so they just vanish when they are looted, and always appear in front of the player's 
character when they are not, even if the player leaves through another door and comes back after.

For the same reason, dead enemies vanish. Which leads to a side effect : the fight being resolved automatically (as asked
by our teacher), the enemy dies before he can actually be renderer and visible to the player. Our attempts to pause the 
game for a second, for the enemy to be visible, were not successful. To see it, commenting the start of the fight in the
ViewModel class (package controller) is the only way.  
