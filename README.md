# Color Grid Standalone Application

## Running Color Grid Application Locally Command Line
Color Grid Application is a standalone java application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:


```
git clone https://github.com/sampathsl/ColorGridApplication.git
cd ColorGridApplication
mvn clean package
java -jar target\ColorGridApplication-1.0-SNAPSHOT.jar 20 20
```

> NOTE: You need to enter the row and column sizes as input arguments, if not entered it will use default 10 by 10 grid.

## Working with Color Grid Application in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 8 (full JDK not a JRE).
* git command line tool (https://help.github.com/articles/set-up-git)
* Your preferred IDE 
  * Eclipse with the m2e plugin. Note: when m2e is available, there is an m2 icon in `Help -> About` dialog. If m2e is
  not there, just follow the install process here: https://www.eclipse.org/m2e/
  * [Spring Tools Suite](https://spring.io/tools) (STS)
  * IntelliJ IDEA
  * [VS Code](https://code.visualstudio.com)

### Steps:

1) On the command line
    ```
    git clone https://github.com/sampathsl/ColorGridApplication.git
    ```
2) By using Eclipse or STS
    ```
    File -> Import -> Maven -> Existing Maven project
    ```
3) By using IntelliJ IDEA
   In the main menu, choose `File -> Open` and select the ColorGridApplication pom.xml. Click on the `Open` button.

   A run configuration named `ColorGridApplication` should have been created for you if you're using a recent Ultimate version.

# Response

Once run the application, you can see in the command prompt the randomly generated input color grid and out put result as the largest block with same color area, marked with `*` symbols.

# References

1) https://www.programiz.com/dsa/graph-dfs
2) https://www.geeksforgeeks.org/difference-between-bfs-and-dfs/

# License

The Color Grid Application is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).
