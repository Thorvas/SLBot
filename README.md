
# SL Bot

Margonem MMORPG bot designed in Selenium with usage of Java, Spring Core, and Lombok. It is planned to add database connections for optimization cases.

Currently bot is able to move around but A* algorithm is yet to be implemented. Bot is probably 100% undetectable since website cannot interact with user's processes simulating real user input.




## AntiBot

What do we know about anti-bot in Margonem?

Currently we are able to pinpoint several cases of checks (will be added frequently):

  - Code is performing ```isTrusted ``` checks on input sent by user. If ```isTrusted``` is equal to false, AntiBot will be alerted.




## Documentation

Documentation of Margonem code useful for programmers to precisely manipulate code. It will be developed and maintained.

Documentation includes instructions of new version of Margonem engine. Old version will not be supported since it is obsolete. 

Currently we could pinpoint some useful instructions and objects:

  - ```Engine``` - the object containing the most useful parts of code. It includes the player, map, etc.
    - ```Engine.hero``` - the object containing data about current player. It includes his position (x, y), health, stats, etc. It is NOT recommended to use any functions related to movement directly since it causes AntiBot to be alerted (these functions have callbacks checking if function was followed by TRUSTED user input)
      - ```Engine.hero.getHeroNode() ``` - this instruction is important for map data. Map data stored in ```Engine.map``` isn't fully exposed and ```Engine.hero.getHeroNode()``` is a function for checking Node of player's current position to check whether player could collide with terrain BUT additionally this function returns us information about nodes of the map. Useful for pathfinding algorithms.
    - ```Engine.map.col.check(x, y) ``` - checks whether player is able to access node. Returns ```0``` if player doesn't collide, ```1``` if player will collide and cannot step on the node and ```2``` if some NPC is standing on the node
    - ```Engine.npcs``` - this object contains information about npcs appearing on the map. If we want to get a precise information or list of current NPC's on the map, we can issue instruction ```Engine.npcs.check()```
  - ```_g``` - function responsible for sending API requests. This section will be expanded with additional information