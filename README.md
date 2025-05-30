# 🥪Sandwich Bytes🥪

## Description of the Project

Sandwich Bytes is an interactive Java console application that allows users to build and customize sandwich orders easily and intuitively. The application guides users through a clear menu-driven interface where they can:
Select sandwich sizes and bread types tailored to their preferences.

Users can:

- Pick a sandwich size and bread type

- Add meats, cheeses, sauces, and toppings

- Toast it or keep it fresh

- Add chips and drinks for a full meal

- Review their full order before checkout

- Save a receipt for later

- Even customize signature sandwiches like the Knuckle Sandwich or The Taternator

This project demonstrates core Java concepts such as object-oriented design, inheritance, and interfaces, while providing a real-world, user-friendly ordering experience. It’s a practical tool for practicing clean code principles and building a foundational understanding of interactive console applications.

![SandwichShopClassDiagram (1).png](ClassDiagramFolder/SandwichShopClassDiagram%20%281%29.png)


## Interesting Code Snippet

In the Sandwich class, I use Java Streams to build a readable list of sandwich toppings. Instead of manually looping through each topping and appending commas, I use this stream code:

String toppingsJoining = toppings.stream()
    .map(Toppings::getType)
    .collect(Collectors.joining(", "));

sb.append(toppingsJoining);

## User Stories

- As a user, I want to see a menu with clear options, so that I know what actions I can take and how to navigate the ordering process.

- As a user, I want to choose a sandwich size, so that I can order the best option for me.

- As a user, I want to select a bread type, so that I can order the best option for me.

- As a user, I want to select toppings for my sandwich so that I can customize my ingredients.

- As a user, I want to request my sandwich to either be toasted or not, so that I can order the best option for me.

- As a user, I want to add multiple sandwiches to my order, so that I can have order for myself and others in a single transaction.

- As a user, I want to add chips to my order, so that I can have a snack with my meal.

- As a user, I want to add a drink to my order, so that I can have a beverage with my meal.

- As a user, I want to review my full order before checking out, so that I can make sure it's all correct.

- As a user, I want to see the total cost of my order, so that I know how much I need to pay.

- As a user, I want to save a receipt after completing an order, so that I have a record of the transaction.

- As a user, I want the option to quit the application so that I can exit the program when I'm finished using it

- As a user, I want to select from a list of signature sandwiches, so that I can pick a specially made option.

- As a user, I want to add or remove toppings on the signature sandwich, so that I can personalize it.
## Setup
**🧾 Using the Application 🧾**
**You will be prompted to pick from the following**
1) New Order
0) Exit

**✨If you choose to start a new order, you’ll be guided through these menus:✨**

**Order Menu**
1) Create Sandwich
2) Signature Sandwiches
3) Add Chips
4) Add Drink
5) CHECKOUT
0) Cancel Order

**Sandwich Builder**

**Choose Size**
1) 4 inches
2) 8 inches
3) 12 inches

**Pick Your Bread**
1) White
2) Wheat
3) Rye
4) Wrap

**Choose Meat**
1) Steak
2) Ham
3) Salami
4) Roast Beef
5) Chicken
6) Bacon

**Pick Cheese**
1) American
2) Provolone
3) Cheddar
4) Swiss

**Regular Toppings**
1) Lettuce
2) Peppers
3) Onions
4) Tomatoes
5) Jalapenos
6) Cucumbers
7) Pickles
8) Guacamole
9) Mushrooms
0) Done adding toppings

**Sauces**
1) Mayo
2) Mustard
3) Ketchup
4) Ranch
5) Thousand Islands Sauce
6) Vinaigrette
0) Done adding sauces

**Select a Signature Sandwich**
1) The Knuckle Sandwich 
2) The Taternator Sandwich  
0) Return to previous menu

**Customize Signature Sandwiches**
1) Remove a topping
2) Add a new topping
0) Done customizing

**Chips Menu**
1) Potato
2) BBQ
3) Spicy

**Drink Menu**

**Pick a Size**
1) Small
2) Medium
3) Large

**Pick a Flavor**
1) Water
2) Soda
3) Juice

### Prerequisites

- IntelliJ IDEA: Ensure you have IntelliJ IDEA installed, which you can download from [here](https://www.jetbrains.com/idea/download/).
- Java SDK: Make sure Java SDK is installed and configured in IntelliJ.

### 🛠️ Running the Application in IntelliJ 🛠️

Follow these steps to get your application running within IntelliJ IDEA:

1. Open IntelliJ IDEA.
2. Select "Open" and navigate to the directory where you cloned or downloaded the project.
3. After the project opens, wait for IntelliJ to index the files and set up the project.
4. Find the main class with the `public static void main(String[] args)` method.
5. Right-click on the file and select 'Run 'SandwichBytes.main()'' to start the application.

## Technologies Used

- Java 17
- Intellij IDEA

## Demo

![Demo for Capstone 2.gif](Gif%20For%20Demo/Demo%20for%20Capstone%202.gif)

## Future Work
- Expand with sides like cookies, soups, or desserts.
- Rate your sandwich’s heat level based on toppings selected.
- Simulate how long the order would take in a real shop.
- Generate simple images to show what your sandwich looks like.


## 📝 Resources 📝

- [ChatGPT](https://openai.com/chatgpt) by OpenAI – for assistance with coding guidance, debugging, and understanding Java concepts.
- [GeeksforGeeks](https://www.geeksforgeeks.org/) – for reference articles and tutorials that helped deepen my understanding of programming topics.
- [Ray Maroun's GitHub](https://github.com/RayMaroun) – for code examples and guidance throughout the project.
- [Potato Sensei GPT](https://chatgpt.com/g/g-681d378b0c90819197b16e49abe384ec-potato-sensei) For help understanding Java concepts and getting guidance on my code.
- [Oracle Java User Interface Guide](https://www.oracle.com/java/technologies/jpl1-building-userinterface.html) – Helped me understand how to structure and build the user interface for my Java console app
- [Stackify – The Ultimate Guide to Java 8 Streams](https://stackify.com/streams-guide-java-8/) – Helped me understand and apply Java  Stream concepts in my project.

## Team Members


- **Julianna Vaccaro** -Developed this project as part of Java programming course to practice file handling, user input, and menu-driven applications.


## Thanks

- Thank you to my instructor, Raymond, for providing the class diagram and for your continuous support and guidance throughout the project.
- Thank you to my peers for always being willing to listen and support me when I needed it.
