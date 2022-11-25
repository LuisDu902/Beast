## LPOO_66 - Beast_1984

Your goal in this game is to kill every Beast that appears in your way, in the shortest time possible. You're trapped in a maze of movable blocks, and the only way to survive is by smashing your enemies between them. This might seem like an easy task, but as eggs evolve to Beasts, and its number increases, you'll soon realise that the power-ups will come in handy.

There's the option to choose from three different levels of difficulty but, regardless of your choice, the map will always be randomised. Once you win (or lose) the game, you'll be presented a scoreboard so that you can keep track of your performance improvements.

This project is being Beastly developed by Athos Freitas (up202108792), Luís Du (up202105385) and Sofia Pinto (up202108682) for LP00 2022/2023.


### IMPLEMENTED FEATURES

**Move blocks** - Whenever the player moves, if it goes against a movable block, every linked block in that direction gets pushed.

<img width="320" alt="Move_Blocks" src="https://user-images.githubusercontent.com/92641892/203945409-cd450b57-fd60-4006-9c7e-0231b148822f.png">

**Kill Beast** - In order for a Beast to be killed, it has to be smashed between any two blocks or a block and a wall.

<img width="320" alt="KillBeast" src="https://user-images.githubusercontent.com/92641892/203945404-4ce4b828-c25c-4919-ab96-da2e5d7e4935.png">

**Catch Heart** - Hearts will randomly appear on the map as the game progresses. However, they might be inadvertently smashed between blocks. They can either be caught:
    **by the Player** - In this case, one heart is added to the players lives, unless the maximum number has already been achieved
    **by the Beasts** - In the unfortunate scenario that a Beast catches a heart, it evolves to a Stronger Beast, unless it is already one.

<img width="320" alt="CatchHeart" src="https://user-images.githubusercontent.com/92641892/203945401-68a1e6fd-d627-4be4-ae5d-f73a5a42a059.png">

**Catch Shield by Beast** - As beasts are a unified entity, whenever a shield is caught by a Beast, all Beasts get a speed up buff.

**Beasts follow player** - The movement of the Beasts is randomised in the direction of the Player (for instance, if the Player is on the top-left of the Beast it can only move up, left or in that diagonal)

<img width="160" alt="BeastsFollow" src="https://user-images.githubusercontent.com/92641892/203988462-aa79f28e-d967-49cb-ab10-c26e6652b56a.png">

**Respawn** - When the player takes damage it respawns at a random location of the map.

<img width="320" alt="Respawn" src="https://user-images.githubusercontent.com/92641892/203945412-4fa9f8a7-429d-4c53-bc41-17a0108fb042.png">


### PLANNED FEATURES

**Improved graphics** - This is how we expect our characters to look like in the near future:

<img width="320" alt="Characters " src="https://user-images.githubusercontent.com/92641892/203790476-3f3cb113-7137-41bd-b7a8-422e334bdfc5.png">

**Timer** - the longer it takes to kill all Beasts, the fewer points the player scores.

<img width="320" alt="Timer " src="https://user-images.githubusercontent.com/92641892/203790569-01ba51e2-643b-4863-9e92-abdb643e4fbb.png">

**Kill Stronger Beast** - For a Stronger Beast to be killed, it necessarily has to be smashed against a wall.

<img width="320" alt="KillStrongerBeast1 " src="https://user-images.githubusercontent.com/92641892/203790649-75551afc-d337-4dca-8440-05d2faf7730f.png">
<img width="320" alt="KillStrongerBeast2 " src="https://user-images.githubusercontent.com/92641892/203790656-1706a4b6-0ad1-4324-86fc-8367b29d6c11.png">

**Catch Shield by Player** - A shield will turn the player immortal, for a short period of time (which varies according to the level’s difficulty).

<img width="320" alt="Shield " src="https://user-images.githubusercontent.com/92641892/203790659-721b6c42-b3f9-47ac-9037-657687f1ab0f.png">

**Hatching Eggs** - After some time eggs hatch into Beasts.

<img width="320" alt="Eggs " src="https://user-images.githubusercontent.com/92641892/203790856-e22d13a6-be63-4af2-ade4-46e15439c2d1.png">

**Scoreboard** - At the end of the game, you’ll be presented a scoreboard. The score is calculated based on the number of remaining lives and the amount of Beast’s killed, as well as the time it took the player to do it.

<img width="320" alt="Scoreboard " src="https://user-images.githubusercontent.com/92641892/203790857-d2e2b76f-3809-413e-a69b-f2657daf5980.png">


### Class Diagram (UML)

