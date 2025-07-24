🧩 Sudoku Game
This is a Java-based Sudoku game project, designed to be run and debugged within Visual Studio Code. The game board is initialized using a specific set of arguments passed directly to the Java application.

✨ Features
Custom Board Initialization: The game board can be constructed using a string of instructions passed as command-line arguments.

Fixed Cells: Supports marking certain cells as immutable (pre-filled numbers) to define the puzzle.

Interactive Gameplay (Planned/Implied): (Assuming the game will allow user input to solve the puzzle.)

🚀 How to Run
To get this project up and running on your local machine, follow these steps:

Prerequisites
Java Development Kit (JDK): Version 11 or higher.

Visual Studio Code: The popular code editor.

Java Extension Pack for VS Code: Install from the VS Code Marketplace (includes Language Support for Java™ by Red Hat, Debugger for Java, etc.).

Setup Instructions
Clone the Repository:

git clone https://github.com/your-username/sudoku-game.git
cd sudoku-game

(Replace https://github.com/your-username/sudoku-game.git with your actual repository URL).

Open in VS Code:
Open the cloned sudoku-game folder in Visual Studio Code.

Configure launch.json:
The game requires specific board instructions to be passed as arguments. You need to configure the launch.json file in your .vscode folder.

If you don't have a .vscode/launch.json file, go to the Run and Debug tab (Ctrl+Shift+D or Cmd+Shift+D) in VS Code and click on "create a launch.json file", then select "Java".

Locate the configuration for your main class (e.g., com.yourproject.sudoku.Game).

Add or modify the "args" property to include the board instructions as individual string elements.

Here's an example of how your launch.json configuration should look:

{
    "configurations": [
        {
            "type": "java",
            "name": "Launch Sudoku Game with Board Data",
            "request": "launch",
            "mainClass": "com.seuprojeto.sudoku.Game", // **IMPORTANT: Replace with your actual main class path**
            "projectName": "sudoku-game", // **IMPORTANT: Replace with your actual project name (e.g., from pom.xml or build.gradle)**
            "args": [
                "0,0;4,false",
                "1,0;7,false",
                "2,0;9,true",
                "3,0;5,false",
                "4,0;8,true",
                "5,0;6,true",
                "6,0;2,true",
                "7,0;3,false",
                "8,0;1,false",
                "0,1;1,false",
                "1,1;3,true",
                "2,1;5,false",
                "3,1;4,false",
                "4,1;7,true",
                "5,1;2,false",
                "6,1;8,false",
                "7,1;9,true",
                "8,1;6,true",
                "0,2;2,false",
                "1,2;6,true",
                "2,2;8,false",
                "3,2;9,false",
                "4,2;1,true",
                "5,2;3,false",
                "6,2;7,false",
                "7,2;4,false",
                "8,2;5,true",
                "0,3;5,true",
                "1,3;1,false",
                "2,3;3,true",
                "3,3;7,false",
                "4,3;6,false",
                "5,3;4,false",
                "6,3;9,false",
                "7,3;8,true",
                "8,3;2,false",
                "0,4;8,false",
                "1,4;9,true",
                "2,4;7,false",
                "3,4;1,true",
                "4,4;2,true",
                "5,4;5,true",
                "6,4;3,false",
                "7,4;6,true",
                "8,4;4,false",
                "0,5;6,false",
                "1,5;4,true",
                "2,5;2,false",
                "3,5;3,false",
                "4,5;9,false",
                "5,5;8,false",
                "6,5;1,true",
                "7,5;5,false",
                "8,5;7,true",
                "0,6;7,true",
                "1,6;5,false",
                "2,6;4,false",
                "3,6;2,false",
                "4,6;3,true",
                "5,6;9,false",
                "6,6;6,false",
                "7,6;1,true",
                "8,6;8,false",
                "0,7;9,true",
                "1,7;8,true",
                "2,7;1,false",
                "3,7;6,false",
                "4,7;4,true",
                "5,7;7,false",
                "6,7;5,false",
                "7,7;2,true",
                "8,7;3,false",
                "0,8;3,false",
                "1,8;2,false",
                "2,8;6,true",
                "3,8;8,true",
                "4,8;5,true",
                "5,8;1,false",
                "6,8;4,true",
                "7,8;7,false",
                "8,8;9,false"
            ]
        }
    ]
}

Run the Application:

Go to the Run and Debug tab in VS Code.

Select the configuration named "Launch Sudoku Game with Board Data" (or whatever name you gave it) from the dropdown menu at the top.

Click the green play button (Start Debugging) or press F5.

The game should launch, and your Java application will receive each instruction as a separate argument in the String[] args array of your main method.

Argument Format Explained
Each argument represents a single cell's initial state and follows the format:

row,column;value,isImmutable

row: The row index (0-8).

column: The column index (0-8).

value: The integer value for the cell (1-9).

isImmutable: A boolean (true or false) indicating if the cell's value can be changed by the player. true means it's a pre-filled puzzle number.

Example:

0,0;4,false: Sets the cell at row 0, column 0 to value 4, and it is mutable (can be changed).

2,0;9,true: Sets the cell at row 2, column 0 to value 9, and it is immutable (cannot be changed).

💻 Technologies Used
Java

Visual Studio Code

🤝 Contributing
Feel free to fork this repository, make improvements, and submit pull requests.

📄 License
This project is licensed under the MIT License - see the LICENSE file for details.