![UML_LDTS](https://user-images.githubusercontent.com/92641892/204031997-64967635-d946-4bd1-b2e5-cc4e20640eb2.png)


### DESIGN

#### Game and Menu States

**Problem in Context**

This project behaves differently, depending on which “part” is currently running. For instance, in the main menu it’s not desirable that a Beast appears out of nowhere, or that the scoreboard pops up during the game.

**State Pattern**

This pattern allows an object to modify its behaviour when its internal state changes. Therefore, we can smoothly switch from one state of the game to the other.

**Implementation**

![StatePattern](https://user-images.githubusercontent.com/92641892/204031328-9aba04ad-06d6-4681-890a-89ac5fdcd4d4.png)

Classes:

- [State](../src/main/java/org.l06gr06/states/State.java)
- [MainMenuState](../src/main/java/org.l06gr06/states/MainMenuState.java)
- [LevelMenuState](../src/main/java/org.l06gr06/states/LevelMenuState.java)
- [ScoreMenuState](../src/main/java/org.l06gr06/states/ScoreMenuState.java)
- [GameState](../src/main/java/org.l06gr06/states/GameState.java)


**Consequences**

This way, we avoid using conditionals, plus, we make state transitions explicit, by creating a sub-class (state) for each one of them.


#### THE GAME SHOULD RUN SMOOTHLY REGARDLESS OF A USER'S INPUT, OR LACK THEREOF.

**Problem in Context**

As the player's goal in this game is to kill every Beast to survive, the game keeps running even when the user isn’t providing input. If you sit staring at the screen, the game doesn’t freeze. Animations keep animating. Visual effects dance and sparkle. If you’re unlucky, beasts catch powerups and keep chomping on your player.


**Game Loop Pattern**

This pattern allows a game loop to run continuously during gameplay. Each turn of the loop, it processes user input without blocking, updates the game state, and renders the game. It tracks the passage of time to control the rate of gameplay. This pattern allows us to address the identified problems because it ensures that the state of the game accurately reflects what it is meant to be, if some time has passed since the last update.

**Implementation**

![GameLoopPattern](https://user-images.githubusercontent.com/92641892/204030885-69ed17c8-352a-4acf-ba92-281d84f3ab15.png)

Classes:

- [GameController](../src/main/java/org.l06gr06/controller/game/GameController.java)
- [Arena](../src/main/java/org.l06gr06/model/game/arena/Arena.java)
- [GameViewer](../src/main/java/org.l06gr06/viewer/game/GameViewer.java)

**Consequences**

The use of the Game Loop Pattern in the current design decouples progression of game time from user input and processor speed.


#### CONTROLLERS AND VIEWERS

**Problem in Context**

As the game changes its state, each state has its own controller and viewer. When running, the game doesn't know what "types" of controller and viewer will be required to create.

**Factory Method**

This pattern defines an interface for creating an object, but let subclasses decide which class to instantiate. The Factory method lets a class defer instantiation it uses to subclasses. It allowed to address the identified problems as it creates objects without exposing the instantiation logic to the client (therefore allowing for higher abstraction and cleaner code)

**Implementation**

![FactoryMethodPattern](https://user-images.githubusercontent.com/92641892/204030890-a847116f-41f2-4859-9f63-a9d8ca98f092.png)

Classes:

- [State](../src/main/java/org.l06gr06/states/State.java)
- [MainMenuState](../src/main/java/org.l06gr06/states/MainMenuState.java)
- [LevelMenuState](../src/main/java/org.l06gr06/states/LevelMenuState.java)
- [ScoreMenuState](../src/main/java/org.l06gr06/states/ScoreMenuState.java)
- [GameState](../src/main/java/org.l06gr06/states/GameState.java)
- [Controller](../src/main/java/org.l06gr06/controller/Controller.java)
- [MainMenuController](../src/main/java/org.l06gr06/controller/menu/MainMenuController.java)
- [LevelMenuController](../src/main/java/org.l06gr06/controller/menu/LevelMenuController.java)
- [ScoreMenuController](../src/main/java/org.l06gr06/controller/menu/ScoreMenuController.java)
- [GameController](../src/main/java/org.l06gr06/controller/game/GameState.java)
- [Viewer](../src/main/java/org.l06gr06/viewer/Viewer.java)
- [MainMenuController](../src/main/java/org.l06gr06/viewer/menu/MainMenuViewer.java)
- [LevelMenuController](../src/main/java/org.l06gr06/viewer/menu/LevelMenuViewer.java)
- [ScoreMenuController](../src/main/java/org.l06gr06/viewer/menu/ScoreMenuViewer.java)
- [GameController](../src/main/java/org.l06gr06/viewer/game/GameViewer.java)

**Consequences**

The use of the Factory Pattern in the current design promotes the loose-coupling by eliminating the need to bind application-specific classes into the code. That means the code interacts solely with the resultant interface or abstract class, so that it will work with any classes that implement that interface or that extends that abstract class.


#### MVC - Model, View, Controller

**Problem in Context** 

This project uses a GUI (Lanterna) to display the game and allow input by the player. It would become very confusing to handle the implementation of the game, take the inputs of the player and display everything in the same class. For example, having the Player class hold methods for taking input of the movement, for moving the Player and for showing it on screen would be confusing and hard to work on.

**MVC Pattern**

This Architectural pattern separates the implementation of classes into three different groups: 
The model classes - which represent the data; 
The viewer classes - which display the information using Lanterna GUI;
The controller classes - which also uses the GUI to get the next action (step) and alters the data accordingly.

**Implementation**

![MVCPattern](https://user-images.githubusercontent.com/92641892/204032373-4457dad8-e9a3-4913-bb0c-3173d946ef31.png)

Packages:

- [Model Package](../src/main/java/org.l06gr06/model)
- [Viewer Package](../src/main/java/org.l06gr06/viewer)
- [Controller Package](../src/main/java/org.l06gr06/controller)

**Consequences**

This way, the program is subdivided in a way that is easier to work on (keeping the code organised) and test.


### TESTING

Here is the [link](../pitest/index.html) to our mutation testing report.

![CoverageReport](https://user-images.githubusercontent.com/92641892/204018185-2d468e8b-ec80-40a5-bb08-b884fcaac90a.png)


### SELF-EVALUATION

We believe that, up to the present time, the work was evenly distributed among all group members.

- Athos: 33%
- Luís: 34%
- Sofia: 33%
